package pokemonslash.Maps;

import java.util.Scanner;
import pokemonslash.*;
import pokemonslash.Pokemons.*;
import pokemonslash.Pokemons.PokemonBaseStats;

public class PokemonCenter extends GameMap {

    public PokemonCenter() {
        super(11, 11, "Pokemon Center");
        fillMap();
        fillMapWithNpc();
    }

    public void fillMap() {
        int i, j;
        //Floor
        for (j = 1; j < 10; j++) {
            for (i = 1; i < 10; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.HOUSEFLOOR);
            }
        }
        //Space Boundary
        for (i = 0; i < 11; i++) {
            mapArray[0][i] = new MapTile(j, i, MapSymbol.BOUNDARY_INHOUSE);
            mapArray[i][0] = new MapTile(j, i, MapSymbol.BOUNDARY_INHOUSE);
            mapArray[10][i] = new MapTile(j, i, MapSymbol.BOUNDARY_INHOUSE);
            mapArray[i][10] = new MapTile(j, i, MapSymbol.BOUNDARY_INHOUSE);
        }
        //1 TV
        mapArray[4][1] = new MapTile(4, 1, MapSymbol.TV);
        mapArray[5][1] = new MapTile(5, 1, MapSymbol.TV);
        //SHELF
        mapArray[8][1] = new MapTile(8, 1, MapSymbol.BOOKSHELF);
        mapArray[8][2] = new MapTile(8, 2, MapSymbol.BOOKSHELF);
        mapArray[8][3] = new MapTile(8, 3, MapSymbol.BOOKSHELF);
        mapArray[9][1] = new MapTile(9, 1, MapSymbol.BOOKSHELF);
        mapArray[9][2] = new MapTile(9, 2, MapSymbol.BOOKSHELF);
        mapArray[9][3] = new MapTile(9, 3, MapSymbol.BOOKSHELF);
        mapArray[8][7] = new MapTile(8, 7, MapSymbol.BOOKSHELF);
        mapArray[8][9] = new MapTile(8, 9, MapSymbol.BOOKSHELF);
        mapArray[8][10] = new MapTile(8, 10, MapSymbol.BOOKSHELF);
        mapArray[9][7] = new MapTile(9, 7, MapSymbol.BOOKSHELF);
        mapArray[9][9] = new MapTile(9, 9, MapSymbol.BOOKSHELF);
        mapArray[9][10] = new MapTile(9, 10, MapSymbol.BOOKSHELF);
        mapArray[8][8] = new MapTile(8, 8, MapSymbol.BOOKSHELF);
        mapArray[9][8] = new MapTile(9, 8, MapSymbol.BOOKSHELF);

        //DOOR   
        mapArray[9][5] = new MapTile(16, 14, MapSymbol.DOOR, "VaridianCity", 0);//*cuan song chuan song !!!!!!!
        //wall
        mapArray[9][4] = new MapTile(9, 4, MapSymbol.BOUNDARY_A);
        mapArray[9][6] = new MapTile(9, 6, MapSymbol.BOUNDARY_A);
        //barrier
        mapArray[1][3] = new MapTile(1, 3, MapSymbol.BOUNDARY_A);
        mapArray[1][6] = new MapTile(1, 6, MapSymbol.BOUNDARY_A);
        mapArray[2][3] = new MapTile(2, 3, MapSymbol.BOUNDARY_A);
        mapArray[3][3] = new MapTile(3, 3, MapSymbol.BOUNDARY_A);
        mapArray[2][6] = new MapTile(2, 6, MapSymbol.BOUNDARY_A);
        mapArray[3][6] = new MapTile(3, 6, MapSymbol.BOUNDARY_A);

