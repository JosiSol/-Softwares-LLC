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


//Add a function that resets all the cards and scores when the triangle is clicked
public class CardGame extends JPanel implements MouseListener,ActionListener {
    Set<Integer> uniqueNumbers = new HashSet<>();
    static volatile public int gridSize;
    private final int [] row = {4,5,6},
            col = {3,4,6},
            vl = {70,40,20},
            hl = {100,50,10},
            nc={4*3,5*4,6*6};

    Player p1;
    Player p2;
    JPanel gridPanel;

    static volatile boolean stillOn = true;
    private final JLabel tri, playerTurn;

    private final Random rnd = new Random();
    private final Timer t = new Timer(400, this);
    private final Timer end = new Timer(500, e -> {
        if (p1.getScore() + p2.getScore() == nc[CardGame.gridSize]/2) {
            this.removeAll();
            this.repaint();
            this.add(new Winner(p1.getScore() - p2.getScore()));

            stillOn = true;
            this.restore();
        }
    });
    private Font gameFont;
    private final JLabel[] score;
    ImageIcon backgroundImg = new ImageIcon("Assets/gameBackground.jpg");
    ImageIcon backButtonImg = new ImageIcon("Assets/backButton.png");
    JLabel background = new JLabel(backgroundImg);
    JLabel backButton = new JLabel(backButtonImg);
    Card[] cardArr = new Card[36];
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    Image turnCur = tk.getImage("Assets/curvedArrow.png");
    Cursor curvedArrow = tk.createCustomCursor(turnCur, getLocation(), TOOL_TIP_TEXT_KEY);

    public Integer[] possibleNum;

    {
        p1 = new Player();
        p2 = new Player();

        this.setLayout(null);
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);

        this.setCursor(mainCursor);

        Player.choiceNum = Player.Choice.FIRST;
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
    public void start(){

        this.removeAll();

        playerTurn.setText(PlayerInput.playerOneName);

        this.add(backButton);
        this.add(tri);
        this.add(playerTurn);

        for(int i = 0;i < 3;i++){
            this.add(score[i]);
        }

        this.add(gridPanel);
        this.add(background);

        possibleNum = new Integer[nc[CardGame.gridSize]];

        while (uniqueNumbers.size() < nc[CardGame.gridSize]/2) {
            int randomNumber = rnd.nextInt(18) + 1;
            uniqueNumbers.add(randomNumber);
        }

        int indArr = 0;
        for(Integer num : uniqueNumbers)
        {
            System.out.println(num);
            possibleNum[indArr] = num;
            possibleNum[indArr + 1] = num;

            indArr += 2;
        }
        System.out.println("not cool");
        Arrays.sort(possibleNum, (a, b) -> rnd.nextInt() - rnd.nextInt());

        System.out.println("not cool");
        for (int i = 0; i < nc[CardGame.gridSize]; i++) {
            System.out.println(i);
            cardArr[i] = new Card(possibleNum[i]);
        }
        System.out.println("not cool");
        gridPanel.setLayout(new GridLayout(row[CardGame.gridSize], col[CardGame.gridSize], hl[CardGame.gridSize], vl[CardGame.gridSize]));

        for (int i = 0; i < nc[CardGame.gridSize]; i++) {
            cardArr[i].addMouseListener(this);
            cardArr[i].setCursor(curvedArrow);
        }


        for (int i = 0; i < nc[CardGame.gridSize]; i++) {
            gridPanel.add(cardArr[i]);
        }

       // end.setRepeats(false);
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

                //check array and do thingy here
                if (Player.choices[0].pic != Player.choices[1].pic) {
                    t.start();

                    if (Player.Turn == Player.Choice.FIRST) {
                        Player.Turn = Player.Choice.SECOND;
                        playerTurn.setText(PlayerInput.playerTwoName);
                        playerTurn.setForeground(Color.BLUE);
                    } else {
                        Player.Turn = Player.Choice.FIRST;
                        playerTurn.setText(PlayerInput.playerOneName);
                        playerTurn.setForeground(Color.RED);
                    }
                } else {
                    System.out.println("player " + Player.Turn + "up by a point");
                    if (Player.Turn == Player.Choice.FIRST) {
                        score[0].setText(String.valueOf(p1.oneUp()));
                    } else {
                        score[2].setText(String.valueOf(p2.oneUp()));
                    }
                    Player.choices[0].taken();
                    Player.choices[1].taken();

                    end.start();
                }
            }
            System.out.println("its player" + Player.Turn + "'s turn");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == tri) {
            tri.setFont(tri.getFont().deriveFont(23.0f));
        }
        if (e.getSource() == backButton) {
            tri.setFont(tri.getFont().deriveFont(23.0f));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == tri) {
            tri.setFont(tri.getFont().deriveFont(25.0f));
        }
        if (e.getSource() == backButton) {
            tri.setFont(tri.getFont().deriveFont(25.0f));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == tri) {
            //tri.setFont(tri.getFont().deriveFont(30.0f));
            tri.setForeground(new Color(75, 75, 75));
        }
        if (e.getSource() == backButton) {
            //tri.setFont(tri.getFont().deriveFont(30.0f));
            tri.setForeground(new Color(75, 75, 75));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == tri) {
            tri.setFont(tri.getFont().deriveFont(25.0f));
            tri.setForeground(new Color(55, 55, 55));
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
        Player.choices[0].fail();
        Player.choices[1].fail();
    }

    public void restore() {

        for (int i = 0; i < 3; i++) {
            score[i].setText("0");
        }
        score[1].setText("-");

        for(int i = 0; i < nc[CardGame.gridSize]; i++){
            if(cardArr[i].getTaken())
                cardArr[i].fail();
            cardArr[i].notTaken();
        }

        gridPanel.removeAll();

        Player.choiceNum = Player.Choice.FIRST;
        Player.Turn = Player.Choice.FIRST;
        playerTurn.setText(PlayerInput.playerOneName);
        playerTurn.setForeground(Color.RED);
        p1.resetScore();
        p2.resetScore();
        end.setRepeats(false);

    }
}
