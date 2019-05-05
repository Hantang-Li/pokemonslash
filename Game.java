package pokemonslash;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import pokemonslash.Maps.*;
import pokemonslash.Pokemons.*;
import pokemonslash.Battle.*;
import pokemonslash.Pokemons.SampleMoves.Scratch;
import pokemonslash.Pokemons.SampleMoves.Tackle;
import pokemonslash.Pokemons.SampleMoves.Ember;
import pokemonslash.Pokemons.SampleMoves.TailWhip;
import pokemonslash.Pokemons.pokemonClass.Bulbasaur;
import pokemonslash.Pokemons.pokemonClass.Charmander;
import pokemonslash.Pokemons.pokemonClass.Squirtle;

class Game implements Serializable {

    //declear variables

    public GameCharacter hero;
    static GameCharacter trainer;
    public GameMap currentMap;
    public Map<String, GameMap> listOfMap;
    public GameMap PalletTown;
    public GameMap HouseA;
    public GameMap HouseB;
    public GameMap OakHouse;
    public GameMap Route1;
    public GameMap Route21;
    public GameMap VCGym;
    public GameMap PokemonCenter;
    public GameMap VaridianCity;
    public GameMap Pokemart;
    public Pokemon pokemonHp, pokemonTp;
    public Pokemon pokemonHp1, pokemonTp1, pokemonHp2, pokemonTp2;
    public PokemonMoves moves;
    public int fightCheck = 0;
    public int trainerCheck = 0;
    public int pokemonCheck = 0;
    public boolean returnToMain;

    //Starting of game

    public Game() {
        Scanner keyboard = new Scanner(System.in);
        String name;
        System.out.println("May we know your name??");
        name = keyboard.nextLine();
        hero = new GameCharacter(name);
        createAllMap();
        hero.currentTile = currentMap.mapArray[8][10];
        mainGameLoop();

    }

    public Game(GameCharacter hero) {
        this.hero = hero;
        createAllMap();
        mainGameLoop();
    }



    //movement part of asking (output)

    void mainGameLoop() {
        String movement;
        Scanner keyboard = new Scanner(System.in);

        //1. show map  
        currentMap.showMap(hero.currentTile, this);

        //2.ask movement
        System.out.println("Which direction do u want to go?\n'w'=up 'a'=left 's'=down 'd'=right ('m'=menu) ");
        movement = keyboard.nextLine();

        //3.move
        switch (movement) {
            case "w":
                moveHero(-1, 0);
                break;
            case "a":
                moveHero(0, -1);
                break;
            case "s":
                moveHero(1, 0);
                break;
            case "d":
                moveHero(0, 1);
                break;
            case "m":
                menu();
                break;
        }

        listOfMap.replace(currentMap.name, currentMap);
        //teleportat from currentmap to another map
        if (hero.currentTile.destination != null) {
            if (listOfMap.get(hero.currentTile.destination) != null) {
                currentMap = listOfMap.get(hero.currentTile.destination);
                hero.currentTile = currentMap.mapArray[hero.currentTile.y][hero.currentTile.x];
                if (currentMap.name == "HouseA" || currentMap.name == "Pokemon Center") {
                    hero.deadmap = currentMap.name;
                }
            }
        }

        if (returnToMain == true) {
            returnToMain = false;
        } else {
            mainGameLoop();
        }
    }

    //movement part 

