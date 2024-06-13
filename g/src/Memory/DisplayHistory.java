package Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DisplayHistory extends JPanel implements MouseListener {
    JTextArea ta;
    String compose = "";
    JLabel tri, backButton;
    Toolkit tk = Toolkit.getDefaultToolkit(); // Toolkit for custom cursor
    Image newCur1 = tk.getImage("Assets/cursorMain.png"); // Main cursor image
    ImageIcon icon = new ImageIcon("Assets/backButton.png");
    private Font backFont, textFont; // Declare a font reference
    private final File location = new File("Assets/GethoBold-v0wD.ttf"); // Location of the font
    private final File location2 = new File("Assets/Ubuntu-Medium.ttf");

    {

        backButton = new JLabel(icon);
        backButton.setBounds(30, 18, 25, 25);
        backButton.addMouseListener(this);

        this.setPreferredSize(new Dimension(1200, 600));
        tri = new JLabel("Back");

        this.setLayout(null);             // Set layout to null for custom positioning
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY); // Set main cursor

        this.setCursor(mainCursor);

        try{
            // variable declaration
            int character;

            // check if File exists or not
            FileReader fr=null;
            try
            {
                fr = new FileReader("output.txt");
            }
            catch (FileNotFoundException fe)
            {
                System.out.println("File not found");
            }

            // read from FileReader till the end of file
            while ((character=fr.read())!=-1)
                compose += (char)character;

            System.out.println(compose);
            // close the file
            fr.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        tri.setBounds(56, 19, 200, 30);    // Position triangle label
        tri.addMouseListener(this);
        backButton.addMouseListener(this);

        ta = new JTextArea();
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setOpaque(false);

        ta.setBounds(56, 80, 1100, 550);

        try {
            // Load custom font
            backFont = Font.createFont(Font.TRUETYPE_FONT, location);
            backFont = backFont.deriveFont(25.0f); // Set it to preferred size
            tri.setFont(backFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Handle exception when using custom font
        }
        try {
            // Load custom font
            textFont = Font.createFont(Font.TRUETYPE_FONT, location2);
            textFont = textFont.deriveFont(25.0f); // Set it to preferred size
            ta.setFont(textFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Handle exception when using custom font
        }

        this.add(tri);
        this.add(backButton);

        ta.setText(compose);
        JScrollPane scrollPane = new JScrollPane(ta);
        scrollPane.setBounds(56, 80, 1100, 550);

        scrollPane.getViewport().setOpaque(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);

        this.add(scrollPane);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource() == tri || e.getSource() == backButton) {        // If triangle is clicked
            GameMenu.playerHistory = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}
}
