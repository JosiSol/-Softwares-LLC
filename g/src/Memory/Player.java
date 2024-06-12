package Memory;

public final class Player {
    public static enum Choice{FIRST, SECOND};

    public static Choice Turn = Choice.FIRST;
    public static Choice choiceNum = Choice.FIRST;
    public static Card[] choices = new Card[2];
    int playerScore = 0;

    public int oneUp(){
        playerScore++;
        return playerScore;
    }
}
