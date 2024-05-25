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

public class GameMenu extends JPanel implements MouseListener{
    private final int WIDTH = 1200;
    private final int HEIGHT = 600;
    
    ImageIcon img = new ImageIcon("g/Assets/menuImage.jpg");
    JLabel startGame = new JLabel("START");
    JLabel aboutUs = new JLabel("ABOUT US");
    JLabel exit = new JLabel("EXIT");
    JLabel background = new JLabel(img);
    public static volatile boolean showAboutUsPage;
    public static volatile boolean runGame;
    private Font menuFont; //declare a font reference
    private File location = new File("g/Assets/GethoBold-v0wD.ttf"); //location of the font
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("g/Assets/cursorMain.png");

    {
        GameMenu.showAboutUsPage = false;
        this.setLayout(null);
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);
        
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

        startGame.addMouseListener(this);
        aboutUs.addMouseListener(this);
        exit.addMouseListener(this);
        
        background.setBounds(0, 0, 1200, 700);

        startGame.setBounds(40, 120, 100, 30);
        startGame.setForeground(new Color(224, 224, 224));

        aboutUs.setBounds(40, 188, 160, 30);
        aboutUs.setForeground(new Color(224, 224, 224));

        exit.setBounds(40, 258, 80, 30);
        exit.setForeground(new Color (200, 200, 200));

        try {
            menuFont = Font.createFont(Font.TRUETYPE_FONT, location);
            menuFont = menuFont.deriveFont(25.0f); //set it to preferred size
            aboutUs.setFont(menuFont);
            startGame.setFont(menuFont);
            exit.setFont(menuFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); //because it is a must to handle exception when using custom font
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
    public void mouseClicked(MouseEvent e){
        if(e.getSource() == exit)
        {
            if(JOptionPane.showConfirmDialog(this,"Are you sure?","Exit game",JOptionPane.YES_NO_OPTION) == 0)
            {
                System.exit(0);
            }
        }
        if(e.getSource() == aboutUs)
        {
            GameMenu.showAboutUsPage = true;
        }
        if(e.getSource() == startGame)
        {
            GameMenu.runGame = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == startGame)
            startGame.setFont(startGame.getFont().deriveFont(22.0f));
        if(e.getSource() == exit)
            exit.setFont(exit.getFont().deriveFont(22.0f));
        if(e.getSource() == aboutUs)
            aboutUs.setFont(aboutUs.getFont().deriveFont(22.0f));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == startGame){
            startGame.setFont(startGame.getFont().deriveFont(25.0f));
            startGame.setForeground(new Color(224, 224, 224));
        }
        if(e.getSource() == exit){
            exit.setFont(exit.getFont().deriveFont(25.0f));
            exit.setForeground(new Color(224, 224, 224));
        }
        if(e.getSource() == aboutUs){
            aboutUs.setFont(aboutUs.getFont().deriveFont(25.0f));
            aboutUs.setForeground(new Color(224, 224, 224));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == startGame){
            //startGame.setFont(startGame.getFont().deriveFont(30.0f));
            startGame.setForeground(new Color (239, 239, 239));
        }
        if(e.getSource() == exit){
            //exit.setFont(exit.getFont().deriveFont(30.0f));
            exit.setForeground(new Color (225, 225, 225));
        }
        if(e.getSource() == aboutUs){
            //aboutUs.setFont(aboutUs.getFont().deriveFont(30.0f));
            aboutUs.setForeground(new Color (239, 239, 239));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == startGame){
            //startGame.setFont(startGame.getFont().deriveFont(25.0f));
            startGame.setForeground(new Color(224, 224, 224));
        }
        if(e.getSource() == exit){
            //exit.setFont(exit.getFont().deriveFont(25.0f));
            exit.setForeground(new Color (200, 200, 200));
        }
        if(e.getSource() == aboutUs){
            //aboutUs.setFont(aboutUs.getFont().deriveFont(25.0f));
            aboutUs.setForeground(new Color(224, 224, 224));
        }

    }
    public GameMenu(){}
}