    private void moveHero(int yChange, int xChange) {

        int yDest = hero.currentTile.y + yChange;
        int xDest = hero.currentTile.x + xChange;

        if (currentMap.mapArray[yDest][xDest].resident != null) {
            System.out.println(currentMap.mapArray[yDest][xDest].resident.getMessage());
        }

        if (currentMap.mapArray[yDest][xDest].ms.isWalkable == false) {
            if (currentMap.mapArray[yDest][xDest].ms.message != null) {
                System.out.println(currentMap.mapArray[yDest][xDest].ms.message);
            }

        } else {
            hero.currentTile = currentMap.mapArray[yDest][xDest];
            if (currentMap.mapArray[yDest][xDest].ms.message != null) {
                System.out.println(currentMap.mapArray[yDest][xDest].ms.message);
            }
        }

        GameCharacter buffer;
        if (currentMap.mapArray[yDest][xDest].communicationMethod == 1) {
            //print communications or activities that you can do in a map
            buffer = currentMap.communication1(hero);
            hero = buffer;
        } else if (currentMap.mapArray[yDest][xDest].communicationMethod == 2) {
            buffer = currentMap.communication2(hero);
            hero = buffer;
        } else if (currentMap.mapArray[yDest][xDest].communicationMethod == 3) {
            buffer = currentMap.communication3(hero);
            hero = buffer;
        }

        if (hero.fight == false) {
            hero.fight = true;
            currentMap = listOfMap.get(hero.deadmap);
            hero.currentTile = currentMap.mapArray[8][4];
        }

    }

    //map lists

    public void createAllMap() {
        PalletTown = new PalletTown();
        HouseA = new HouseA();
        HouseB = new HouseB();
        OakHouse = new OakHouse();
        Route1 = new Route1();
        VCGym = new VCGym();
        VaridianCity = new VaridianCity();
        Pokemart = new Pokemart();
        PokemonCenter = new PokemonCenter();
        Route21 = new Route21();

        listOfMap = new HashMap();
        BuildMap(PalletTown.name, PalletTown);
        BuildMap(HouseA.name, HouseA);
        BuildMap(HouseB.name, HouseB);
        BuildMap(OakHouse.name, OakHouse);
        BuildMap(Route1.name, Route1);
        BuildMap(VCGym.name, VCGym);
        BuildMap(VaridianCity.name, VaridianCity);
        BuildMap(Pokemart.name, Pokemart);
        BuildMap(PokemonCenter.name, PokemonCenter);
        BuildMap(Route21.name, Route21);

        if (hero.currentmap != null) {
            currentMap = listOfMap.get(hero.currentmap);
        } else {
            currentMap = PalletTown;
            hero.currentmap = currentMap.name;
        }
    }

    public void BuildMap(String name, GameMap nameOfMap) {
        listOfMap.put(name, nameOfMap);
    }

    //out put menu

    public void menu() {
        String choice;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. backpack\n2. Pokémon\n3. current map"
                + "\n4. back to main menu(you can save there)\n5. exit menu");
        choice = keyboard.nextLine();
        switch (choice) {
            case "1":
                viewBackpack();
                break;
            case "2":
                viewPokémon();
                break;
            case "3":
                System.out.println("You are now in " + currentMap.getClass().getSimpleName());
                break;
            case "4":
                backToMain();
                break;
            case "5":
                break;
        }

    }

    //backpack lol

    private void viewBackpack() {
        System.out.println("               ____");
        System.out.println("              /    \\");
        System.out.println("     _________|____|_________");
        System.out.println("   /          |    |          \\ ");
        System.out.println("  /                            \\");
        System.out.println("   You have " + hero.ppm.amount + " Ether");
        System.out.println("   You have " + hero.hpm.amount + " Hpup ");
        System.out.println("   You have " + hero.pokeball.amount + " Pokeball ");
        System.out.println("   You have " + hero.boat.amount + " boat ");
        System.out.println("   You have $" + hero.getMoney());
        System.out.println("___________________________________");
    }

    private void viewPokémon() {
        hero.viewPokémon();
        System.out.println("Do you want to switch your pokemon?(Y/N)");
        String choice;
        Scanner keyboard = new Scanner(System.in);
        //heal or not
        do {
            choice = keyboard.nextLine();
            if (choice.compareToIgnoreCase("Y") == 0) {
                hero.switchPokemon();
            } else if (choice.compareToIgnoreCase("N") == 0) {
            }

        } while (choice.compareToIgnoreCase("Y") != 0 && choice.compareToIgnoreCase("N") != 0);

    }

    private void backToMain() {
        returnToMain = true;
    }
}
