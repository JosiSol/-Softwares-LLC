package Memory;

//main class that will handle the interaction between the game objects/components
public class Game {
	/*there is a bug where the about us button isnt back to normal size when we click it then go back to the menu*/
    public static void main(String[] args)
    {   
        CardGame CardGame = new CardGame();
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
        //nvm just dont let bro change the screen size at all
        //gamePanel.setResizable(true);
        
        while(true){

            gamePanel.getContentPane().add(gameMenu);// button wont be visibile after adding unless we refresh the screen or set the bounds   
            gamePanel.repaint();
            gamePanel.pack();
            while(!GameMenu.showAboutUsPage && !GameMenu.runGame){}//waste timer till user makes a choice
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
            else if(GameMenu.runGame) 
            {
                // add panel that holds thingys
                gamePanel.getContentPane().add(CardGame);
                gamePanel.repaint();
                gamePanel.pack();
                while (GameMenu.runGame){}/*back button wasn't clicked and game didnt end*/
                gamePanel.remove(CardGame);
            }

    }

    }
}
