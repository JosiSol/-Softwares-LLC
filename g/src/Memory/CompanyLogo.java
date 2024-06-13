package Memory;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

// CompanyLogo class extends JLabel and implements ActionListener for handling timer events
public class CompanyLogo extends JLabel implements ActionListener {
    // Delay in milliseconds before the event happens again
    private final int delay = 2200;
    // Timer that handles the firing of the event every delay milliseconds
    private final Timer logoTimer = new Timer(delay, this);
    // Path of the company logo pic (currently a placeholder)
    private final String LOGO_PIC = "Assets/logologo.gif";
    // X and Y positions for the logo (width of frame - width of image, height of frame - height of image)
    private final int X_POS = 0;
    private final int Y_POS = 0;
    // JLabel to display the logo
    private final JLabel log = new JLabel(new ImageIcon(LOGO_PIC));

    // Initializer block to set up the logo JLabel
    {
        log.setBounds(X_POS, Y_POS, 1200, 600);
        this.add(log);
    }

    // Method called when the timer event is fired
    @Override
    public void actionPerformed(ActionEvent e) {}

    // Method to check if the logo is currently being displayed (timer is running)
    public boolean getDisplayingLogo() {
        return logoTimer.isRunning();
    }

    // Constructor for CompanyLogo
    public CompanyLogo() {
        // Set preferred size of the label
        this.setPreferredSize(new Dimension(1200, 600));
        // Make the label's background invisible
        this.setOpaque(false);
        // Set timer to not repeat
        logoTimer.setRepeats(false);
        // Start the timer
        logoTimer.start();
    }
}
