package Memory;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.Color;

public class GameMenu extends JPanel implements MouseListener{
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    
    ImageIcon img = new ImageIcon("g/Assets/menuImage.jpg");
    JLabel startGame = new JLabel("START");
    JLabel aboutUs = new JLabel("ABOUT US");
    JLabel exit = new JLabel("EXIT");
    JLabel background = new JLabel(img);
    public static volatile boolean showAboutUsPage;
    public static volatile boolean runGame;

    {
        GameMenu.showAboutUsPage = false;
        this.setLayout(null);
        
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

        startGame.addMouseListener(this);
        aboutUs.addMouseListener(this);
        exit.addMouseListener(this);
        
        background.setBounds(0, 0, 1200, 700);

        startGame.setBounds(40, 120, 200, 30);
        startGame.setForeground(new Color(224, 224, 224));

        aboutUs.setBounds(40, 188, 200, 30);
        aboutUs.setForeground(new Color(224, 224, 224));

        exit.setBounds(40, 258, 200, 30);
        exit.setForeground(new Color (189, 189, 189));

        startGame.setFont(startGame.getFont().deriveFont(25.0f));
        aboutUs.setFont(aboutUs.getFont().deriveFont(25.0f));
        exit.setFont(exit.getFont().deriveFont(25.0f));

        
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
        startGame.setFont(startGame.getFont().deriveFont(23.0f));
        if(e.getSource() == exit)
        exit.setFont(exit.getFont().deriveFont(23.0f));
        if(e.getSource() == aboutUs)
        aboutUs.setFont(aboutUs.getFont().deriveFont(23.0f));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == exit)
        exit.setFont(exit.getFont().deriveFont(30.0f));
        if(e.getSource() == aboutUs)
        aboutUs.setFont(aboutUs.getFont().deriveFont(30.0f));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == startGame)
            startGame.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == exit)
            exit.setFont(exit.getFont().deriveFont(30.0f));
        if(e.getSource() == aboutUs)
            aboutUs.setFont(aboutUs.getFont().deriveFont(30.0f));

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == startGame)
            startGame.setFont(startGame.getFont().deriveFont(25.0f));
        if(e.getSource() == exit)
            exit.setFont(exit.getFont().deriveFont(25.0f));
        if(e.getSource() == aboutUs)
            aboutUs.setFont(aboutUs.getFont().deriveFont(25.0f));

    }
    public GameMenu(){}
}
