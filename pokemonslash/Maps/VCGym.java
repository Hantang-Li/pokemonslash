package pokemonslash.Maps;

import java.util.Scanner;
import pokemonslash.*;
import pokemonslash.Battle.Battle3;
import pokemonslash.Pokemons.SampleMoves.Bite;
import pokemonslash.Pokemons.SampleMoves.DragonRage;
import pokemonslash.Pokemons.SampleMoves.Ember;
import pokemonslash.Pokemons.SampleMoves.Growl;
import pokemonslash.Pokemons.SampleMoves.PoisonSting;
import pokemonslash.Pokemons.SampleMoves.Scratch;
import pokemonslash.Pokemons.SampleMoves.StringShot;
import pokemonslash.Pokemons.SampleMoves.Tackle;
import pokemonslash.Pokemons.pokemonClass.Charmeleon;
import pokemonslash.Pokemons.pokemonClass.Gyarados;
import pokemonslash.Pokemons.pokemonClass.Weedle;

public class VCGym extends GameMap {

    public VCGym() {
        super(10, 11, "VCGym");
        fillMap();
        fillMapWithNpc();
    }
    public boolean fightTrainer1;

    public void fillMap() {
        int i, j;

        //Floor
        for (j = 0; j < 10; j++) {
            for (i = 0; i < 11; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.HOUSEFLOOR);
            }
        }
        //Tree
        for (i = 0; i < 11; i++) {
            mapArray[0][i] = new MapTile(0, i, MapSymbol.TREE);
        }
        mapArray[1][0] = new MapTile(1, 0, MapSymbol.TREE);
        mapArray[1][10] = new MapTile(1, 10, MapSymbol.TREE);
        mapArray[2][0] = new MapTile(2, 0, MapSymbol.TREE);
        mapArray[2][1] = new MapTile(2, 1, MapSymbol.TREE);
        mapArray[2][2] = new MapTile(2, 2, MapSymbol.TREE);
        mapArray[2][7] = new MapTile(2, 7, MapSymbol.TREE);
        mapArray[2][8] = new MapTile(2, 8, MapSymbol.TREE);
        mapArray[2][9] = new MapTile(2, 9, MapSymbol.TREE);
        mapArray[2][10] = new MapTile(2, 10, MapSymbol.TREE);
        mapArray[3][0] = new MapTile(3, 0, MapSymbol.TREE);
        mapArray[3][10] = new MapTile(3, 10, MapSymbol.TREE);
        mapArray[4][0] = new MapTile(4, 0, MapSymbol.TREE);
        mapArray[4][2] = new MapTile(4, 2, MapSymbol.TREE);
        mapArray[4][6] = new MapTile(4, 6, MapSymbol.TREE);
        mapArray[4][7] = new MapTile(4, 7, MapSymbol.TREE);
        mapArray[4][8] = new MapTile(4, 8, MapSymbol.TREE);
        mapArray[4][10] = new MapTile(4, 10, MapSymbol.TREE);
        mapArray[5][0] = new MapTile(5, 0, MapSymbol.TREE);
        mapArray[5][10] = new MapTile(5, 10, MapSymbol.TREE);
        mapArray[6][0] = new MapTile(6, 0, MapSymbol.TREE);
        mapArray[6][2] = new MapTile(6, 2, MapSymbol.TREE);
        mapArray[6][6] = new MapTile(6, 6, MapSymbol.TREE);
        mapArray[6][7] = new MapTile(6, 7, MapSymbol.TREE);
        mapArray[6][8] = new MapTile(6, 8, MapSymbol.TREE);
        mapArray[6][10] = new MapTile(6, 10, MapSymbol.TREE);
        mapArray[7][0] = new MapTile(7, 0, MapSymbol.TREE);
        mapArray[7][10] = new MapTile(7, 10, MapSymbol.TREE);
        mapArray[8][1] = new MapTile(8, 1, MapSymbol.TREE);
        mapArray[8][2] = new MapTile(8, 2, MapSymbol.TREE);
        mapArray[8][3] = new MapTile(8, 3, MapSymbol.TREE);
        mapArray[8][7] = new MapTile(8, 7, MapSymbol.TREE);
        mapArray[8][8] = new MapTile(8, 8, MapSymbol.TREE);
        mapArray[8][9] = new MapTile(8, 9, MapSymbol.TREE);
        mapArray[9][3] = new MapTile(9, 3, MapSymbol.TREE);
        mapArray[9][7] = new MapTile(9, 7, MapSymbol.TREE);
        //Door and TP
        mapArray[9][4] = new MapTile(9, 4, MapSymbol.BOUNDARY_A);
        mapArray[9][5] = new MapTile(6, 13, MapSymbol.DOOR, "VaridianCity", 0);
        mapArray[9][6] = new MapTile(9, 3, MapSymbol.BOUNDARY_A);

