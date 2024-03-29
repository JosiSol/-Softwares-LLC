package Memory;


import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.String;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Gamepanel extends JFrame{
    private final String GAME_NAME = "Memory Game";
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    private final String ICON_PIC = "/../Assets/gameicon.png";

    //static {Gamepanel.setDefaultLookAndFeelDecorated(true);}
    {
        this.setTitle(GAME_NAME);
        this.setSize(WIDTH, HEIGHT);

        //dont set it to any color this is just for testing
        this.getContentPane().setBackground(Color.ORANGE);

        //instead of this.setIconImage(new ImageIcon(ICON_PIC).getImage());
        ImageIcon icon = new ImageIcon(ICON_PIC);
        this.setIconImage(icon.getImage());

        //this.pack(); resizes based on components might use later
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    Gamepanel(){}
}
