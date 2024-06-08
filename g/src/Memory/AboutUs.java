package Memory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class AboutUs extends JPanel implements MouseListener{
    JLabel tri;
    JButton button;
    ImageIcon icon = new ImageIcon("Assets/backButton.png");
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    {
        Cursor mainCursor = tk.createCustomCursor(newCur1,getLocation(),TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);
        this.setPreferredSize(new Dimension(1200,600));
        tri = new JLabel(icon);
        button = new JButton("Back");
        tri.addMouseListener(this);
        button.addMouseListener(this);
        this.add(tri);
        this.add(button);
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
