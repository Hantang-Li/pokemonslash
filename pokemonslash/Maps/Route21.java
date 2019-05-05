package pokemonslash.Maps;

import java.util.Random;
import pokemonslash.*;
import pokemonslash.Battle.Battle3;
import pokemonslash.Pokemons.SampleMoves.Bubble;
import pokemonslash.Pokemons.SampleMoves.Scratch;
import pokemonslash.Pokemons.SampleMoves.Tackle;
import pokemonslash.Pokemons.SampleMoves.TailWhip;
import pokemonslash.Pokemons.pokemonClass.Horsea;
import pokemonslash.Pokemons.pokemonClass.Magikarp;
import pokemonslash.Pokemons.pokemonClass.Pidgey;
import pokemonslash.Pokemons.pokemonClass.Psyduck;
import pokemonslash.Pokemons.pokemonClass.Rattata;
import pokemonslash.Pokemons.pokemonClass.Weedle;

public class Route21 extends GameMap {

    public Route21() {
        super(20, 20, "Route21"); //Create a 20 by 20 map, or however big, can change here      
        fillMap();
    }

    public void fillMap() {
        int i, j;
        //Water
        for (j = 0; j < 20; j++) {
            for (i = 0; i < 20; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.WATER, null, 1);
            }
        }
        //Tree
        for (i = 0; i < 20; i++) {
            mapArray[i][0] = new MapTile(i, 0, MapSymbol.TREE);
            mapArray[i][19] = new MapTile(i, 19, MapSymbol.TREE);
        }
        for (i = 0; i < 20; i++) {
            mapArray[0][i] = new MapTile(0, i, MapSymbol.TREE);
            mapArray[19][i] = new MapTile(19, i, MapSymbol.TREE);
        }
        mapArray[1][1] = new MapTile(1, 1, MapSymbol.TREE);
        mapArray[1][2] = new MapTile(1, 2, MapSymbol.TREE);
        mapArray[1][3] = new MapTile(1, 3, MapSymbol.TREE);
        mapArray[1][4] = new MapTile(1, 4, MapSymbol.TREE);
        mapArray[1][15] = new MapTile(1, 15, MapSymbol.TREE);
        mapArray[1][16] = new MapTile(1, 16, MapSymbol.TREE);
        mapArray[1][17] = new MapTile(1, 17, MapSymbol.TREE);
        mapArray[1][18] = new MapTile(1, 18, MapSymbol.TREE);
        mapArray[2][1] = new MapTile(2, 1, MapSymbol.TREE);
        mapArray[2][2] = new MapTile(2, 2, MapSymbol.TREE);
        mapArray[2][17] = new MapTile(2, 17, MapSymbol.TREE);
        mapArray[2][18] = new MapTile(2, 18, MapSymbol.TREE);
        //land
        for (i = 13; i < 16; i++) {
            mapArray[4][i] = new MapTile(4, i, MapSymbol.MEADOW, null, 2);
            mapArray[5][i] = new MapTile(5, i, MapSymbol.MEADOW, null, 2);
            mapArray[6][i] = new MapTile(6, i, MapSymbol.MEADOW, null, 2);
        }
        for (i = 4; i < 7; i++) {
            mapArray[8][i] = new MapTile(8, i, MapSymbol.MEADOW, null, 2);
            mapArray[9][i] = new MapTile(9, i, MapSymbol.MEADOW, null, 2);
        }
        mapArray[8][7] = new MapTile(8, 7, MapSymbol.MEADOW, null, 2);
        for (i = 9; i < 13; i++) {
            mapArray[11][i] = new MapTile(11, i, MapSymbol.MEADOW, null, 2);
            mapArray[12][i] = new MapTile(12, i, MapSymbol.MEADOW, null, 2);
            mapArray[13][i] = new MapTile(13, i, MapSymbol.MEADOW, null, 2);
        }
        mapArray[12][12] = new MapTile(12, 12, MapSymbol.WATER, null, 1);
        mapArray[16][3] = new MapTile(16, 3, MapSymbol.MEADOW, null, 2);
        mapArray[16][4] = new MapTile(16, 4, MapSymbol.MEADOW, null, 2);
        mapArray[17][3] = new MapTile(17, 3, MapSymbol.MEADOW, null, 2);
        mapArray[17][4] = new MapTile(17, 4, MapSymbol.MEADOW, null, 2);
        mapArray[17][4] = new MapTile(17, 4, MapSymbol.MEADOW, null, 2);
        mapArray[17][13] = new MapTile(17, 13, MapSymbol.MEADOW, null, 2);
        mapArray[17][12] = new MapTile(17, 12, MapSymbol.MEADOW, null, 2);
        //Tp locate in 0,10 and 19,10

