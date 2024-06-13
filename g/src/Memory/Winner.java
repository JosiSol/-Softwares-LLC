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
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY); // Create custom cursor
        this.setCursor(mainCursor); // Set custom cursor
        this.setPreferredSize(new Dimension(1200, 600)); // Set preferred size of the panel
        this.setVisible(true); // Make the panel visible
        this.setBounds(0, 0, 1200, 600); // Set bounds for the panel

        // Initialize and set bounds for winner message
        winner = new JLabel();
        winner.setBounds(500, 85, 300, 200);

        // Initialize and set bounds for retry button
        retry = new JLabel("Retry");
        retry.setBounds(350, 200, 250, 250);
        retry.addMouseListener(this); // Add mouse listener to retry button

        // Initialize and set bounds for main menu button
        mainMenu = new JLabel("Return to Main Menu");
        mainMenu.setBounds(660, 200, 300, 250);
        mainMenu.addMouseListener(this); // Add mouse listener to main menu button

        // Add components to the panel
        this.add(winner);
        this.add(retry);
        this.add(mainMenu);

        // Set timer properties
        timer.setRepeats(false); // Set timer to not repeat
    }

    // Constructor to set up winner message and background color based on game result
    public Winner(int p1) {
        try {
            // Load custom font from file
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f); // Set font size to 25
            winner.setFont(gameFont); // Set font for winner message
            retry.setFont(gameFont); // Set font for retry button
            mainMenu.setFont(gameFont); // Set font for main menu button

            // Set winner message and background color based on game result
            if (p1 > 0) {
                winner.setText("WINNER! " + PlayerInput.playerOneName); // Display player one as winner
                this.setBackground(Color.RED); // Set background color to red
            } else if (p1 == 0) {
                winner.setText("DRAW!"); // Display draw message
                this.setBackground(Color.LIGHT_GRAY); // Set background color to light gray
            } else {
                winner.setText("WINNER! " + PlayerInput.playerTwoName); // Display player two as winner
                this.setBackground(Color.BLUE); // Set background color to blue
            }
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Handle exception when loading custom font
        }
    }

    // Mouse click event handler
    @Override
    public void mouseClicked(MouseEvent e) {
        GameMenu.runGame = false; // Set game state to not running
        CardGame.stillOn = false; // Set card game state to not on
        System.out.println("Back to square one"); // Print message to console

        // Handle click on retry button
        if (e.getSource() == retry) {
            GameMenu.runGame = true; // Set game state to running
        }
    }

    // Mouse press event handler (unused)
    @Override
    public void mousePressed(MouseEvent e) {}

    // Mouse release event handler (unused)
    @Override
    public void mouseReleased(MouseEvent e) {}

    // Mouse enter event handler (unused)
    @Override
    public void mouseEntered(MouseEvent e) {}

    // Mouse exit event handler (unused)
    @Override
    public void mouseExited(MouseEvent e) {}
}
