package Memory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Card extends JLabel implements MouseListener, ActionListener {

    public int pic; // Used to choose the sprite
    private Timer t = new Timer(400, this); // Timer for animation or delay
    private volatile boolean taken = false; // Flag to indicate if the card is taken
    // Make private and add setter method
    public boolean closed = true; // Flag to indicate if the card is face-down or face-up

    {
        t.setRepeats(false); // Set timer to not repeat automatically
        this.setIcon(new ImageIcon("Assets/initial.png")); // Set default icon for the card
        this.addMouseListener(this); // Add mouse listener to handle mouse events
        this.setVisible(true); // Make the card visible
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (closed) {
            this.setIcon(new ImageIcon("Assets/cgr" + pic + ".gif")); // Set image when card is clicked
            t.start(); // Start the timer for animation or delay
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    // Method to set the card image when there is a failure match
    void fail() {
        this.setIcon(new ImageIcon("Assets/cg" + pic + ".gif")); // Set failure image
        t.start(); // Start the timer for animation or delay
    }

    // Constructor with position and sprite choice
    Card(int posX, int posY, int pic) {
        this.setBounds(posX, posY, 50, 66); // Set position and size of the card
        this.pic = pic; // Assign sprite choice
    }

    // Default constructor
    Card() {
        this.setBounds(100, 100, 100, 100); // Default position and size
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (closed) {
            this.setIcon(new ImageIcon("Assets/c" + pic + ".png")); // Set face-down image
        } else {
            this.setIcon(new ImageIcon("Assets/initial.png")); // Set initial image
        }

        closed = !closed; // Toggle the closed state of the card
    }

    // Getter method to check if the card is taken
    public boolean getTaken() {
        return this.taken;
    }

    // Method to mark the card as taken
    public void taken() {
        this.taken = true;
    }

    // Method to mark the card as not taken
    public void notTaken() {
        this.taken = false;
    }
}
