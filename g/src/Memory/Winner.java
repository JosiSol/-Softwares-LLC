package Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Winner extends JPanel implements MouseListener {
    JLabel winner, retry, mainMenu;
    private Timer timer = new Timer(10, e -> {
       GameMenu.runGame = true;
    });
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");
    private Font gameFont;
    {
        Cursor mainCursor = tk.createCustomCursor(newCur1,getLocation(),TOOL_TIP_TEXT_KEY);
        this.setCursor(mainCursor);
        this.setPreferredSize(new Dimension(1200,600));
        this.setVisible(true);

        this.setBounds(0, 0, 1200, 600);

        winner = new JLabel();
        winner.setBounds(425,100,250,200);

        retry = new JLabel("Retry");
        retry.setBounds(350,200,250,250);
        retry.setFont(new Font("Serif", Font.BOLD, 25));
        retry.addMouseListener(this);

        mainMenu = new JLabel("Return to Main Menu");
        mainMenu.setBounds(650,200,250,250);
        mainMenu.setFont(new Font("Serif", Font.BOLD, 25));
        mainMenu.addMouseListener(this);

        this.add(winner);
        this.add(retry);
        this.add(mainMenu);
        timer.setRepeats(false);

    }
    public Winner(int p1){
        if(p1 > 0) {
            winner.setText("WINNER! Player 1!");
            winner.setFont(new Font("Serif", Font.BOLD, 28));
            this.setBackground(Color.RED);
        }
        else if(p1 == 0){
            winner.setText("DRAW!");
            winner.setFont(new Font("Serif", Font.BOLD, 28));
            this.setBackground(Color.LIGHT_GRAY);
            }
        else{
            winner.setText("WINNER! Player 2!");
            winner.setFont(new Font("Serif", Font.BOLD, 28));
            this.setBackground(Color.BLUE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GameMenu.runGame = false;
        System.out.println("Back to square one");
        if (e.getSource() == retry){
            timer.start();
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
}
