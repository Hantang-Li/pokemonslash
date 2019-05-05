package pokemonslash.Maps;

import pokemonslash.*;
import pokemonslash.Battle.Battle3;
import pokemonslash.Pokemons.SampleMoves.Bite;
import pokemonslash.Pokemons.SampleMoves.Gust;
import pokemonslash.Pokemons.SampleMoves.QuickAttack;
import pokemonslash.Pokemons.SampleMoves.SandAttack;
import pokemonslash.Pokemons.SampleMoves.Tackle;
import pokemonslash.Pokemons.SampleMoves.TailWhip;
import pokemonslash.Pokemons.pokemonClass.Pidgey;
import pokemonslash.Pokemons.pokemonClass.Squirtle;

public class VaridianCity extends GameMap {

    public VaridianCity() {

        super(20, 20, "VaridianCity"); //Create a 20 by 20 map, or however big, can change here   
        fillMap();
        fillMapWithNpc();

    }

    public void fillMap() {
        int i, j;

        //Create Tree
        for (i = 0; i < 20; i++) {
            mapArray[0][i] = new MapTile(0, i, MapSymbol.TREE);
            mapArray[i][18] = new MapTile(i, 18, MapSymbol.TREE);
            mapArray[i][19] = new MapTile(i, 19, MapSymbol.TREE);
        }
        mapArray[1][0] = new MapTile(1, 0, MapSymbol.TREE);
        mapArray[1][7] = new MapTile(1, 7, MapSymbol.TREE);
        mapArray[1][8] = new MapTile(1, 8, MapSymbol.TREE);
        mapArray[1][9] = new MapTile(1, 9, MapSymbol.TREE);
        mapArray[1][10] = new MapTile(1, 10, MapSymbol.TREE);
        mapArray[2][0] = new MapTile(2, 0, MapSymbol.TREE);
        mapArray[3][0] = new MapTile(3, 0, MapSymbol.TREE);
        mapArray[3][1] = new MapTile(3, 1, MapSymbol.TREE);
        mapArray[3][2] = new MapTile(3, 2, MapSymbol.TREE);
        mapArray[3][3] = new MapTile(3, 3, MapSymbol.TREE);
        mapArray[4][1] = new MapTile(4, 1, MapSymbol.TREE);
        mapArray[4][2] = new MapTile(4, 2, MapSymbol.TREE);
        mapArray[4][3] = new MapTile(4, 3, MapSymbol.TREE);
        mapArray[15][5] = new MapTile(15, 5, MapSymbol.TREE);
        mapArray[15][6] = new MapTile(15, 6, MapSymbol.TREE);

        //Create border and barrier
        for (i = 4; i < 19; i++) {
            mapArray[i][0] = new MapTile(i, 0, MapSymbol.BOUNDARY_A);
        }
        for (i = 0; i < 20; i++) {
            mapArray[19][i] = new MapTile(19, i, MapSymbol.BOUNDARY_B);
        }
        for (i = 8; i < 19; i++) {
            mapArray[7][i] = new MapTile(7, i, MapSymbol.BOUNDARY_B);
        }

        mapArray[2][1] = new MapTile(2, 1, MapSymbol.BOUNDARY_B);
        mapArray[2][2] = new MapTile(2, 2, MapSymbol.BOUNDARY_B);
        mapArray[2][3] = new MapTile(2, 3, MapSymbol.BOUNDARY_B);
        mapArray[15][1] = new MapTile(15, 1, MapSymbol.BOUNDARY_B);
        mapArray[15][2] = new MapTile(15, 2, MapSymbol.BOUNDARY_B);
        mapArray[15][3] = new MapTile(15, 3, MapSymbol.BOUNDARY_B);
        mapArray[15][4] = new MapTile(15, 4, MapSymbol.BOUNDARY_B);

        //Create gym
        mapArray[2][9] = new MapTile(2, 9, MapSymbol.ROOF_B);
        mapArray[2][10] = new MapTile(2, 10, MapSymbol.BOUNDARY_B);
        mapArray[2][11] = new MapTile(2, 11, MapSymbol.BOUNDARY_B);
        mapArray[2][12] = new MapTile(2, 12, MapSymbol.BOUNDARY_B);
        mapArray[2][13] = new MapTile(2, 13, MapSymbol.BOUNDARY_B);
        mapArray[2][14] = new MapTile(2, 14, MapSymbol.BOUNDARY_B);
        mapArray[2][15] = new MapTile(2, 15, MapSymbol.ROOF_A);
        mapArray[3][9] = new MapTile(3, 9, MapSymbol.BOUNDARY_A);
        mapArray[4][9] = new MapTile(4, 9, MapSymbol.BOUNDARY_A);
        mapArray[3][11] = new MapTile(3, 11, MapSymbol.BOUNDARY_A);
        mapArray[4][11] = new MapTile(4, 11, MapSymbol.BOUNDARY_A);
        mapArray[3][13] = new MapTile(3, 13, MapSymbol.BOUNDARY_A);
        mapArray[4][13] = new MapTile(4, 13, MapSymbol.BOUNDARY_A);
        mapArray[3][15] = new MapTile(3, 15, MapSymbol.BOUNDARY_A);
        mapArray[4][15] = new MapTile(4, 15, MapSymbol.BOUNDARY_A);
        mapArray[3][10] = new MapTile(3, 10, MapSymbol.BOUNDARY_B);
        mapArray[4][10] = new MapTile(4, 10, MapSymbol.BOUNDARY_B);
        mapArray[3][14] = new MapTile(3, 14, MapSymbol.BOUNDARY_B);
        mapArray[4][14] = new MapTile(4, 14, MapSymbol.BOUNDARY_B);
        mapArray[5][9] = new MapTile(5, 9, MapSymbol.ROOF_C);
        mapArray[5][10] = new MapTile(5, 10, MapSymbol.ROOF_C);
        mapArray[5][11] = new MapTile(5, 11, MapSymbol.ROOF_C);
        mapArray[5][13] = new MapTile(5, 13, MapSymbol.ROOF_C);
        mapArray[5][14] = new MapTile(5, 14, MapSymbol.ROOF_C);
        mapArray[5][15] = new MapTile(5, 15, MapSymbol.ROOF_C);
        mapArray[5][8] = new MapTile(5, 8, MapSymbol.GYMTAG);
        //Create house
        for (i = 7; i < 14; i++) {
            mapArray[9][i] = new MapTile(9, i, MapSymbol.ROOF_D);
        }
        mapArray[10][7] = new MapTile(10, 7, MapSymbol.BOUNDARY_A);
        mapArray[11][7] = new MapTile(11, 7, MapSymbol.BOUNDARY_A);
        mapArray[10][9] = new MapTile(10, 9, MapSymbol.BOUNDARY_A);
        mapArray[11][9] = new MapTile(11, 9, MapSymbol.BOUNDARY_A);
        mapArray[10][11] = new MapTile(10, 11, MapSymbol.BOUNDARY_A);
        mapArray[11][11] = new MapTile(11, 11, MapSymbol.BOUNDARY_A);
        mapArray[10][13] = new MapTile(10, 13, MapSymbol.BOUNDARY_A);
        mapArray[11][13] = new MapTile(11, 13, MapSymbol.BOUNDARY_A);
        mapArray[10][8] = new MapTile(10, 8, MapSymbol.BOUNDARY_B);
        mapArray[11][8] = new MapTile(11, 8, MapSymbol.BOUNDARY_B);
        mapArray[10][12] = new MapTile(10, 12, MapSymbol.BOUNDARY_B);
        mapArray[11][12] = new MapTile(11, 12, MapSymbol.BOUNDARY_B);

        mapArray[13][12] = new MapTile(13, 12, MapSymbol.ROOF_D);
        mapArray[13][13] = new MapTile(13, 13, MapSymbol.ROOF_D);
        mapArray[13][14] = new MapTile(13, 14, MapSymbol.ROOF_D);
        mapArray[13][15] = new MapTile(13, 15, MapSymbol.ROOF_D);
        mapArray[13][16] = new MapTile(13, 16, MapSymbol.ROOF_D);
        mapArray[14][12] = new MapTile(14, 12, MapSymbol.BOUNDARY_A);
        mapArray[14][13] = new MapTile(14, 13, MapSymbol.BOUNDARY_B);
        mapArray[14][14] = new MapTile(14, 14, MapSymbol.BOUNDARY_B);
        mapArray[14][15] = new MapTile(14, 15, MapSymbol.BOUNDARY_B);
        mapArray[14][16] = new MapTile(14, 16, MapSymbol.BOUNDARY_A);
        mapArray[15][12] = new MapTile(15, 12, MapSymbol.BOUNDARY_A);
        mapArray[15][13] = new MapTile(15, 13, MapSymbol.BOUNDARY_B);
        mapArray[15][15] = new MapTile(15, 15, MapSymbol.BOUNDARY_B);
        mapArray[15][16] = new MapTile(15, 16, MapSymbol.BOUNDARY_A);
        //Create pool
        for (i = 5; i < 10; i++) {
            mapArray[16][i] = new MapTile(16, i, MapSymbol.POOL);
            mapArray[17][i] = new MapTile(16, i, MapSymbol.POOL);
        }
        //Create tp
        mapArray[5][13] = new MapTile(8, 5, MapSymbol.DOOR, "VCGym", 0);
        mapArray[5][12] = new MapTile(8, 5, MapSymbol.DOOR, "VCGym", 0);
        mapArray[11][10] = new MapTile(6, 4, MapSymbol.DOOR, "Store", 0);
        mapArray[19][9] = new MapTile(19, 10, MapSymbol.BOUNDARY_A);
        mapArray[19][10] = new MapTile(1, 9, MapSymbol.GROUND, "Route1", 0);
        mapArray[19][11] = new MapTile(19, 10, MapSymbol.BOUNDARY_A);

        mapArray[15][14] = new MapTile(8, 5, MapSymbol.DOOR, "Pokemon Center", 0);

        mapArray[18][13] = new MapTile(18, 13, MapSymbol.SPACEFORNPC);

        mapArray[17][3] = new MapTile(17, 3, MapSymbol.SPACEFORNPC, null, 1);
        mapArray[8][3] = new MapTile(8, 3, MapSymbol.SPACEFORNPC);
        mapArray[12][5] = new MapTile(12, 5, MapSymbol.SPACEFORNPC);
    }

