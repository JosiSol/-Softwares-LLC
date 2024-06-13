package Memory;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

//resizing will make it obvious that the logo isn't centered so fix that too
public class CompanyLogo extends JLabel implements ActionListener{
    // rearrange
     private final int delay = 2200;//milliseconds before the event happens again
     private final Timer logoTimer = new Timer(delay, this);////timer that handles the firing of the event every delay milliseconds
     private final String LOGO_PIC = "Assets/logologo.gif";//path of the company logo pic(currently a placeholder)
     private final ImageIcon COMPANY_LOGO = new ImageIcon(LOGO_PIC);//field that holds the image
     //initialize both somewhere else
     private final float alphaValue = 0f;//Value that decides how visible/transparent the image is
     private final boolean operation = true;//flag that decides wether to increase or decrease alphaValue
     private final int X_POS = 0;// (width of frame - width of image)
     private final int Y_POS = 0;// (height of frame - height of image)
     private final JLabel log = new JLabel(new ImageIcon(LOGO_PIC));
     
     {
        log.setBounds(X_POS, Y_POS, 1200, 600);
        this.add(log);
     }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {}

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
        this.setPreferredSize(new Dimension(1200,600));
        this.setOpaque(false);
        logoTimer.setRepeats(false);
        logoTimer.start();//starts the timer
    }
}
