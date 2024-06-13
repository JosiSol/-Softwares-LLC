package Memory;

public final class Player {
    // Define an enumeration to represent the choice of player turn
    public static enum Choice { FIRST, SECOND };

    // Static variables to track the current turn and the player's choice
    public static Choice Turn = Choice.FIRST;
    public static Choice choiceNum = Choice.FIRST;

    // Array to store the two chosen cards
    public static Card[] choices = new Card[2];

    // Instance variable to track the player's score
    int playerScore = 0;

    // Method to increment the player's score by one
    public int oneUp() {
        playerScore++;
        return playerScore;
    }

    // Method to get the current score of the player
    public int getScore() {
        return playerScore;
    }
}
