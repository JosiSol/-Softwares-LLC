package Memory;

//main class that will handle the interaction between the game objects/components
public class Game {
	
    public static void main(String[] args)
    {   
        AboutUs aboutUs = new AboutUs();
        GameMenu gameMenu = new GameMenu();
        CompanyLogo companyLogo = new CompanyLogo();
        GamePanel gamePanel = new GamePanel();
        //make the user unable to resize until logo finishes loading cuz otherwise it wont be at the center of the screen
        gamePanel.setResizable(false);
        gamePanel.getContentPane().add(companyLogo);
        gamePanel.pack();
        while(companyLogo.getDisplayingLogo()){}//just wasting time till the logo is done displaying
        gamePanel.getContentPane().remove(companyLogo);
        gamePanel.setResizable(true);
        
        while(true){

            gamePanel.getContentPane().add(gameMenu);// button wont be visibile after adding unless we refresh the screen or set the bounds   
            gamePanel.repaint();
            gamePanel.pack();
            while(!GameMenu.showAboutUsPage){}//waste timer till user makes a choice
            gamePanel.getContentPane().remove(gameMenu);
            System.out.println("rightt");
            if(GameMenu.showAboutUsPage)
            {
                // add panel that holds thingys
                gamePanel.getContentPane().add(aboutUs);
                gamePanel.repaint();
                gamePanel.pack();
                System.out.println("right");
                while(GameMenu.showAboutUsPage){}/*back button wasn't clicked*/
                gamePanel.remove(aboutUs);
                
            }
            else //if game start 
            {
                System.out.println("wrong");
                //start game
                //while exit wasnt clicked
            }

    }

    }
}
