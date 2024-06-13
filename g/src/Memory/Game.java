package Memory;

// Main class that will handle the interaction between the game objects/components
public class Game {

    public static void main(String[] args) {
        // Create an instance of the Classes
        CardGame cardGame = new CardGame();
        PlayerInput playerInput = new PlayerInput();
        AboutUs aboutUs = new AboutUs();
        GameMenu gameMenu = new GameMenu();
        CompanyLogo companyLogo = new CompanyLogo();
        GamePanel gamePanel = new GamePanel();

        // Make the user unable to resize the window until the logo finishes loading
        // Otherwise, it won't be at the center of the screen
        gamePanel.setResizable(false);
        gamePanel.getContentPane().add(companyLogo);
        gamePanel.pack();

        // Wait until the logo is done displaying
        while (companyLogo.getDisplayingLogo()) {
        }

        gamePanel.getContentPane().remove(companyLogo); // Remove the company logo

        // Main game loop
        while (true) {
            gamePanel.getContentPane().add(gameMenu);
            gamePanel.repaint();
            gamePanel.pack();

            // Wait until the user makes a choice (About Us, Run Game, or Player Choice)
            while (!GameMenu.showAboutUsPage && !GameMenu.runGame && !GameMenu.playerChoice) {
            }

            gamePanel.getContentPane().remove(gameMenu); // Remove the game menu

            // If the user chooses to view the About Us page
            if (GameMenu.showAboutUsPage) {
                gamePanel.getContentPane().add(aboutUs);
                gamePanel.repaint();
                gamePanel.pack();

                // Wait until the back button is clicked on the About Us page
                while (GameMenu.showAboutUsPage) {
                }
                gamePanel.remove(aboutUs);
            }
            // If the user chooses to input player details
            else if (GameMenu.playerChoice) {
                gamePanel.getContentPane().add(playerInput);
                gamePanel.repaint();
                gamePanel.pack();

                // Wait until the user finishes entering player details
                while (GameMenu.playerChoice) {
                }

                gamePanel.remove(playerInput);
            }
            // If the user chooses to start the game
            else if (GameMenu.runGame) {
                cardGame.start(); // Start the card game
                gamePanel.getContentPane().add(cardGame);
                gamePanel.repaint();
                gamePanel.pack();

                // Wait until the back button is clicked or the game ends
                while (GameMenu.runGame) {
                }

                gamePanel.remove(cardGame);
                cardGame.restore(); // Restore the card game to its initial state
            }
        }
    }
}
