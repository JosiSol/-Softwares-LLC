package Memory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//game menu that will have options you can choose from when start the program
public class GameMenu extends JPanel implements MouseListener{
    //make into variables what needs to become variables/constants
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    //we could use images instead of text cuz cooler font and whatnot
    private JLabel startGame = new JLabel("Start");
    private JLabel exit = new JLabel("Exit");
    private JLabel aboutUs =  new JLabel("About us");
    public static volatile boolean showAboutUsPage;
    public static volatile boolean runGame;
    /*
     * using a static boolean for a while loop condition in
     * java seems to not work for me unless i add a sleep thread
     * inside the loop body (the condition is set to false
     *  from a different class once a cetain button is clicked)?
     *
     * Using a static boolean variable
     * for a while loop condition with modification from another class
     * can lead to unexpected behavior in Java due to a phenomenon called
     * "thread visibility."
     * Here's why your code might not work as expected:
     * Static Variables and Threads: When you declare a variable
     *  as static, it's shared across all threads in your program.
     *  However, changes made to a static variable by one thread
     * might not be immediately visible to other threads due to caching
     *  mechanisms within the JVM.
     * Visibility Issue: In your scenario, the thread running
     *  the while loop might have a cached value for the static
     *  boolean variable. Even if another thread
     * (triggered by a button click) sets it to false,
     *  the while loop thread might not see this update immediately,
     * causing the loop to continue.
     *
     * Solutions to Fix the Issue:
     *
     * Using volatile keyword:
     *
     * Declare the boolean variable as volatile within the class
     *  where it's used.
     * The volatile keyword ensures that any changes made to the variable
     *  are immediately visible to all threads.
     */


    {
        GameMenu.showAboutUsPage = false;
        this.setLayout(new FlowLayout(0,100,10));
        this.setBackground(Color.blue);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));//since the game panel has a boarder layout it will be resized to full screen either way
        //this.setVisible(true);

        startGame.addMouseListener(this);
        exit.addMouseListener(this);
        aboutUs.addMouseListener(this);

        //the widths arent random.
        //fontmetrics were used to figure out the correct widths(at least for the most part)
        startGame.setPreferredSize(new Dimension(70, 30));
        exit.setPreferredSize(new Dimension(56, 30));
        aboutUs.setPreferredSize(new Dimension(131, 30));

        startGame.setFont(startGame.getFont().deriveFont(20.0f));
        exit.setFont(startGame.getFont().deriveFont(20.0f));
        aboutUs.setFont(aboutUs.getFont().deriveFont(20.0f));



        this.add(startGame);
        this.add(aboutUs);
        this.add(exit);


        //set visibility true only after adding
        //might be automatically set to true for jlabels dunno
        startGame.setVisible(true);
        exit.setVisible(true);
        aboutUs.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
       
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

    //change the size of the label when you change the size of the font/text
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(10.0f));
        if(e.getSource() == exit)
        exit.setFont(startGame.getFont().deriveFont(10.0f));
        if(e.getSource() == aboutUs)
        aboutUs.setFont(startGame.getFont().deriveFont(10.0f));

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == startGame)
        startGame.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == exit)
        exit.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == aboutUs)
        aboutUs.setFont(startGame.getFont().deriveFont(30.0f));
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == startGame)
            startGame.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == exit)
            exit.setFont(startGame.getFont().deriveFont(30.0f));
        if(e.getSource() == aboutUs)
            aboutUs.setFont(startGame.getFont().deriveFont(30.0f));

    }


    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == startGame)
            startGame.setFont(startGame.getFont().deriveFont(20.0f));
        if(e.getSource() == exit)
            exit.setFont(startGame.getFont().deriveFont(20.0f));
        if(e.getSource() == aboutUs)
            aboutUs.setFont(startGame.getFont().deriveFont(20.0f));

    }
    public GameMenu(){}
}
