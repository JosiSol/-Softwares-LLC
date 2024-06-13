package Memory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

// Userguide class extends JPanel and implements MouseListener
public class UserGuide extends JPanel implements MouseListener {
    JLabel backButton, background, tri;
    ImageIcon icon = new ImageIcon("Assets/backButton.png");
    ImageIcon icon2 = new ImageIcon("Assets/Background.png");
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    private Font gameFont;

    {
        // Set the layout manager to null for absolute positioning
        this.setLayout(null);

        // Set a custom cursor
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);

        this.setPreferredSize(new Dimension(1200, 600));
        this.setVisible(true);

        backButton = new JLabel(icon);
        backButton.setBounds(30, 18, 25, 25);
        backButton.addMouseListener(this);

        // Initialize and configure tri (the "Back" label)
        tri = new JLabel("Back");

        // Load and set a custom font
        try {
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            tri.setFont(gameFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        tri.setBounds(56, 19, 200, 30);
        tri.addMouseListener(this);

        background = new JLabel(icon2);
        background.setBounds(250, 0, 1000, 600);

        this.add(backButton);
        this.add(tri);

        JTextArea textArea = new JTextArea(25, 25);
        textArea.setBounds(310, 30, 850, 460);

        JLabel label = new JLabel("QIBE Games Present, The Memory Game");
        label.setBounds(480, 19, 600, 30);

        textArea.setText(
    label.getText() +
    "User Guide: Memory Game\n" +
    "\n" +
    "Getting Started\n\n" +
    "When you run the program, you will be presented with the main menu screen. Here, you will see two options: START and ABOUT US.\n\n" +
    "Start\n" +
    "Clicking the START button will take you to the player registration page. On this page, you will be prompted to enter your name and your opponent's name. Once both names have been entered, you can click the START GAME button to begin playing.\n\n" +
    "Gameplay\n" +
    "After entering your names and starting the game, you will be taken to the game screen. Here, you will see a grid of cards with their faces hidden. The objective of the game is to find matching pairs of cards by flipping them over.\n\n" +
    "Levels\n" +
    "The game offers three difficulty levels: Easy, Medium, and Hard. You can change the level by clicking the appropriate button on the game screen.\n\n" +
    "Taking Turns\n" +
    "Players take turns flipping over two cards at a time, trying to find a matching pair. If the cards match, the pair will remain face-up, and you will earn points. If the cards do not match, they will be turned back over, and your turn will end.\n\n" +
    "Scoring\n" +
    "The player who finds the most matching pairs will have the highest score. Your score will be displayed on the game screen and will increase as you find more matching pairs.\n\n" +
    "Game History\n" +
    "At the bottom left corner of the game screen, you will see a history of recent games played. This will display the names of the players and their respective scores.\n\n" +
    "End of Game\n" +
    "Once all cards have been matched, the game will end, and the winner will be announced. You will then have the option to play another round or return to the main menu.\n\n" +
    "We hope you enjoy playing our Memory Game! If you have any questions or feedback, please don't hesitate to contact us. \n\n" +
    "Telegram @QibeGames Email: Qibegames@gmail.com"
);// Configure text area properties
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);

        // Add the text area to a scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.setVisible(true);
        scrollPane.setBounds(310, 20, 850, 540);

        // Load and set another custom font
        try {
            File location = new File("Assets/Ubuntu-Medium.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            label.setFont(gameFont);
            textArea.setFont(gameFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // Configure scroll pane properties
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);

        this.add(scrollPane);
        this.add(background);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            // Handle mouse click events on backButton or tri
            if (e.getSource() == backButton || e.getSource() == tri) {
                GameMenu.userGuide = false;
                System.out.println("Back to square one");
            }
        }catch (Exception ex){
            System.out.println("Mouse Pixel Click Error!");
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
    public UserGuide() {}
}