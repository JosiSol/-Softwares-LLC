package Memory;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

// Class representing the main game panel/frame
public class GamePanel extends JFrame {
    // Constants for the game panel's title, dimensions, and icon path
    private final String GAME_NAME = "Memory Game"; // Title/Name of the frame, shown at top-left
    private final int WIDTH = 1200; // Width of the frame
    private final int HEIGHT = 600; // Height of the frame
    private final String ICON_PIC = "Assets/gameicon.png"; // Path of the icon image
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

    // Default constructor for the GamePanel class
    public GamePanel() {}
}
