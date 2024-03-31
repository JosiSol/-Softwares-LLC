package Memory;

public class Game {
    public static void main(String[] args)
    {
        //declare logo before panel to make sure the panel will be displayed immediately when the logo is displayed
        //i.e giving the logo time to load
        //if we dont do that it wont be displayed half of the time
        //other way of fixing this is by refreshing the gamepanel automatically
        CompanyLogo c = new CompanyLogo();
        Gamepanel gamepanel = new Gamepanel();
        gamepanel.getContentPane().add(c);
        
    }
}
