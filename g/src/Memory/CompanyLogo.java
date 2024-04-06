package Memory;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CompanyLogo extends JPanel implements ActionListener{
    
    //make delay a constant
     private Timer t = new Timer(200, this);
     //use company logo and use constant for file path
     private ImageIcon i = new ImageIcon("g/Assets/QIBE Logo.png");
     private float alphaValue = 0f;
     private boolean operation = true;
     

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
        //create x and y final and set them here
        g2d.drawImage(i.getImage(), 0, 0, null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //over complicated logic fix later
       alphaValue = alphaValue + 0.1f;
       if( alphaValue > 1f)
       {
        operation = false;
       }
       if(!operation)
       {
        alphaValue = alphaValue - 0.2f;
        if(alphaValue <= 0)
        {
            alphaValue = 0;
            t.stop();
        }
       }

        repaint();
    }

    public boolean getDisplayingLogo()
    {
        return t.isRunning();
        
    }

    public CompanyLogo()
    {
        this.setOpaque(false);
        t.start();
    }
}
