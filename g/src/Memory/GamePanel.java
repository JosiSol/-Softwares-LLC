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
        this.setLayout(new BorderLayout()); // Set layout to BorderLayout
        this.setTitle(GAME_NAME); // Set the title of the frame
        this.setSize(WIDTH, HEIGHT); // Set the size of the frame
        this.getContentPane().setBackground(Color.BLACK); // Set the background color of the content pane to black
        this.setIconImage(GAME_ICON.getImage()); // Set the icon image of the frame
        this.setLocationByPlatform(true); // Set the location of the frame to be determined by the platform
        this.setLocation(100, 75); // Set the location of the frame on the screen
        this.setVisible(true); // Make the frame visible
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Set the default close operation to exit the application
    }

    // Default constructor for the GamePanel class
    public GamePanel() {}
}
