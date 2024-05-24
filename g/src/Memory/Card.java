package Memory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Card extends JLabel implements MouseListener,ActionListener{

    //make private and make a setter method for it
    public int pic;//used to choose the sprite
    private Timer t = new Timer(400,this);
    //make private and add setter method
    public boolean closed = true;

    {
        t.setRepeats(false);
        this.setIcon(new ImageIcon("g/Assets/initial.png"));
        this.addMouseListener(this);
        this.setVisible(true);        
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(closed){    
            this.setIcon(new ImageIcon("g/Assets/open"+ pic +".gif"));
            t.start();
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

    void fail(){
        this.setIcon(new ImageIcon("g/Assets/close"+ pic +".gif"));
        t.start(); 
    }

    Card(int posX, int posY, int pic){
        this.setBounds(posX, posY, 50, 66);
        this.pic = pic;
    }

    Card(){
        this.setBounds(100, 100, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(closed){
            this.setIcon(new ImageIcon("g/Assets/"+ pic +".png"));
        }else{
            this.setIcon(new ImageIcon("g/Assets/initial.png"));
        }

        closed = !closed;
    }

}
