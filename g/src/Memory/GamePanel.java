package Memory;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

// Class representing the main game panel/frame
public class GamePanel extends JFrame {
    // Constants for the game panel's title, dimensions, and icon path
    private final String GAME_NAME = "Memory Game";
    private final int WIDTH = 1200;
    private final int HEIGHT = 600;
    private final String ICON_PIC = "Assets/gameicon.png";
    private final ImageIcon GAME_ICON = new ImageIcon(ICON_PIC); // ImageIcon object holding the icon image

    // Initialization block to set up the frame properties
    {
        this.setLayout(new BorderLayout());
        this.setTitle(GAME_NAME);
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(Color.BLACK);
        this.setIconImage(GAME_ICON.getImage());
        this.setLocationByPlatform(true);
        this.setLocation(100, 75);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public GamePanel() {}
}