        mapArray[3][4] = new MapTile(3, 4, MapSymbol.ROOF_D);
        mapArray[3][5] = new MapTile(3, 5, MapSymbol.ROOF_D);
        mapArray[4][3] = new MapTile(4, 3, MapSymbol.TABLE);
        mapArray[4][4] = new MapTile(4, 4, MapSymbol.TABLE);
        mapArray[4][5] = new MapTile(4, 5, MapSymbol.TABLE);
        mapArray[4][6] = new MapTile(4, 6, MapSymbol.TABLE);
        mapArray[4][8] = new MapTile(4, 8, MapSymbol.TABLE);
        mapArray[3][1] = new MapTile(3, 1, MapSymbol.ROOF_E);
        mapArray[3][10] = new MapTile(3, 10, MapSymbol.ROOF_B);
        mapArray[4][2] = new MapTile(4, 2, MapSymbol.ROOF_E);
        mapArray[4][9] = new MapTile(4, 9, MapSymbol.ROOF_B);
        //blank space 
        mapArray[1][4] = new MapTile(1, 4, MapSymbol.BOUNDARY_INHOUSE);
        mapArray[1][5] = new MapTile(1, 5, MapSymbol.BOUNDARY_INHOUSE);
        mapArray[2][4] = new MapTile(2, 4, MapSymbol.BOUNDARY_INHOUSE);
        mapArray[2][5] = new MapTile(2, 5, MapSymbol.BOUNDARY_INHOUSE);

        //npc
        mapArray[3][7] = new MapTile(3, 7, MapSymbol.SPACEFORNPC, null, 1);

    }

    public void fillMapWithNpc() {
        //npc joy
        mapArray[3][7].resident = new NotPlayerC("Joy", "Hi,welcom to Pokemon Center!");
    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        String choice;
        Scanner keyboard = new Scanner(System.in);
        //heal or not
        do {
            System.out.println("Do you want to heal all of your Pokemons freely? (Y/N)\nor...do you want to save your pokemon in the pc?(S)\nor...do you want to get your pokemon from your pc?(G)");
            choice = keyboard.nextLine();
            if (choice.compareToIgnoreCase("Y") == 0) {
                for (int i = 0; i < 6; i++) {
                    if (hero.Team[i] != null) {
                        healPokemon(hero.Team[i]);
                    }

                }
            } else if (choice.compareToIgnoreCase("N") == 0) {

            } else if (choice.compareToIgnoreCase("S") == 0) {
                int n = 0;
                do {

                    System.out.println("Which Pokémon do you want to save?");
                    hero.viewPokémon();
                    choice = keyboard.nextLine();

                    int num = 0;
                    for (int k = 0; k < 6; k++) {
                        if (hero.Team[k] != null) {
                            num++;
                        }
                    }
                    if (num < 2) {
                        System.out.println("You must have one pokemon with you!");
                        return hero;
                    }

                    try {
                        int i;
                        n = Integer.parseInt(choice) - 1;
                        if (n == 0) {
                            System.out.println("You cannot choose your first pokemon!");
                            break;
                        }
                        for (i = 0; i < 31; i++) {
                            if (i == 30) {
                                System.out.println("your pc is full!");
                                return hero;
                            } else if (hero.pc[i] == null) {
                                hero.pc[i] = hero.Team[n];
                                hero.Team[n] = null;
                                System.out.println("successfully saved!");
                                hero.viewPc();
                                return hero;
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("you must enter a number!");
                    }
                } while (n > 30 || n < 0);
            } else if (choice.compareToIgnoreCase("G") == 0) {
                int n = 0;
                do {

                    System.out.println("Which Pokémon do you want to get from pc?('E'for exit)");
                    hero.viewPc();
                    choice = keyboard.nextLine();
                    if (choice.compareToIgnoreCase("E") == 0) {
                        System.out.println("you shutted off your computer");
                        break;
                    }
                    try {
                        int i;
                        n = Integer.parseInt(choice) - 1;
                        for (i = 0; i < 7; i++) {
                            if (i == 7) {
                                System.out.println("your backpag is full!");
                                break;
                            } else if (hero.Team[i] == null) {
                                hero.Team[i] = hero.pc[n];
                                hero.pc[n] = null;
                                System.out.println("successfully saved!");
                                hero.viewPokémon();
                                return hero;
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("you must enter a number!");
                    }
                } while (n > 30 || n < 0);

            } else {
                System.out.println("Sorry please input right answer");
            }
        } while (choice.compareToIgnoreCase("Y") != 0 && choice.compareToIgnoreCase("N") != 0 && choice.compareToIgnoreCase("S") != 0 && choice.compareToIgnoreCase("G") != 0);
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

    private void healPokemon(Pokemon oldPokemon) {
        oldPokemon.HP = oldPokemon.stats.HP;
        for(int i = 0; i<4; i++){
            oldPokemon.Move[i].pp = oldPokemon.Move[i].maxpp;
        }
    }
}
