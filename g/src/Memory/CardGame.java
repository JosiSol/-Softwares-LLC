package Memory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class CardGame extends JPanel implements MouseListener{
    JLabel tri;
    Card card = new Card(100,100,1);

    {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000,600));
        this.setVisible(true);
        this.setBackground(Color.white);

        tri = new JLabel("triangle");
        tri.setBounds(10,0,50,50);
        tri.addMouseListener(this);
        this.add(tri);
        this.add(card);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        GameMenu.runGame = false;
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

}
