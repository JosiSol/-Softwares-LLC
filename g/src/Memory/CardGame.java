package Memory;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


//Add a function that resets all the cards and scores when the triangle is clicked
public class CardGame extends JPanel implements MouseListener,ActionListener {
    Player p1;
    Player p2;
    private JLabel tri, playerTurn;
    private final Integer[] possibleNum = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
    private Random rnd = new Random();
    private Timer t = new Timer(400, this);
    private Timer end = new Timer(500, e -> {
        if (p1.getScore() + p2.getScore() == 6) {
            this.removeAll();
            this.repaint();
            this.add(new Winner(p1.getScore() - p2.getScore()));
            this.restore();
        }
    });
    private Font gameFont;
    private JLabel score[];
    private JPanel winner = new JPanel();
    ImageIcon backgroundImg = new ImageIcon("Assets/gameBackground.jpg");
    ImageIcon backButtonImg = new ImageIcon("Assets/backButton.png");
    JLabel background = new JLabel(backgroundImg);
    JLabel backButton = new JLabel(backButtonImg);
    Card[] cardArr = new Card[12];
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    Image turnCur = tk.getImage("Assets/curvedArrow.png");
    Cursor curvedArrow = tk.createCustomCursor(turnCur, getLocation(), TOOL_TIP_TEXT_KEY);
    {
        end.setRepeats(false);
        p1 = new Player();
        p2 = new Player();

        this.setLayout(null);
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);

        this.setCursor(mainCursor);

        Player.choiceNum = Player.Choice.FIRST;
        Player.Turn = Player.Choice.FIRST;

        //this.setLayout(null);
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
            this.add(score[i]);
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

        playerTurn = new JLabel("Player 1");
        playerTurn.setBounds(300, 40, 100, 25);
        playerTurn.setFont(new Font("Arial", Font.BOLD, 20));
        playerTurn.setForeground(Color.RED);

        background.setBounds(250, 0, 1000, 600);

        Arrays.sort(possibleNum, (a, b) -> rnd.nextInt() - rnd.nextInt());
        for (int i = 0; i < 12; i++) {
            cardArr[i] = new Card(600, 20, possibleNum[i]);
            if (i == 1 || i == 2) {
                cardArr[i] = new Card(600 + (i * 140), 20, possibleNum[i]);
            }
            if (i == 3 || i == 6 || i == 9) {
                cardArr[i] = new Card(600, 20 + (i * 50), possibleNum[i]);
            }
            if (i == 4 || i == 5) {
                cardArr[i] = new Card(600 + ((i - 3) * 140), 20 + (3 * 50), possibleNum[i]);
            }
            if (i == 7 || i == 8) {
                cardArr[i] = new Card(600 + ((i - 6) * 140), 20 + (6 * 50), possibleNum[i]);
            }
            if (i == 10 || i == 11) {
                cardArr[i] = new Card(600 + ((i - 9) * 140), 20 + (9 * 50), possibleNum[i]);
            }
        }

        for (int i = 0; i < 12; i++) {
            cardArr[i].addMouseListener(this);
            cardArr[i].setCursor(curvedArrow);
        }

        this.add(backButton);
        this.add(tri);
        this.add(playerTurn);

        for (int i = 0; i < 12; i++) {
            this.add(cardArr[i]);
        }
        this.add(background);

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
                        playerTurn.setText("Player 2");
                        playerTurn.setForeground(Color.BLUE);
                    } else {
                        Player.Turn = Player.Choice.FIRST;
                        playerTurn.setText("Player 1");
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
        for(int i = 0; i < 12; i++){
            cardArr[i].fail();
            cardArr[i].notTaken();
        }
        Player.choiceNum = Player.Choice.FIRST;
        Player.Turn = Player.Choice.FIRST;
        playerTurn.setText("Player 1");

    }
}
