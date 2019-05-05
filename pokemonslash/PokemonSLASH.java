package pokemonslash;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokemonSLASH {

    public static Game myGame;
   //start game manue

    public PokemonSLASH() {
    }
    public static void main(String[] args) {

        System.out.println("Welcome to SLASH's Pokemon Project");
        int choice;
        Scanner keyboard = new Scanner(System.in);
        do {

            System.out.println("　　 へ　　　　　／|\n"
                    + "　　/＼7　　　 ∠＿/\n"
                    + "　 /　│　　 ／　／\n"
                    + "　│　Z ＿,＜　／　　 /`ヽ\n"
                    + "　│　　　　　ヽ　　 /　　〉\n"
                    + "　 Y　　　　　`　  /　　/\n"
                    + "　ｲ●　､　●　　⊂⊃〈　　/\n"
                    + "　()　 へ　　　　|　＼〈\n"
                    + "　　>ｰ ､_　 ィ　 │ ／／\n"
                    + "　 / へ　　 /　ﾉ＜| ＼＼\n"
                    + "　 ヽ_ﾉ　　(_／　 │／／\n"
                    + "　　7　　　　　　　|／\n"
                    + "　　＞―r￣￣`ｰ―＿　　　");
            //so cute
            
            
            System.out.println("|1.     Load game  |");
            System.out.println("|2.      New game  |");
            System.out.println("|3.     Save game  |");
            System.out.println("|4. Continue game  |");
            System.out.println("|5.     Exit game  |");
            choice = keyboard.nextInt();
            keyboard.nextLine();
            if (choice == 1) {
                myGame = loadGame();
            } else if (choice == 2) {
                System.out.println("Welcome to the pokemon world, you are the chosen one.\nOak the professor is waiting for you in the Pallet Town\nHis symbol is'D'");
                Game myGame = new Game();
                PokemonSLASH.myGame = myGame;
            } else if (choice == 3) {
                saveGame();
            } else if (choice == 4) {
                if (myGame == null) {
                    System.out.println("Please create a new game first");
                } else {
                    myGame.mainGameLoop();
                }
            }
            if (choice == 5) {
                break;
            }
            choice = 6;

        } while (choice > 5 || choice < 1);
    }

    private static Game loadGame() {
        Game buffer = null;
        //create location
        String location = "\\\\DATA\\Enhanced$\\hli\\Desktop\\game.object";
        //output hero from the file and return it as a buffered array
        try {
            ObjectInputStream myInputStream = new ObjectInputStream(new FileInputStream(location));
            buffer = (Game) myInputStream.readObject();
            myInputStream.close();
            System.out.println("Game loaded!");
        } catch (IOException e) {
            System.out.println("Could not find the file!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find the game!");
        }
        return buffer;
    }

    private static void saveGame() {
        //create location
        String location = "\\\\DATA\\Enhanced$\\hli\\Desktop\\game.object";
        //save hero
        try {
            ObjectOutputStream myStream = new ObjectOutputStream(new FileOutputStream(location));
            myStream.writeObject(myGame);
            myStream.close();
            System.out.println("Complete!");
        } catch (IOException ex) {
            Logger.getLogger(PokemonSLASH.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("failed");
        }
    }

}
