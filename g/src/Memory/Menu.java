package Memory;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu extends Game {
	
	public Menu(GamePanel gp) {
		
		//create a panel class that handles the buttons and what not and add it to the gamepanel later
		JButton b1 = new JButton("Click Me");
        b1.setVisible(true);
        b1.setOpaque(false);
        b1.setBounds(50,100,200,50);
        
        JLabel jlabel1 = new JLabel();
        jlabel1.setText("This is the menu");
        jlabel1.setVisible(true);
        jlabel1.setBounds(50,20,200,50);
        
        gp.getContentPane().add(b1);// button wont be visible after adding unless we refresh the screen or set the bounds
        gp.getContentPane().add(jlabel1);
        
        //should refresh the page to show the menu screen after logo
        gp.repaint();
	}
		
	
}
