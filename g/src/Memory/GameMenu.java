package Memory;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameMenu extends JPanel implements MouseListener {
    // Constants for panel dimensions
    private final int WIDTH = 1200;
    private final int HEIGHT = 600;

    // ImageIcon for background image
    ImageIcon img = new ImageIcon("Assets/menuImage.jpg");

    // JLabels for menu options
    JLabel startGame = new JLabel("START");
    JLabel aboutUs = new JLabel("ABOUT US");
    JLabel exit = new JLabel("EXIT");
    JLabel background = new JLabel(img);
    public static volatile boolean showAboutUsPage;
    public static volatile boolean runGame;
    public static volatile boolean playerChoice;

    // Font variables
    private Font menuFont; // Declare a font reference
    private final File location = new File("Assets/GethoBold-v0wD.ttf"); // Location of the font

    // Toolkit for custom cursor
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    public GameMenu() {
        // Initialize state variables
        GameMenu.showAboutUsPage = false;
        this.setLayout(null);

        // Create custom cursor
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        startGame.addMouseListener(this);
        aboutUs.addMouseListener(this);
        exit.addMouseListener(this);

        background.setBounds(0, 0, 1200, 700);

        startGame.setBounds(40, 120, 100, 30);
        startGame.setForeground(new Color(224, 224, 224));

        aboutUs.setBounds(40, 188, 160, 30);
        aboutUs.setForeground(new Color(224, 224, 224));

        exit.setBounds(40, 258, 80, 30);
        exit.setForeground(new Color(200, 200, 200));

        try {
            // Load custom font
            menuFont = Font.createFont(Font.TRUETYPE_FONT, location);
            menuFont = menuFont.deriveFont(25.0f); // Set it to preferred size
            aboutUs.setFont(menuFont);
            startGame.setFont(menuFont);
            exit.setFont(menuFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Handle exception when using custom font
        }

        this.add(startGame);
        this.add(aboutUs);
        this.add(exit);
        this.add(background);

        startGame.setVisible(true);
        exit.setVisible(true);
        aboutUs.setVisible(true);
        background.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle clicks on EXIT label
        if (e.getSource() == exit) {
            // Show confirmation dialog
            if (JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit game", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0); // Exit the game on confirmation
            }
        }
        // Handle clicks on ABOUT US label
        if (e.getSource() == aboutUs) {
            GameMenu.showAboutUsPage = true; // Set flag to show about us page
        }
        // Handle clicks on START label
        if (e.getSource() == startGame) {
            GameMenu.playerChoice = true; // Set flag for player choice
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Change font size when mouse is pressed on START label
        if (e.getSource() == startGame)
            startGame.setFont(startGame.getFont().deriveFont(22.0f));

        // Change font size when mouse is pressed on EXIT label
        if (e.getSource() == exit)
            exit.setFont(exit.getFont().deriveFont(22.0f));

        // Change font size when mouse is pressed on ABOUT US label
        if (e.getSource() == aboutUs)
            aboutUs.setFont(aboutUs.getFont().deriveFont(22.0f));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Reset font size and color when mouse is released from START label
        if (e.getSource() == startGame) {
            startGame.setFont(startGame.getFont().deriveFont(25.0f));
            startGame.setForeground(new Color(224, 224, 224));
        }

        // Reset font size and color when mouse is released from EXIT label
        if (e.getSource() == exit) {
            exit.setFont(exit.getFont().deriveFont(25.0f));
            exit.setForeground(new Color(224, 224, 224));
        }

        // Reset font size and color when mouse is released from ABOUT US label
        if (e.getSource() == aboutUs) {
            aboutUs.setFont(aboutUs.getFont().deriveFont(25.0f));
            aboutUs.setForeground(new Color(224, 224, 224));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Change foreground color when mouse enters START label
        if (e.getSource() == startGame) {
            startGame.setForeground(new Color(239, 239, 239));
        }

        // Change foreground color when mouse enters EXIT label
        if (e.getSource() == exit) {
            exit.setForeground(new Color(225, 225, 225));
        }

        // Change foreground color when mouse enters ABOUT US label
        if (e.getSource() == aboutUs) {
            aboutUs.setForeground(new Color(239, 239, 239));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Change foreground color when mouse exits START label
        if (e.getSource() == startGame) {
            startGame.setForeground(new Color(224, 224, 224));
        }

        // Change foreground color when mouse exits EXIT label
        if (e.getSource() == exit) {
            exit.setForeground(new Color(200, 200, 200));
        }

        // Change foreground color when mouse exits ABOUT US label
        if (e.getSource() == aboutUs) {
            aboutUs.setForeground(new Color(224, 224, 224));
        }
    }
}
