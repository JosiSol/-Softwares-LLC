package Memory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class AboutUs extends JPanel implements MouseListener{
    JLabel tri,label;
    ImageIcon icon = new ImageIcon("Assets/backButton.png");
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    {
        Cursor mainCursor = tk.createCustomCursor(newCur1,getLocation(),TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);
        this.setPreferredSize(new Dimension(1200,600));
        tri = new JLabel(icon);
        label = new JLabel("Back");
        tri.setBounds(30, 18, 25, 25);
        label.setBounds(32,18,25,25);
        tri.addMouseListener(this);
        label.addMouseListener(this);
        this.add(tri);
        this.add(label);
        this.add(new JLabel("                                               "));
        this.add(new JLabel("Memory Game Developed By:   "));
        this.add(new JLabel("1. Yosefe Tilahun  UGR/9673/15     "));
        this.add(new JLabel("2. Yabqal Brook    UGR/2822/15     "));
        this.add(new JLabel("3. Yohannes Ketema UGR/6290/15     "));
        this.add(new JLabel("4. Natnael Mesfin  UGR/8654/15     "));
        this.add(new JLabel("5. Yosef Solomon   UGR/7358/15     "));
        this.add(new JLabel("6. Mikiyas Fasil   UGR/9231/15     "));
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
