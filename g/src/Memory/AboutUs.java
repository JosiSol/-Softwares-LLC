package Memory;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutUs extends JPanel implements MouseListener{
    JLabel tri;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("g/Assets/cursorMain.png");
    {
        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);
        this.setPreferredSize(new Dimension(1200,600));
        this.setVisible(true);
        this.setBackground(Color.red);
        tri = new JLabel("Back");
        tri.addMouseListener(this);
        this.add(tri);
        this.add(new JLabel("                                               "));
        this.add(new JLabel("Memory Game Developed By "));
        this.add(new JLabel("1. Yosefe Tilahun  UGR/9673/15"));
        this.add(new JLabel("2. Yabqal Brook    UGR/2822/15"));
        this.add(new JLabel("3. Yohannes Ketema UGR/6290/15"));
        this.add(new JLabel("4. Natnael Mesfin  UGR/8654/15"));
        this.add(new JLabel("5. Yosef Solomon   UGR/7358/15"));
        this.add(new JLabel("6. Mikiyas Fasil   UGR/9231/15"));
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
