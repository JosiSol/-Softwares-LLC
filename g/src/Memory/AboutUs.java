package Memory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class AboutUs extends JPanel implements MouseListener{
    JLabel backButton,background,tri;
    ImageIcon icon = new ImageIcon("Assets/backButton.png");
    ImageIcon icon2 = new ImageIcon("Assets/Background.png");
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    private Font gameFont;
    {
        this.setLayout(null);
        Cursor mainCursor = tk.createCustomCursor(newCur1,getLocation(),TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);
        this.setPreferredSize(new Dimension(1200,600));
        this.setVisible(true);

        backButton = new JLabel(icon);
        backButton.setBounds(30,18,25,25);
        backButton.addMouseListener(this);


        tri = new JLabel("Back");

        try{
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            tri.setFont(gameFont);
        }
        catch(FontFormatException | IOException e ){
            e.printStackTrace();
        }

        tri.setBounds(56,19,200,30);
        tri.addMouseListener(this);

        background = new JLabel(icon2);
        background.setBounds(250,0,1000,600);

        this.add(backButton);
        this.add(tri);

        JLabel label = new JLabel("Welcome to Memory Game");
        label.setBounds(550,19,400,30);
        JLabel label2 = new JLabel("The Memory Game was Developed By:");
        label2.setBounds(325,70,600,30);
        JLabel label3 = new JLabel("1. Yosefe Tilahun          UGR/9673/15");
        label3.setBounds(450,120,600,30);
        JLabel label4 = new JLabel("2. Yabqal Brook            UGR/2822/15");
        label4.setBounds(450,170,600,30);
        JLabel label5 = new JLabel("3. Yohannes Ketema     UGR/6290/15");
        label5.setBounds(450,220,600,30);
        JLabel label6 = new JLabel("4. Natnael Mesfin     UGR/8654/15");
        label6.setBounds(450,270,600,30);
        JLabel label7 = new JLabel("5. Mikiyas Fasil     UGR/9231/15");
        label7.setBounds(450,320,600,30);
        JLabel label8 = new JLabel("6. Yosef Solomon     UGR/7358/15");
        label8.setBounds(450,370,600,30);

        try{
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            label.setFont(gameFont);
            label2.setFont(gameFont);
            label3.setFont(gameFont);
            label4.setFont(gameFont);
            label5.setFont(gameFont);
            label6.setFont(gameFont);
            label7.setFont(gameFont);
            label8.setFont(gameFont);

        }
        catch(FontFormatException | IOException e ){
            e.printStackTrace();
        }
        this.add(label);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(background);
    }
    @Override
    public void mouseClicked(MouseEvent e){
        GameMenu.showAboutUsPage = false;
        System.out.println("Back to square one");
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public AboutUs(){}
}
