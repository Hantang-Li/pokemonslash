package pokemonslash.Maps;

import java.util.Random;
import java.util.Scanner;
import pokemonslash.*;
import pokemonslash.Pokemons.pokemonClass.Pidgey;
import pokemonslash.Pokemons.pokemonClass.Rattata;
import pokemonslash.Battle.*;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.SampleMoves.Gust;
import pokemonslash.Pokemons.SampleMoves.SandAttack;
import pokemonslash.Pokemons.SampleMoves.Tackle;
import pokemonslash.Pokemons.SampleMoves.TailWhip;

public class Route1 extends GameMap {

    public Route1() {
        super(20, 20, "Route1"); //Create a 20 by 20 map, or however big, can change here      
        fillMap();
        fillMapWithNpc();
    }

    public void fillMap() {
        int i, j;

        // Create the bottom and top with tp and boundary
        for (i = 0; i < 20; i++) {
            mapArray[19][i] = new MapTile(19, i, MapSymbol.BOUNDARY_B);
            mapArray[0][i] = new MapTile(0, i, MapSymbol.BOUNDARY_B);
        }
        mapArray[19][8] = new MapTile(19, 8, MapSymbol.BOUNDARY_A);
        mapArray[19][10] = new MapTile(19, 10, MapSymbol.BOUNDARY_A);
        mapArray[19][9] = new MapTile(1, 10, MapSymbol.GROUND, "PalletTown", 0);
        mapArray[0][8] = new MapTile(19, 8, MapSymbol.BOUNDARY_A);
        mapArray[0][10] = new MapTile(19, 10, MapSymbol.BOUNDARY_A);
        mapArray[0][9] = new MapTile(18, 10, MapSymbol.GROUND, "VaridianCity", 0);

        // Create MEADOW
        for (j = 12; j < 18; j++) {
            for (i = 0; i < 6; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.MEADOW, null, 1);
            }
        }
        for (i = 9; i < 16; i++) {
            mapArray[17][i] = new MapTile(17, i, MapSymbol.MEADOW, null, 1);
            mapArray[16][i] = new MapTile(16, i, MapSymbol.MEADOW, null, 1);
            mapArray[5][i] = new MapTile(5, i, MapSymbol.MEADOW, null, 1);
        }
        for (j = 14; j < 17; j++) {
            for (i = 12; i < 20; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.MEADOW, null, 1);
            }
        }
        for (j = 9; j < 13; j++) {
            for (i = 11; i < 20; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.MEADOW, null, 1);
            }
        }
        for (j = 6; j < 9; j++) {
            for (i = 12; i < 20; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.MEADOW, null, 1);
            }
        }
        for (j = 2; j < 5; j++) {
            for (i = 6; i < 20; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.MEADOW, null, 1);
            }
        }

        // Create TREE
        mapArray[12][6] = new MapTile(12, 6, MapSymbol.TREE);
        for (i = 0; i < 7; i++) {
            mapArray[11][i] = new MapTile(11, i, MapSymbol.TREE);
        }
        for (i = 0; i < 6; i++) {
            mapArray[10][i] = new MapTile(10, i, MapSymbol.TREE);
            mapArray[10][i + 13] = new MapTile(10, i + 13, MapSymbol.TREE);
        }
        for (i = 0; i < 2; i++) {
            mapArray[9][i] = new MapTile(9, i, MapSymbol.TREE);
        }
        for (i = 0; i < 4; i++) {
            mapArray[8][i] = new MapTile(8, i, MapSymbol.TREE);
        }
        for (i = 16; i < 20; i++) {
            mapArray[9][i] = new MapTile(9, i, MapSymbol.TREE);
        }
        for (i = 16; i < 20; i++) {
            mapArray[5][i] = new MapTile(5, i, MapSymbol.TREE);
        }
        for (i = 13; i < 20; i++) {
            mapArray[1][i] = new MapTile(1, i, MapSymbol.TREE);
        }

        //Create left side and right side with Boundary
        for (i = 1; i < 19; i++) {
            mapArray[i][0] = new MapTile(i, 0, MapSymbol.BOUNDARY_A);
            mapArray[i][19] = new MapTile(i, 19, MapSymbol.BOUNDARY_A);
        }

        mapArray[5][6] = new MapTile(5, 6, MapSymbol.SPACEFORNPC, null, 2);
    }

    public void fillMapWithNpc() {
        // npc littelbob
        mapArray[5][6].resident = new NotPlayerC("Junior bob", "hi i am little bob");
        //chat
    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        Battle3 route1Battle;
        Random rnd = new Random();
        int meet;
        int chance;
        chance = rnd.nextInt(100) + 1;
        meet = rnd.nextInt(375) + 1;
        if (meet <= 30) {

            Rattata rattata = new Rattata("Rattata", rnd.nextInt(3) + 2);
            Pidgey pidgey = new Pidgey("Pidgey", rnd.nextInt(4)+2);
            //hero.deadmap = "HouseA"
            if (chance <= 55) {
                
                Gust gust = new Gust();
                
                pidgey.Move[0] = gust;
                if(pidgey.level >4){
                    SandAttack sa = new SandAttack();
                    pidgey.Move[1] = sa;
                }
                
                System.out.println("You meet a Pidgey!");
                route1Battle = new Battle3(hero, pidgey);

                
            } else {
                
                System.out.println("You meet a Rattata!");
                Tackle ta = new Tackle();
                TailWhip tw = new TailWhip();
                rattata.Move[1] = tw;
                rattata.Move[0] = ta;
                route1Battle = new Battle3(hero, rattata);

            }

            if (hero.checkpokemon() == false) {
                hero.fight = false;
            }else if(pidgey.HP == 0||rattata.HP == 0){
                hero.setMoney(hero.getMoney()+10);
                System.out.println("You got 10 dollars!");
            }

            return hero;
        } else {
            return hero;
        }

    }

    @Override
    public GameCharacter communication2(GameCharacter hero) {
        if (hero.progress == 4) {
            Scanner keyboard = new Scanner(System.in);
            if (hero.Team[1] == null && hero.pokeball.getAmount() == 0) {
                System.out.println("No pokeball? I 'll give you some!");
                hero.pokeball.setAmount(3);
                System.out.println("\nyou got 3 pokeballs! Press any button to continue");
                String button;
                button = keyboard.nextLine();
                return hero;
            }

            if (hero.Team[1] != null) {
                System.out.println("Wow you catched a pokemon by your self, now you can head to the city"
                        + "\njust go straight to north\nin the Varidian City, there will be a trainer\nYou need to fefeat him in order to become the best trianer\ngood luck on your journey!");
                hero.progress = 5;
            } else {
                System.out.println("Hi, nice to meet you. you can walk in to the tall grass beside me\nsome pokemons are hiding there\nyou can use pokeball that in your backpag to catch it!");//not finished yet
            }
            return hero;
        } else {
            System.out.println("Hi! " + hero.getName() + " how are you!");
            return hero;
        }
    }

    @Override
    public GameCharacter communication3(GameCharacter hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
