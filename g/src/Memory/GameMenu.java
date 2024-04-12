package Memory;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//game menu that will have options you can choose from when start the program
public class GameMenu extends JPanel implements MouseListener{

    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    JLabel startGame = new JLabel("Start");
    JLabel exit = new JLabel("Exit");
    
        
    {
        this.setLayout(new FlowLayout(0,100,10));
        this.setBackground(Color.blue);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));//since the game panel has a boarder layout it will be resized to full screen either way

        
        startGame.addMouseListener(this);
        exit.addMouseListener(this);

        startGame.setPreferredSize(new Dimension(70, 30));
        exit.setPreferredSize(new Dimension(70, 30));

        startGame.setFont(startGame.getFont().deriveFont(20.0f));
        exit.setFont(startGame.getFont().deriveFont(20.0f));

        this.add(startGame);
        this.add(exit);
        
        
        //set visibility true only after adding
        startGame.setVisible(true);
        exit.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println("idiot");
        if(e.getSource() == exit)
        {
            if(JOptionPane.showConfirmDialog(this,"Are you sure?","Exit game",JOptionPane.YES_NO_OPTION) == 0)
            {
                System.exit(0);
            }
        }
        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(10.0f));
        if(e.getSource() == exit)
        exit.setFont(startGame.getFont().deriveFont(10.0f));

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == exit)
        exit.setFont(startGame.getFont().deriveFont(30.0f));
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == exit)
        exit.setFont(startGame.getFont().deriveFont(30.0f));
    }


    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(20.0f));
        if(e.getSource() == exit)
        exit.setFont(startGame.getFont().deriveFont(20.0f));
        
    }
}