        mapArray[5][3] = new MapTile(5, 3, MapSymbol.SPACEFORNPC);
        mapArray[1][4] = new MapTile(1, 4, MapSymbol.SPACEFORNPC, null, 1);

    }

    public void fillMapWithNpc() {
        // npc Owner
        mapArray[1][4].resident = new NotPlayerC("Gym Owner", "Welcome to my gym.");
        // npc Couch
        mapArray[5][3].resident = new NotPlayerC("Couch", "Hope you can beat my student;");
    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        if (hero.progress == 5) {
            if (fightTrainer1 = true) {
                System.out.println("You are the first trainer who challenge me today, are you ready?");
                GameCharacter trainer1 = new GameCharacter("Jay");
                Gyarados gyarados = new Gyarados("Gyarados", 20);
                Charmeleon charmeleon = new Charmeleon("Charmeleon", 18);
                Weedle weedle = new Weedle("Weedle", 10);

                DragonRage dr = new DragonRage();
                Tackle tk = new Tackle();
                Bite bt = new Bite();
                gyarados.Move[0] = dr;
                gyarados.Move[1] = tk;
                gyarados.Move[2] = bt;
                trainer1.Team[0] = gyarados;

                Scratch sc = new Scratch();
                Growl gw = new Growl();
                Ember em = new Ember();
                charmeleon.Move[0] = sc;
                charmeleon.Move[1] = gw;
                charmeleon.Move[2] = em;
                trainer1.Team[1] = charmeleon;

                PoisonSting ps = new PoisonSting();
                StringShot ss = new StringShot();
                weedle.Move[0] = ps;
                weedle.Move[1] = ss;
                trainer1.Team[2] = weedle;

                Battle3 Gym1Battle = new Battle3(hero, trainer1);
                if (trainer1.checkpokemon() == false) {
                    fightTrainer1 = true;
                    System.out.println("Just like what Oak said: " + hero.getName() + " has the ability to beat you! \nNow you can be a good trainer and travel around the world to beat all the trainers like me!\nI have a boat for you. With the boat, you can gose in to water and catch water type pokemons!");
                    hero.setMoney(hero.getMoney() + 1000);
                    hero.boat.setAmount(1);
                    System.out.println("you got 1000 dolloars!\nyou got a boat\nPress any button to continue");
                    hero.progress = 2;
                    Scanner keyboard = new Scanner(System.in);
                    String button;
                    button = keyboard.nextLine();
                    hero.progress = 6;
                    System.out.println("--------------------------------------------------");
                    System.out.println("Now You finished the first part of your journey!!!"
                            + "\n-------------TO BE COUNTINUED!!!!!!!!!------------"
                            + "\n--ASSISTANT: EDDIE CHUNG--------------------------"
                            + "\nPROGRAMMERS: LIM WEI------------------------------"
                            + "\n-------------HUNTER LI----------------------------"
                            + "\n-------------SAKARI-------------------------------"
                            + "\n-------------STEVE--------------------------------"
                            + "\n-------------THANKS FOR YOU PLAYING---------------");
                    
                } else {
                    System.out.println("practice again!");
                }
                return hero;
            }
        } else {
            System.out.println("Hi how are you");
            return hero;
        }
        return hero;
    }

    @Override
    public GameCharacter communication2(GameCharacter hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameCharacter communication3(GameCharacter hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
