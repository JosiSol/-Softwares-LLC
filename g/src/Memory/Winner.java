package Memory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

// Class representing the winner screen panel
public class Winner extends JPanel implements MouseListener {
    // JLabels for winner message, retry button, and main menu button
    JLabel winner, retry, mainMenu;
    // Timer to manage game state transitions
    private final Timer timer = new Timer(10, e -> {
        GameMenu.runGame = true; // Set the game state to running
    });
    // Toolkit for custom cursor
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png"); // Path to custom cursor image
    // Font for displaying text
    private Font gameFont;
    // Initialization block to set up the panel properties and components
    {
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);
        this.setPreferredSize(new Dimension(1200, 600));
        this.setVisible(true);
        this.setBounds(0, 0, 1200, 600);

        // Initialize and set bounds for winner message
        winner = new JLabel();
        winner.setBounds(500, 85, 300, 200);

        // Initialize and set bounds for retry button
        retry = new JLabel("Retry");
        retry.setBounds(350, 200, 250, 250);
        retry.addMouseListener(this);

        // Initialize and set bounds for main menu button
        mainMenu = new JLabel("Return to Main Menu");
        mainMenu.setBounds(660, 200, 300, 250);
        mainMenu.addMouseListener(this);

        this.add(winner);
        this.add(retry);
        this.add(mainMenu);

        timer.setRepeats(false);
    }

    // Constructor to set up winner message and background color based on game result
    public Winner(int p1) {
        try {
            // Load custom font from file
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            winner.setFont(gameFont);
            retry.setFont(gameFont);
            mainMenu.setFont(gameFont);

            // Set winner message and background color based on game result
            if (p1 > 0) {
                winner.setText("WINNER! " + PlayerInput.playerOneName);
                this.setBackground(Color.RED);
            } else if (p1 == 0) {
                winner.setText("DRAW!");
                this.setBackground(Color.LIGHT_GRAY);
            } else {
                winner.setText("WINNER! " + PlayerInput.playerTwoName);
                this.setBackground(Color.BLUE);
            }
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Handle exception when loading custom font
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        GameMenu.runGame = false; // Set game state to not running
        CardGame.stillOn = false; // Set card game state to not on

        // Handle click on retry button
        if (e.getSource() == retry) {
            GameMenu.runGame = true; // Set game state to running
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
