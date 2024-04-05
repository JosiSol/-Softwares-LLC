package Memory;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Game {
    public static void main(String[] args)
    {
        //declare logo before panel to make sure the panel will be displayed immediately when the logo is displayed
        //i.e giving the logo time to load
        //if we dont do that it wont be displayed half of the time
        //other way of fixing this is by refreshing the gamepanel automatically
        /*writing it in this format works too
        Gamepanel gamepanel = new Gamepanel());
        CompanyLogo c = new CompanyLogo();
        gamepanel.setVisible(true);
        gamepanel.getContentPane().add(c);
         */
        //create a panel class that handles the buttons and what not and add it to the gamepanel later
        JButton b1 = new JButton("click me please");
        b1.setVisible(true);
        b1.setOpaque(false);
        b1.setBounds(50,100,100,50);
        
        CompanyLogo companyLogo = new CompanyLogo();
        GamePanel gamePanel = new GamePanel();
        gamePanel.getContentPane().add(companyLogo);
        while(companyLogo.getDisplayingLogo()){}//just wasting time till the logo is done displaying
        
        gamePanel.getContentPane().remove(companyLogo);
        
        
        gamePanel.getContentPane().add(b1);// button wont be visibile after adding unless we refresh the screen or set the bounds
        

    }
}
