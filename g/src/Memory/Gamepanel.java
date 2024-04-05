package Memory;


//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.lang.String;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GamePanel extends JFrame{
    private final String GAME_NAME = "Memory Game";
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    private final String ICON_PIC = "g\\Assets\\gameicon.png";
    private final ImageIcon icon;
    
    {
        //rearrange order maybe puy in constructor
        this.setTitle(GAME_NAME);
        this.setSize(WIDTH, HEIGHT);

        //dont set it to any color this is just for testing
        this.getContentPane().setBackground(Color.WHITE);

        this.icon = new ImageIcon(ICON_PIC);
        this.setIconImage(icon.getImage());

        //this.pack(); resizes based on components might use later
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.getContentPane().setBackground(Color.WHITE);
    }

    public GamePanel(){}
}
