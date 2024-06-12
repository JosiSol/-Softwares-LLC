package Memory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AboutUs extends JPanel implements MouseListener {
    JLabel backButton, background, tri, label1, label2;
    ImageIcon icon = new ImageIcon("Assets/backButton.png");
    ImageIcon icon2 = new ImageIcon("Assets/Background.png");
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    private Font gameFont;

    {
        this.setLayout(null);
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);
        this.setPreferredSize(new Dimension(1200, 600));
        this.setVisible(true);

        backButton = new JLabel(icon);
        backButton.setBounds(30, 18, 25, 25);
        backButton.addMouseListener(this);

        label1 = new JLabel("Previous");
        label2 = new JLabel("Next");
        label2.addMouseListener(this);

        label1.setBounds(520, 510, 120, 60);
        label2.setBounds(840, 510, 80, 60);

        tri = new JLabel("Back");

        try {
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            tri.setFont(gameFont);
            label1.setFont(gameFont);
            label2.setFont(gameFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        tri.setBounds(56, 19, 200, 30);
        tri.addMouseListener(this);

        background = new JLabel(icon2);
        background.setBounds(250, 0, 1000, 600);

        this.add(backButton);
        this.add(tri);
        this.add(label1);
        this.add(label2);

        JTextArea textArea = new JTextArea(25, 25);
        textArea.setBounds(310, 50, 850, 460);
        textArea.setText("About Us\n\n" +
                "We are Qibe Games, a subsidiary of Qibe Softwares LLC, founded by\n" +
                "six second-year Computer Science students for our OOP course\n" +
                "project in Java. With a passion for gaming and cognitive sciences, \n" +
                "we developed a simple yet fun memory game where players match \n" +
                "cards they see. \n" +
                "Our game includes various themes and difficulty levels to keep it \n" +
                "engaging.\n" +
                "\n" +
                "We extend our heartfelt thanks to our instructor, Nesredien S.,\n" +
                "for instilling key concepts through engaging lectures, advising\n" +
                "us to start working on our project early, and providing his\n" +
                "valuable guidance. We hope you enjoy our very first game!");

        textArea.setOpaque(false);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.setVisible(true);
        scrollPane.setBounds(310, 50, 850, 460);


        JLabel label = new JLabel("QIBE Games Present The Memory Game");
        label.setBounds(480, 19, 600, 30);
        try {
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            label.setFont(gameFont);
            textArea.setFont(gameFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        this.add(label);
        this.add(textArea);
        this.add(background);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == backButton || e.getSource() == tri) {
            GameMenu.showAboutUsPage = false;
            System.out.println("Back to square one");
        }
        if (e.getSource() == label2) {
        }
    }

        @Override
        public void mousePressed (MouseEvent e){
        }

        @Override
        public void mouseReleased (MouseEvent e){
        }

        @Override
        public void mouseEntered (MouseEvent e){
        }

        @Override
        public void mouseExited (MouseEvent e){
        }

    public AboutUs() {}
    }


