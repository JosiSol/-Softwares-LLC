package Memory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.HashSet;
import java.util.Set;

// Add a function that resets all the cards and scores when the triangle is clicked
public class CardGame extends JPanel implements MouseListener, ActionListener {
    static volatile public int gridSize;  // Grid size, shared across instances
    private final int[] row = {4, 5, 6}, // Possible row configurations
            col = {3, 4, 6},              // Possible column configurations
            vl = {70, 40, 20},            // Vertical gaps
            hl = {100, 50, 10},           // Horizontal gaps
            nc = {4 * 3, 5 * 4, 6 * 6};   // Number of cards for each grid size

    Player p1;
    Player p2;
    JPanel gridPanel;

    static volatile boolean stillOn = true;   // Game status flag
    private final JLabel tri, playerTurn;

    private final Random rnd = new Random();  // Random number generator
    private final Timer t = new Timer(400, this);   // Timer for card flip delay
    private final Timer end = new Timer(500, e -> { // Timer for game end check
        if (p1.getScore() + p2.getScore() == nc[CardGame.gridSize] / 2) {
            this.removeAll();              // Remove all components
            this.repaint();                // Repaint panel
            this.add(new Winner(p1.getScore() - p2.getScore())); // Add winner component

            stillOn = true;                // Reset game status
            this.restore();                // Restore initial game state
        }
    });
    private Font gameFont;                // Custom game font
    private final JLabel[] score;         // Score labels
    ImageIcon backgroundImg = new ImageIcon("Assets/gameBackground.jpg");
    ImageIcon backButtonImg = new ImageIcon("Assets/backButton.png");
    JLabel background = new JLabel(backgroundImg);
    JLabel backButton = new JLabel(backButtonImg);
    Card[] cardArr = new Card[50];
    Toolkit tk = Toolkit.getDefaultToolkit(); // Toolkit for custom cursor
    Image newCur1 = tk.getImage("Assets/cursorMain.png"); // Main cursor image
    Image turnCur = tk.getImage("Assets/curvedArrow.png"); // Turn cursor image
    Cursor curvedArrow = tk.createCustomCursor(turnCur, getLocation(), TOOL_TIP_TEXT_KEY); // Custom cursor

    public Integer[] possibleNum;         // Possible numbers for card values

    {
        p1 = new Player();
        p2 = new Player();

        this.setLayout(null);
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY); // Set main cursor

        this.setCursor(mainCursor);       // Apply main cursor

        Player.choiceNum = Player.Choice.FIRST; // Initialize player choices
        Player.Turn = Player.Choice.FIRST;

        this.setPreferredSize(new Dimension(1200, 600));
        this.setVisible(true);
        this.setBackground(Color.white);
        t.setRepeats(false);

        backButton.setBounds(30, 18, 25, 25);
        backButton.addMouseListener(this);

