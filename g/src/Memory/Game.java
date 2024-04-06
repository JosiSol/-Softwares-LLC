package Memory;

public class Game {
	
	GamePanel gamePanel = new GamePanel();
	
    public static void main(String[] args)
    {
    	Game newGame = new Game();
        //declare logo before panel to make sure the panel will be displayed immediately when the logo is displayed
        //i.e giving the logo time to load
        //if we don't do that it wont be displayed half of the time
        //other way of fixing this is by refreshing the gamepanel automatically
    	
        /*writing it in this format works too
        Gamepanel gamepanel = new Gamepanel());
        CompanyLogo c = new CompanyLogo();
        gamepanel.setVisible(true);
        gamepanel.getContentPane().add(c);
         */
        
        CompanyLogo companyLogo = new CompanyLogo();
        
        newGame.gamePanel.createGamePanel();
        newGame.gamePanel.getContentPane().add(companyLogo);
        while(companyLogo.getDisplayingLogo()){}//just wasting time till the logo is done displaying
        
        newGame.gamePanel.getContentPane().remove(companyLogo);
        
        //displays the menu screen
        new Menu(newGame.gamePanel);

    }
}