    public void fillMapWithNpc() {
        // npc 
        mapArray[18][13].resident = new NotPlayerC("Man", "Welcom to Varidian City, you can cure your pokemon in the house behind me\nIn the house that at the middle of the city, you can buy all the things you need\nalso, you can challenge our best trainer at the north of the city!");
        //chat
        mapArray[17][3].resident = new NotPlayerC("Jay", "Hi");
        //chat
        mapArray[8][3].resident = new NotPlayerC("Cityzen", "Are you going to the Gym?\nYou can get some money if you beat him?");
        mapArray[12][5].resident = new NotPlayerC("Cityzen", "You can buy portion, pokeball in the Store.");

    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        System.out.println("I want to challenge you!");
        GameCharacter trainer1 = new GameCharacter("Jay");
        Pidgey pidgey = new Pidgey("Pidgey", 5);
        Squirtle squirtle = new Squirtle("Squirtle", 5);
        Gust gust = new Gust();
        SandAttack sa = new SandAttack();
        QuickAttack qa = new QuickAttack();
        Tackle tc = new Tackle();
        TailWhip tw = new TailWhip();
        squirtle.Move[0] = tc;
        squirtle.Move[1] = tw;
        pidgey.Move[0] = gust;
        pidgey.Move[1] = sa;
        pidgey.Move[2] = qa;
        trainer1.Team[0] = pidgey;
        trainer1.Team[1] = squirtle;
        Battle3 city1Battle = new Battle3(hero, trainer1);
        if (trainer1.checkpokemon() == false) {
            System.out.println("wow, you're good, hope one day you can beat the tainer in the gym");
            hero.setMoney(hero.getMoney() + 300);
        } else {
            System.out.println("---------------");
            System.out.println("practice again!");
            System.out.println("---------------");
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
