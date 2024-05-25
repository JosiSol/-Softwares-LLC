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
        tri = new JLabel("triangle");
        tri.addMouseListener(this);
        this.add(tri);
        this.add(new JLabel("Skrpap skrpap"));
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
