package Memory;

import java.awt.Color;
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
    private Integer[] possibleNum = {1,1,2,2,3,3,4,4,5,5,6,6};
    private Random rnd = new Random();
    private Timer t = new Timer(400,this);
    
    Card _1;
    Card _2;
    Card _3;
    Card _4;
    Card _5;
    Card _6;
    Card _7;
    Card _8;
    Card _9;
    Card _10;
    Card _11;
    Card _12;
    
    {
        Player.choiceNum = Player.Choice.FIRST;
        Player.Turn = Player.Choice.FIRST;

        //this.setLayout(null);
        this.setPreferredSize(new Dimension(1000,600));
        this.setVisible(true);
        this.setBackground(Color.white);
        t.setRepeats(false);

        tri = new JLabel("triangle");
        tri.setBounds(10,0,50,50);
        tri.addMouseListener(this);

        Arrays.sort(possibleNum,(a, b) -> rnd.nextInt() - rnd.nextInt());

        _1 = new Card(100,100,possibleNum[1]);
        _2 = new Card(100,100,possibleNum[2]);
        _3 = new Card(100,100,possibleNum[3]);
        _4 = new Card(100,100,possibleNum[4]);
        _5 = new Card(100,100,possibleNum[5]);
        _6 = new Card(100,100,possibleNum[6]);
        _7 = new Card(100,100,possibleNum[7]);
        _8 = new Card(100,100,possibleNum[8]);
        _9 = new Card(100,100,possibleNum[9]);
        _10 = new Card(100,100,possibleNum[10]);
        _11 = new Card(100,100,possibleNum[11]);
        _12 = new Card(100,100,possibleNum[0]);

        _1.addMouseListener(this);
        _2.addMouseListener(this);
        _3.addMouseListener(this);
        _4.addMouseListener(this);
        _5.addMouseListener(this);
        _6.addMouseListener(this);
        _7.addMouseListener(this);
        _8.addMouseListener(this);
        _9.addMouseListener(this);
        _10.addMouseListener(this);
        _11.addMouseListener(this);
        _12.addMouseListener(this);


        this.add(tri);

        this.add(_1);
        this.add(_2);
        this.add(_3);
        this.add(_4);
        this.add(_5);
        this.add(_6);
        this.add(_7);
        this.add(_8);
        this.add(_9);
        this.add(_10);
        this.add(_11);
        this.add(_12);

    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getSource() == tri){
            GameMenu.runGame = false;
        }
        else{
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
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public CardGame(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        Player.choices[0].fail();
        Player.choices[1].fail();
    }

}
