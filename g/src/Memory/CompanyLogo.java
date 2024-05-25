package Memory;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

//resizing will make it obvious that the logo isnt centered so fix that too
public class CompanyLogo extends JLabel implements ActionListener{
    // rearrange
     private final int delay = 100;//milliseconds before the event happens again
     private Timer logoTimer = new Timer(delay, this);////timer that handles the firing of the event every delay milliseconds
     private final String LOGO_PIC = "g/Assets/QIBE Logo.png";//path of the company logo pic(currently a place holder)
     private final ImageIcon COMPANY_LOGO = new ImageIcon(LOGO_PIC);//field that holds the image
     //initialize both somewhere else
     private float alphaValue = 0f;//Value that decides how visible/transparent the image is
     private boolean operation = true;//flag that decides wether to increase or decrease alphaValue
     private final int X_POS = 0;// (width of frame - width of image)
     private final int Y_POS = -150;// (height of frame - height of image)
     
    //done
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;//graphics cant handle the operation so we use graphics2d instead
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));//sets the visibility of the image
        g2d.drawImage(COMPANY_LOGO.getImage(), X_POS, Y_POS, null);//draws the image at x and y pos
    }

    //simplify logic
    @Override
    public void actionPerformed(ActionEvent e) {
        //this function increases the alphavalue  repaints the image then waits until the timer calls it again
        //this keeps going until its 1(image fully visible) then reduces it till its 0(not visible) in a similar manner
        //then stops the timer that would have fired it again otherwise

        //overcomplicated logic fix later
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
            logoTimer.stop();
        }
       }

        repaint();//to update the image after its alphavalue has been updated
    }

    //done
    public boolean getDisplayingLogo()
    {
        return logoTimer.isRunning();//returns the timers current state 
    }

    public CompanyLogo()
    {
        //here is the thing, while the label only has a pic on it the actual label covers the whole frame
        //that means the label has a background that covers the white background of the frame. we can fix 
        //that by setting setOpaque to false, making the label's background invisible
        this.setPreferredSize(new Dimension(1000,600));
        this.setOpaque(false);
        logoTimer.start();//starts the timer
    }
}