        tri = new JLabel("Back");
        score = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            score[i] = new JLabel("0");
            score[i].setBounds(300 + 20 * i, 18, 25, 25);
            score[i].setFont(new Font("Arial", Font.BOLD, 24));
        }
        score[1].setText("-");
        score[0].setForeground(Color.RED);
        score[2].setForeground(Color.BLUE);

        try {
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            tri.setFont(gameFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        tri.setBounds(56, 19, 200, 30);
        tri.addMouseListener(this);

        background.setBounds(250, 0, 1000, 600);
        gridPanel = new JPanel();

        gridPanel.setBounds(600, 20, 350, 520);

        playerTurn = new JLabel(PlayerInput.playerOneName);
        playerTurn.setBounds(300, 40, 100, 25);
        playerTurn.setFont(new Font("Arial", Font.BOLD, 20));
        playerTurn.setForeground(Color.RED);

        gridPanel.setOpaque(false);
    }

    // Method to start the game
    public void start() {
        this.removeAll();                 // Remove all components

        playerTurn.setText(PlayerInput.playerOneName); // Set player turn text

        this.add(backButton);
        this.add(tri);
        this.add(playerTurn);

        for (int i = 0; i < 3; i++) {
            this.add(score[i]);
        }

        this.add(gridPanel);
        this.add(background);

        Set<Integer> uniqueNumbers = new HashSet<>(); // Set to store unique numbers
        possibleNum = new Integer[nc[CardGame.gridSize]]; // Array to store card values

        while (uniqueNumbers.size() < nc[CardGame.gridSize] / 2) {
            int randomNumber = rnd.nextInt(50) + 1;
            uniqueNumbers.add(randomNumber); // Add unique random numbers
        }

        int indArr = 0;
        for (Integer num : uniqueNumbers) {
            System.out.println(num);
            possibleNum[indArr] = num;
            possibleNum[indArr + 1] = num;

            indArr += 2;
        }
        Arrays.sort(possibleNum, (a, b) -> rnd.nextInt() - rnd.nextInt()); // Shuffle card values

        for (int i = 0; i < nc[CardGame.gridSize]; i++) {
            System.out.println(i);
            cardArr[i] = new Card(possibleNum[i]); // Initialize cards with values
        }
        gridPanel.setLayout(new GridLayout(row[CardGame.gridSize], col[CardGame.gridSize], hl[CardGame.gridSize], vl[CardGame.gridSize])); // Set grid layout

        for (int i = 0; i < nc[CardGame.gridSize]; i++) {
            cardArr[i].addMouseListener(this);
            cardArr[i].setCursor(curvedArrow); // Set custom cursor for cards
        }

        for (int i = 0; i < nc[CardGame.gridSize]; i++) {
            gridPanel.add(cardArr[i]);    // Add cards to grid panel
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tri) {
            GameMenu.runGame = false;
        }
        if (e.getSource() == backButton) {
            GameMenu.runGame = false;
        } else if ((Player.choiceNum == Player.Choice.FIRST || (Player.choiceNum == Player.Choice.SECOND && e.getSource() != Player.choices[0])) && (!(((Card) e.getSource()).getTaken()))) {
            if (Player.choiceNum == Player.Choice.FIRST) {
                Player.choiceNum = Player.Choice.SECOND;
                Player.choices[0] = (Card) e.getSource();
            } else {
                Player.choiceNum = Player.Choice.FIRST;
                Player.choices[1] = (Card) e.getSource();

                // Check if the two selected cards match
                if (Player.choices[0].pic != Player.choices[1].pic) {
                    t.start(); // Start timer for delay

                    if (Player.Turn == Player.Choice.FIRST) {
                        Player.Turn = Player.Choice.SECOND;
                        playerTurn.setText(PlayerInput.playerTwoName);
                        playerTurn.setForeground(Color.BLUE); // Change player turn
                    } else {
                        Player.Turn = Player.Choice.FIRST;
                        playerTurn.setText(PlayerInput.playerOneName);
                        playerTurn.setForeground(Color.RED); // Change player turn
                    }
                } else {
                    System.out.println("player " + Player.Turn + "up by a point");
                    if (Player.Turn == Player.Choice.FIRST) {
                        score[0].setText(String.valueOf(p1.oneUp())); // Update Player 1 score
                    } else {
                        score[2].setText(String.valueOf(p2.oneUp())); // Update Player 2 score
                    }
                    Player.choices[0].taken(); // Mark cards as taken
                    Player.choices[1].taken();

                    end.start(); // Start end game timer
                }
            }
            System.out.println("its player" + Player.Turn + "'s turn");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == tri) {
            tri.setFont(tri.getFont().deriveFont(23.0f)); // Change font size on press
        }
        if (e.getSource() == backButton) {
            tri.setFont(tri.getFont().deriveFont(23.0f));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == tri) {
            tri.setFont(tri.getFont().deriveFont(25.0f)); // Change font size on release
        }
        if (e.getSource() == backButton) {
            tri.setFont(tri.getFont().deriveFont(25.0f));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == tri) {
            tri.setForeground(new Color(75, 75, 75)); // Change color on hover
        }
        if (e.getSource() == backButton) {
            tri.setForeground(new Color(75, 75, 75));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == tri) {
            tri.setFont(tri.getFont().deriveFont(25.0f)); // Reset font size on exit
            tri.setForeground(new Color(55, 55, 55)); // Reset color on exit
        }
        if (e.getSource() == backButton) {
            tri.setFont(tri.getFont().deriveFont(25.0f));
            tri.setForeground(new Color(55, 55, 55));
        }
    }

    public CardGame() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player.choices[0].fail(); // Flip cards back over on failure
        Player.choices[1].fail();
    }

    // Method to restore the game to its initial state
    public void restore() {
        for (int i = 0; i < 3; i++) {
            score[i].setText("0"); // Reset scores
        }
        score[1].setText("-"); // Reset middle score label

        for (int i = 0; i < nc[CardGame.gridSize]; i++) {
            if (cardArr[i].getTaken())
                cardArr[i].fail(); // Flip taken cards back over
            cardArr[i].notTaken(); // Mark cards as not taken
        }

        gridPanel.removeAll();

        Player.choiceNum = Player.Choice.FIRST; // Reset player choices
        Player.Turn = Player.Choice.FIRST; // Reset player turn
        playerTurn.setText(PlayerInput.playerOneName); // Reset player turn text
        playerTurn.setForeground(Color.RED); // Reset player turn color
        p1.resetScore();
        p2.resetScore();
        end.setRepeats(false);
    }
}
