package Memory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//game menu that will have options you can choose from when start the program
public class GameMenu extends JPanel implements MouseListener{
    //make into variables what needs to become variables/constants
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    //we could use images instead of text cuz cooler font and whatnot
    private JLabel startGame = new JLabel("Start");
    private JLabel exit = new JLabel("Exit");
    private JLabel aboutUs =  new JLabel("About us");
    public static volatile boolean showAboutUsPage;
    
      
    {
        GameMenu.showAboutUsPage = false;
        this.setLayout(new FlowLayout(0,100,10));
        this.setBackground(Color.blue);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));//since the game panel has a boarder layout it will be resized to full screen either way
        //this.setVisible(true);
        
        startGame.addMouseListener(this);
        exit.addMouseListener(this);
        aboutUs.addMouseListener(this);

        //the widths arent random.
        //fontmetrics were used to figure out the correct widths(at least for the most part)
        startGame.setPreferredSize(new Dimension(70, 30));
        exit.setPreferredSize(new Dimension(56, 30));
        aboutUs.setPreferredSize(new Dimension(131, 30));
        
        startGame.setFont(startGame.getFont().deriveFont(20.0f));
        exit.setFont(startGame.getFont().deriveFont(20.0f));
        aboutUs.setFont(aboutUs.getFont().deriveFont(20.0f));

        

        this.add(startGame);
        this.add(aboutUs);
        this.add(exit);
        
        
        //set visibility true only after adding
        //might be automatically set to true for jlabels dunno
        startGame.setVisible(true);
        exit.setVisible(true);
        aboutUs.setVisible(true);
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
        if(e.getSource() == aboutUs)
        {
            GameMenu.showAboutUsPage = true;
        }  
        System.out.println(GameMenu.showAboutUsPage);
    }

    //change the size of the label when you change the size of the font/text
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(10.0f));
        if(e.getSource() == exit)
        exit.setFont(startGame.getFont().deriveFont(10.0f));
        if(e.getSource() == aboutUs)
        aboutUs.setFont(startGame.getFont().deriveFont(10.0f));

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == exit)
        exit.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == aboutUs)
        aboutUs.setFont(startGame.getFont().deriveFont(30.0f));
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == startGame)
            startGame.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == exit)
            exit.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == aboutUs)
            aboutUs.setFont(startGame.getFont().deriveFont(30.0f));
        
    }


    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == startGame)
            startGame.setFont(startGame.getFont().deriveFont(20.0f));
        if(e.getSource() == exit)
            exit.setFont(startGame.getFont().deriveFont(20.0f));
        if(e.getSource() == aboutUs)
            aboutUs.setFont(startGame.getFont().deriveFont(20.0f));
        
    }
    public GameMenu(){}
}
