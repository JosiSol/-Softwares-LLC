package Memory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

// AboutUs class extends JPanel and implements MouseListener
public class AboutUs extends JPanel implements MouseListener {
    JLabel backButton, background, tri, label1, label2;
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

        // Set the preferred size of the panel
        this.setPreferredSize(new Dimension(1200, 600));
        this.setVisible(true);

        // Initialize and configure backButton
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

        // Set bounds and add mouse listener to tri
        tri.setBounds(56, 19, 200, 30);
        tri.addMouseListener(this);

        // Initialize and configure background label
        background = new JLabel(icon2);
        background.setBounds(250, 0, 1000, 600);

        // Add backButton and tri to the panel
        this.add(backButton);
        this.add(tri);

        // Create and configure text area
        JTextArea textArea = new JTextArea(25, 25);
        textArea.setBounds(310, 50, 850, 460);

        // Create and configure a label for the title
        JLabel label = new JLabel("QIBE Games Present, The Memory Game");
        label.setBounds(480, 19, 600, 30);

        // Set the text for textArea
        textArea.setText(
                label.getText() +
                        "\n\n About Us \n\n" +
                        "We are Qibe Games, a subsidiary of Qibe Softwares LLC, founded by six second-year Computer Science students for our OOP course project in Java. With a passion for gaming and cognitive sciences, we developed a simple yet fun memory game where players match cards they see. Our game includes various themes and difficulty levels to keep it engaging.\n" +
                        "\n" +
                        "We extend our heartfelt thanks to our instructor, Nesredien S., for instilling key concepts through engaging lectures, advising us to start working on our project early, and providing his valuable guidance. We hope you enjoy our very first game! \n\n"+
                        "The Members \n\n" +
                        "Yosefe Tilahun \t UGR/9673/15 \n"+
                        "Yabqal Brook \t\t UGR/2822/15 \n" +
                        "Yosef Solomon \t UGR/7358/15 \n"+
                        "Natnael Mesfin \t UGR/8654/15 \n" +
                        "Yohannes Ketema \t UGR/6290/15 \n" +
                        "Mikiyas Fasil \t\t UGR/9231/15 \n"
        );

        // Configure text area properties
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);

        // Add the text area to a scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.setVisible(true);
        scrollPane.setBounds(310, 50, 850, 560);

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

        // Add the scroll pane and background to the panel
        this.add(scrollPane);
        this.add(background);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle mouse click events on backButton or tri
        if (e.getSource() == backButton || e.getSource() == tri) {
            GameMenu.showAboutUsPage = false;
            System.out.println("Back to square one");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Not used, but required by MouseListener interface
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not used, but required by MouseListener interface
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not used, but required by MouseListener interface
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not used, but required by MouseListener interface
    }

    // Constructor for AboutUs
    public AboutUs() {}
}
