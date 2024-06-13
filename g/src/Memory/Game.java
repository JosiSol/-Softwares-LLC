package Memory;

// Main class that will handle the interaction between the game objects/components
public class Game {

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();    // Create an instance of the CardGame
        PlayerInput playerInput = new PlayerInput(); // Create an instance of PlayerInput
        UserGuide userGuide = new UserGuide();
        AboutUs aboutUs = new AboutUs();       // Create an instance of AboutUs
        GameMenu gameMenu = new GameMenu();    // Create an instance of GameMenu
        CompanyLogo companyLogo = new CompanyLogo(); // Create an instance of CompanyLogo
        GamePanel gamePanel = new GamePanel(); // Create an instance of GamePanel

        // Make the user unable to resize the window until the logo finishes loading
        // Otherwise, it won't be at the center of the screen
        gamePanel.setResizable(false);
        gamePanel.getContentPane().add(companyLogo); // Add company logo to game panel
        gamePanel.pack(); // Pack the components within the window

        // Wait until the logo is done displaying
        while (companyLogo.getDisplayingLogo()) {
        }

        gamePanel.getContentPane().remove(companyLogo); // Remove the company logo
        // Do not allow the user to change the screen size at all
        // gamePanel.setResizable(true);

        // Main game loop
        while (true) {
            gamePanel.getContentPane().add(gameMenu); // Add game menu to game panel
            gamePanel.repaint(); // Repaint the game panel
            gamePanel.pack(); // Pack the components within the window

            // Wait until the user makes a choice (About Us, Run Game, or Player Choice)
            while (!GameMenu.showAboutUsPage && !GameMenu.runGame &&
                    !GameMenu.playerChoice &&
                    !GameMenu.playerHistory && !GameMenu.userGuide) {
            }

            gamePanel.getContentPane().remove(gameMenu); // Remove the game menu

            // If the user chooses to view the About Us page
            if (GameMenu.showAboutUsPage) {
                gamePanel.getContentPane().add(aboutUs); // Add About Us page to game panel
                gamePanel.repaint(); // Repaint the game panel
                gamePanel.pack(); // Pack the components within the window
                System.out.println("right");

                // Wait until the back button is clicked on the About Us page
                while (GameMenu.showAboutUsPage) {
                }

                gamePanel.remove(aboutUs); // Remove the About Us page
            }
            if (GameMenu.userGuide) {
                gamePanel.getContentPane().add(userGuide); // Add About Us page to game panel
                gamePanel.repaint(); // Repaint the game panel
                gamePanel.pack(); // Pack the components within the window
                System.out.println("right");

                // Wait until the back button is clicked on the About Us page
                while (GameMenu.userGuide) {
                }

                gamePanel.remove(userGuide); // Remove the About Us page
            }
            // If the user chooses to input player details
            else if (GameMenu.playerChoice) {
                gamePanel.getContentPane().add(playerInput); // Add Player Input page to game panel
                gamePanel.repaint(); // Repaint the game panel
                gamePanel.pack(); // Pack the components within the window
                System.out.println("cool");

                // Wait until the user finishes entering player details
                while (GameMenu.playerChoice) {
                }

                gamePanel.remove(playerInput); // Remove the Player Input page
            }
            else if (GameMenu.playerHistory) {
                DisplayHistory newDisplay = new DisplayHistory(); //create an object every time we want to see the history
                gamePanel.getContentPane().add(newDisplay); //add it to the pane
                gamePanel.repaint(); // Repaint the game panel
                gamePanel.pack(); // Pack the components within the window

                // Wait until the back button is clicked or the game ends
                while (GameMenu.playerHistory) {
                }

                gamePanel.remove(newDisplay); // Remove the display
            }
            // If the user chooses to start the game
            else if (GameMenu.runGame) {
                cardGame.start(); // Start the card game
                gamePanel.getContentPane().add(cardGame); // Add the card game to the game panel
                gamePanel.repaint(); // Repaint the game panel
                gamePanel.pack(); // Pack the components within the window

                // Wait until the back button is clicked or the game ends
                while (GameMenu.runGame) {
                }

                gamePanel.remove(cardGame); // Remove the card game
                cardGame.restore(); // Restore the card game to its initial state
            }
        }
    }
}