package Memory;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;

//game menu that will have options you can choose from when start the program
public class GameMenu extends JPanel{

    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    JButton startGame = new JButton("Start");
    
        
    {
        
        this.setLayout(new BorderLayout());
        this.setOpaque(true);
        this.setSize(WIDTH,HEIGHT);//since the game panel has a boarder layout it will be resized to full screen either way
        
        //uncomment this, was commented for testing purposes 
        //startGame.setOpaque(false);
        startGame.setFocusable(false);
        startGame.setBounds(200,100,100,50);
        startGame.setBorder(BorderFactory.createEmptyBorder());
        startGame.addActionListener(e->System.out.println("rfvtg"));
        startGame.setVisible(true);
        this.add(startGame);
        this.setVisible(true);
    }
}
