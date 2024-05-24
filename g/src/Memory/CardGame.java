package Memory;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


//Add a function that resets all the cards and scores when the triangle is clicked
public class CardGame extends JPanel implements MouseListener,ActionListener{
    private JLabel tri;
    private  final Integer[] possibleNum = {1,1,2,2,3,3,4,4,5,5,6,6};
    private Random rnd = new Random();
    private Timer t = new Timer(400,this);
    ImageIcon backgroundImg = new ImageIcon("g/Assets/gameBackground.jpg");
    ImageIcon backButtonImg = new ImageIcon("g/Assets/backButton.png");
    JLabel background = new JLabel(backgroundImg);
    JLabel backButton = new JLabel(backButtonImg);

    Card[] cardArr = new Card[12];
    
    {
        this.setLayout(null);

        Player.choiceNum = Player.Choice.FIRST;
        Player.Turn = Player.Choice.FIRST;

        //this.setLayout(null);
        this.setPreferredSize(new Dimension(1000,600));
        this.setVisible(true);
        this.setBackground(Color.white);
        t.setRepeats(false);

        backButton.setBounds(30, 18, 25, 25);
        backButton.addMouseListener(this);

        tri = new JLabel("Back");
        tri.setBounds(56,14,200,30);
        tri.setFont(tri.getFont().deriveFont(25.0f));
        tri.addMouseListener(this);

        background.setBounds(250, 0, 1000, 600);

        Arrays.sort(possibleNum,(a, b) -> rnd.nextInt() - rnd.nextInt());
        for(int i = 0; i < 12; i++){
            cardArr[i] = new Card(450, 20, possibleNum[i]);
            if(i == 1 || i == 2){
                cardArr[i] = new Card(450+(i*140), 20, possibleNum[i]);
            }
            if(i == 3 || i == 6 || i == 9){
                cardArr[i] = new Card(450, 20+(i*50), possibleNum[i]);
            }
            if(i == 4 || i == 5){
                cardArr[i] = new Card(450+((i-3)*140), 20+(3*50), possibleNum[i]);
            }
            if(i == 7 || i == 8){
                cardArr[i] = new Card(450+((i-6)*140), 20+(6*50), possibleNum[i]);
            }
            if(i == 10 || i == 11){
                cardArr[i] = new Card(450+((i-9)*140), 20+(9*50), possibleNum[i]);
            }
        }

        for(int i = 0; i < 12; i++){
            cardArr[i].addMouseListener(this);
        }

        this.add(backButton);
        this.add(tri);

        for(int i = 0; i < 12; i++){
            this.add(cardArr[i]);
        }
        this.add(background);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getSource() == tri){
            GameMenu.runGame = false;
        }
        if(e.getSource() == backButton){
            GameMenu.runGame = false;
        }
        else if(Player.choiceNum == Player.Choice.FIRST || (Player.choiceNum == Player.Choice.SECOND && e.getSource() != Player.choices[0])){
            if(Player.choiceNum == Player.Choice.FIRST){
                Player.choiceNum = Player.Choice.SECOND;
                Player.choices[0] = (Card) e.getSource();
            }
            else{
                Player.choiceNum = Player.Choice.FIRST;
                Player.choices[1] = (Card) e.getSource();
                
                //check array and do thingy here
                if(Player.choices[0].pic != Player.choices[1].pic){
                    t.start();
                    if(Player.Turn == Player.Choice.FIRST){
                        Player.Turn = Player.Choice.SECOND;
                    }
                    else{
                        Player.Turn = Player.Choice.FIRST;
                    }
                }
                else{
                    System.out.println("player " + Player.Turn + "up by a point");
                }

                
                System.out.println("its player" + Player.Turn + "'s turn");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == tri){
            tri.setFont(tri.getFont().deriveFont(23.0f));
        }
        if(e.getSource() == backButton){
            tri.setFont(tri.getFont().deriveFont(23.0f));
        } 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == tri){
            tri.setFont(tri.getFont().deriveFont(25.0f));
        }
        if(e.getSource() == backButton){
            tri.setFont(tri.getFont().deriveFont(25.0f));
        } 
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       if(e.getSource() == tri){
            tri.setFont(tri.getFont().deriveFont(30.0f));
        }
        if(e.getSource() == backButton){
            tri.setFont(tri.getFont().deriveFont(30.0f));
        } 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == tri){
            tri.setFont(tri.getFont().deriveFont(25.0f));
        }
        if(e.getSource() == backButton){
            tri.setFont(tri.getFont().deriveFont(25.0f));
        } 
    }

    public CardGame(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        Player.choices[0].fail();
        Player.choices[1].fail();
    }

}
