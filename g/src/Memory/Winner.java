package Memory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

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
        winner.setBounds(500,85,300,200);

        retry = new JLabel("Retry");
        retry.setBounds(350,200,250,250);
        retry.addMouseListener(this);

        mainMenu = new JLabel("Return to Main Menu");
        mainMenu.setBounds(660,200,300,250);
        mainMenu.addMouseListener(this);

        this.add(winner);
        this.add(retry);
        this.add(mainMenu);
        timer.setRepeats(false);

    }
    public Winner(int p1) {
        try {
            File location = new File("Assets/GethoBold-v0wD.ttf");
            gameFont = Font.createFont(Font.TRUETYPE_FONT, location).deriveFont(25.0f);
            winner.setFont(gameFont);
            retry.setFont(gameFont);
            mainMenu.setFont(gameFont);
            if (p1 > 0) {
                winner.setText("WINNER! " + PlayerInput.playerOneName );
                this.setBackground(Color.RED);
            } else if (p1 == 0) {
                winner.setText("DRAW!");
                this.setBackground(Color.LIGHT_GRAY);
            } else {
                winner.setText("WINNER! " + PlayerInput.playerTwoName);
                this.setBackground(Color.BLUE);
            }
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
            @Override
            public void mouseClicked (MouseEvent e){
            GameMenu.runGame = false;
            System.out.println("Back to square one");
            if (e.getSource() == retry) {
                GameMenu.runGame = true;
            }
        }

            @Override
            public void mousePressed (MouseEvent e){
            }

            @Override
            public void mouseReleased (MouseEvent e){
            }

            @Override
            public void mouseEntered (MouseEvent e){
            }

            @Override
            public void mouseExited (MouseEvent e){
            }
        }