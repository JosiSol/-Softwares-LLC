package Memory;

import Memory.Player.Choice;

public final class Player {
    public static enum Choice{FIRST, SECOND};

    public static Choice Turn = Choice.FIRST;
    public static Choice choiceNum = Choice.FIRST;
    public static Card[] choices = new Card[2];
    
}