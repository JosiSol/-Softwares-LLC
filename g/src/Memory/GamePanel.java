package Memory;

import java.awt.Color;
import java.lang.String;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//class of frame on which we will add/remove the components of the game
public class GamePanel extends JFrame{
    private final String GAME_NAME = "Memory Game";//Title/Name of frame,look at top-left
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    private final String ICON_PIC = "g/Assets/gameicon.png";//path of the icon
    private final ImageIcon GAME_ICON = new ImageIcon(ICON_PIC);//field that holds the image
    
    
    {
        //rearrange order maybe put in constructor
        this.setTitle(GAME_NAME);
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(Color.BLACK);//color the frame white
        this.setIconImage(GAME_ICON.getImage());//get the image out and put it at the top-left icon
        this.setLocationByPlatform(true);//sets the location of the frame based on the platform used 
        this.setVisible(true);//if not set to true the frame will exist but wont be visible
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//decides what happens when you click the x at the top-right
    }
    
    public GamePanel(){}
}
