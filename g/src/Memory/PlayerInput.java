package Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class PlayerInput extends JPanel implements MouseListener, ActionListener {
    JLabel back, choice = new JLabel("Select Difficulty: ");
    JLabel playerOne, playerTwo, caption = new JLabel("Please Click Set or Enter Key After Writing Player's Name");
    JTextField playerOneInput, playerTwoInput;
    JButton set1, set2, edit1, edit2;
    JButton startGame;
    ImageIcon backButtonImg = new ImageIcon("Assets/backButton.png");
    JLabel backButton = new JLabel(backButtonImg);
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image newCur1 = tk.getImage("Assets/cursorMain.png");

    String [] gridName = {"Easy","Medium","Hard"};
    JComboBox<String> grid = new JComboBox<>(gridName);

    static String playerOneName = "Player1", playerTwoName = "Player2";

    private Font inputFont; //declare a font reference
    private final File location = new File("Assets/GethoBold-v0wD.ttf"); //location of the font
    
    {
        this.setLayout(null);

        this.setPreferredSize(new Dimension(1200, 600));

        Cursor mainCursor = tk.createCustomCursor(newCur1, getLocation(), TOOL_TIP_TEXT_KEY);

        this.setCursor(mainCursor);

        back = new JLabel("Back");
        back.setBounds(56, 19, 200, 30);
        back.setForeground(new Color(55, 55, 55));
        back.addMouseListener(this);

        choice.setBounds(850,40,600,100);

        backButton.setBounds(30, 18, 25, 25);
        backButton.addMouseListener(this);

        playerOne = new JLabel("Enter Player One's Name: ");
        playerOne.setBounds(100, 80 , 330, 35);
        playerTwo = new JLabel("Enter Player Two's Name: ");
        playerTwo.setBounds(100, 135 , 330, 35);
        caption.setBounds(100,200,800,35);

        playerOneInput = new JTextField(35);
        playerOneInput.setBounds(390, 80 , 150, 35);
        playerTwoInput = new JTextField(35);
        playerTwoInput.setBounds(390, 135 , 150, 35);

        set1 = new JButton("Set");
        set2 = new JButton("Set");
        set1.setBounds(570, 80 , 70, 40);
        set2.setBounds(570, 135 , 70, 40);

        edit1 = new JButton("Edit");
        edit2 = new JButton("Edit");
        edit1.setBounds(650, 80 , 80, 40);
        edit2.setBounds(650, 135 , 80, 40);

        startGame = new JButton("Start Game");
        startGame.setBounds(490, 300, 200, 50);

        grid.setBounds(850,100,100,30);
        this.add(grid);

        try {
            inputFont = Font.createFont(Font.TRUETYPE_FONT, location);
            inputFont = inputFont.deriveFont(22.0f); // Set it to preferred size
            playerOne.setFont(inputFont);
            playerTwo.setFont(inputFont);
            caption.setFont(inputFont);
            startGame.setFont(inputFont);
            set1.setFont(inputFont);
            set2.setFont(inputFont);
            edit2.setFont(inputFont);
            edit1.setFont(inputFont);
            back.setFont(inputFont);
            choice.setFont(inputFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Handle exception when loading custom font
        }

        this.add(playerOne);
        this.add(playerTwo);
        this.add(caption);
        this.add(playerOneInput);
        this.add(playerTwoInput);
        this.add(set1);
        this.add(set2);
        this.add(startGame);
        this.add(edit1);
        this.add(edit2);
        this.add(backButton);
        this.add(back);
        this.add(choice);

        edit1.setVisible(false);
        edit2.setVisible(false);

        startGame.addMouseListener(this);
        set1.addMouseListener(this);
        set2.addMouseListener(this);
        edit1.addMouseListener(this);
        edit2.addMouseListener(this);
        back.addMouseListener(this);
        backButton.addMouseListener(this);
        playerOneInput.addActionListener(this);
        playerTwoInput.addActionListener(this);


        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            if (e.getSource() == startGame) {
                GameMenu.playerChoice = false;
                GameMenu.runGame = true;
                if (playerTwoInput.getText().isEmpty()) {
                    PlayerInput.playerTwoName = "Player Two";
                }
                if (playerOneInput.getText().isEmpty()) {
                    PlayerInput.playerOneName = "Player One";
                }

                CardGame.gridSize = grid.getSelectedIndex();
            } else if (e.getSource() == set1) {
                edit1.setVisible(true);
                playerOneInput.setEditable(false);
                playerOneName = playerOneInput.getText();
                if (PlayerInput.playerOneName.isEmpty()) {
                    PlayerInput.playerOneName = "Player One";
                }
            } else if (e.getSource() == set2) {
                edit2.setVisible(true);
                playerTwoInput.setEditable(false);
                playerTwoName = playerTwoInput.getText();
                if (PlayerInput.playerTwoName.isEmpty()) {
                    PlayerInput.playerTwoName = "Player Two";
                }
            } else if (e.getSource() == edit1) {
                playerOneInput.setEditable(true);
            } else if (e.getSource() == edit2) {
                playerTwoInput.setEditable(true);
            } else if (e.getSource() == back || e.getSource() == backButton) {
                GameMenu.playerChoice = false;
            }
        }catch(RuntimeException ex){
            System.out.println("Mouse Pixel Click Error!");
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        if (e.getSource() == back) {
            back.setFont(back.getFont().deriveFont(20.0f));
        }
        if (e.getSource() == backButton) {
            back.setFont(back.getFont().deriveFont(20.0f));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){
        if (e.getSource() == back) {
            back.setFont(back.getFont().deriveFont(22.0f));
        }
        if (e.getSource() == backButton) {
            back.setFont(back.getFont().deriveFont(22.0f));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e){
        if (e.getSource() == back) {
            back.setForeground(new Color(75, 75, 75));
        }
        if (e.getSource() == backButton) {
            back.setForeground(new Color(75, 75, 75));
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if (e.getSource() == back || e.getSource() == backButton) {
            back.setFont(back.getFont().deriveFont(22.0f));
            back.setForeground(new Color(55, 55, 55));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == playerOneInput){
            edit1.setVisible(true);
            playerOneInput.setEditable(false);
            playerOneName = playerOneInput.getText();
            if (PlayerInput.playerOneName.isEmpty()) {
                PlayerInput.playerOneName = "Player One";
            }
        }
        else if(e.getSource() == playerTwoInput){
            edit2.setVisible(true);
            playerTwoInput.setEditable(false);
            playerTwoName = playerTwoInput.getText();
            if (PlayerInput.playerTwoName.isEmpty()) {
                PlayerInput.playerTwoName = "Player Two";
            }
        }
    }
}
