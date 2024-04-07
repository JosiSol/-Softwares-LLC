package Memory;

//main class that will handle the interaction between the game objects/components
public class Game {
	
	GamePanel gamePanel = new GamePanel();
	
    public static void main(String[] args)
    {   
        GameMenu gameMenu = new GameMenu();
        CompanyLogo companyLogo = new CompanyLogo();
        GamePanel gamePanel = new GamePanel();
        //make the user unable to resize until logo finishes loading cuz otherwise it wont be at the center of the screen
        gamePanel.setResizable(false);
        gamePanel.getContentPane().add(companyLogo);
        while(companyLogo.getDisplayingLogo()){}//just wasting time till the logo is done displaying
        gamePanel.getContentPane().remove(companyLogo);
        gamePanel.setResizable(true);
        
        
        gamePanel.getContentPane().add(gameMenu);// button wont be visibile after adding unless we refresh the screen or set the bounds
        

    }
}