        mapArray[0][10] = new MapTile(18, 10, MapSymbol.GROUND, "PalletTown", 0);

    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        Battle3 route21Battle;
        Random rnd = new Random();
        int meet;
        int chance;
        chance = rnd.nextInt(100) + 1;
        meet = rnd.nextInt(375) + 1;
        if (meet <= 30) {//30
            Magikarp magicarp = new Magikarp("Magicarp", rnd.nextInt(10) + 2);
            Horsea horsea = new Horsea("Horsea", rnd.nextInt(13) + 2);
            Psyduck psyduck = new Psyduck("Psyduck", rnd.nextInt(12) + 3);

            if (chance <= 40) {

                System.out.println("You meet a Magicarp!");
                Tackle tc = new Tackle();
                magicarp.Move[0] = tc;
                route21Battle = new Battle3(hero, magicarp);

            } else if (chance <= 85 && chance >= 40) {

                System.out.println("You meet a Horsea!");
                Bubble bub = new Bubble();
                horsea.Move[0] = bub;
                route21Battle = new Battle3(hero, horsea);
            } else {

                System.out.println("You meet a Psyduck!");
                Scratch scratch = new Scratch();
                psyduck.Move[0] = scratch;
                TailWhip tailWhuip = new TailWhip();
                psyduck.Move[1] = tailWhuip;
                route21Battle = new Battle3(hero, psyduck);

            }
            boolean ableToFight = false;
            for (int k = 0; k < 6; k++) {
                if (hero.Team[k] != null) {
                    if (hero.Team[k].HP > 0) {
                        ableToFight = true;
                    }
                }
            }
            if (ableToFight == false) {
                hero.fight = false;
            } else if (magicarp.HP == 0||horsea.HP==0||psyduck.HP==0) {
                hero.setMoney(hero.getMoney() + 15);
                System.out.println("You got 15 dollars!");
            }

            return hero;
        } else {
            return hero;
        }
    }

    @Override
    public GameCharacter communication2(GameCharacter hero) {
        Battle3 route21Battle;
        Random rnd = new Random();
        int meet;
        meet = rnd.nextInt(375) + 1;
        if (meet <= 30) {//30
            Psyduck psyduck = new Psyduck("Psyduck", rnd.nextInt(17) + 3);
            System.out.println("You meet a Psyduck!");

            Scratch scratch = new Scratch();
            psyduck.Move[0] = scratch;
            TailWhip tailWhuip = new TailWhip();
            psyduck.Move[1] = tailWhuip;
            route21Battle = new Battle3(hero, psyduck);

            boolean ableToFight = false;
            for (int k = 0; k < 6; k++) {
                if (hero.Team[k] != null) {
                    if (hero.Team[k].HP > 0) {
                        ableToFight = true;
                    }
                }
            }
            if (ableToFight == false) {
                hero.fight = false;
            } else if (psyduck.HP==0) {
                hero.setMoney(hero.getMoney() + 15);
                System.out.println("You got 15 dollars!");
            }
        }
        return hero;
    }

    @Override
    public GameCharacter communication3(GameCharacter hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
