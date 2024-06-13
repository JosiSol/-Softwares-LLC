package Memory;

import java.io.FileWriter;
import java.io.IOException;

public class History extends CardGame {

    static String storage1, storage2;

    static void writeFile(){
        try{
            String str = "\n" + PlayerInput.playerOneName + " vs " + PlayerInput.playerTwoName + " (" + storage1 +
                    " - " + storage2 + ")";

            // attach a file to FileWriter
            FileWriter newWriter = new FileWriter("output.txt", true);

            for (int i = 0; i < str.length(); i++)         // read character from string and write into FileWriter
                newWriter.append(str.charAt(i));

            System.out.println("Writing successful");
            //close the file
            newWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
