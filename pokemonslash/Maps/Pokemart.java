package pokemonslash.Maps;

import java.util.Scanner;
import pokemonslash.*;
import pokemonslash.Pokemons.*;

public class Pokemart extends GameMap {

    public Pokemart() {
        super(8, 10, "Store");
        fillMap();
        fillMapWithNpc();
    }

    public void fillMap() {
        int i, j;
        //Floor
        for (j = 0; j < 8; j++) {
            for (i = 0; i < 10; i++) {
                mapArray[j][i] = new MapTile(j, i, MapSymbol.HOUSEFLOOR);
            }
        }
        //Space Boundary
        for (i = 0; i < 10; i++) {
            mapArray[0][i] = new MapTile(0, i, MapSymbol.SPACEFORNPC);
        }
        for (i = 0; i < 8; i++) {
            mapArray[i][0] = new MapTile(i, 0, MapSymbol.SPACEFORNPC);
            mapArray[i][9] = new MapTile(i, 9, MapSymbol.SPACEFORNPC);
        }
        //Bottom Boundary
        for (i = 1; i < 9; i++) {
            mapArray[7][i] = new MapTile(7, i, MapSymbol.BOUNDARY_B);
        }
        //Tp

        //counter
        mapArray[3][1] = new MapTile(3, 1, MapSymbol.BOUNDARY_B);
        mapArray[3][2] = new MapTile(3, 2, MapSymbol.BOUNDARY_B);
        mapArray[5][1] = new MapTile(5, 1, MapSymbol.BOUNDARY_B);
        mapArray[5][2] = new MapTile(5, 2, MapSymbol.BOUNDARY_B);
        mapArray[4][2] = new MapTile(4, 2, MapSymbol.COUNTER, null, 1);
        //bookshelf & tv
        mapArray[1][3] = new MapTile(1,3,MapSymbol.TV);
        mapArray[1][4] = new MapTile(1,4,MapSymbol.TV);
        mapArray[1][5] = new MapTile(1,5,MapSymbol.TV);
        mapArray[1][6] = new MapTile(1,6,MapSymbol.TV);
        
        mapArray[3][6] = new MapTile(3,6,MapSymbol.BOOKSHELF);
        mapArray[3][7] = new MapTile(3,7,MapSymbol.BOOKSHELF);
        mapArray[4][6] = new MapTile(3,6,MapSymbol.BOOKSHELF);
        mapArray[4][7] = new MapTile(4,7,MapSymbol.BOOKSHELF);
        
        mapArray[7][3] = new MapTile(8,3,MapSymbol.BOUNDARY_A);
        mapArray[7][4] = new MapTile(12,10,MapSymbol.DOOR,"VaridianCity",0);
        mapArray[7][5] = new MapTile(8,5,MapSymbol.BOUNDARY_A);
    }  
    public void fillMapWithNpc() {
        // npc SaleMan
        mapArray[4][1].resident = new NotPlayerC("SaleMan", "Hi! My name is SaleMan");
        //chat
    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        Scanner keyboard = new Scanner(System.in);
        String choice;
        do {
            int quantity = 0;

            System.out.println("Welcome to pokemart! \nYou have $" + hero.getMoney() + "\nWhat you want to buy?\n1.Potion        $10\n2.Ether        $10\n3.Ball        $10\n4.         Exit");
            choice = keyboard.nextLine();
            switch (choice) {
                case "1":
                    while (quantity <= 0) {
                        System.out.println("How many you want to buy?");
                        quantity = keyboard.nextInt();
                        if (quantity > 0) {
                            if (quantity * 10 > hero.getMoney()) {
                                System.out.println("You do not have enough money!");
                            } else {
                                System.out.println("You get " + quantity + " potion");
                                //hero.setPotion(+quantity); 
                                hero.setMoney(hero.getMoney()-quantity * 10);
                                hero.hpm.setAmount(hero.hpm.getAmount()+quantity);
                            }
                        } else {
                            System.out.println("You enter wrong number, please try again");
                        }
                    }
                case "2":
                    while (quantity <= 0) {
                        System.out.println("How many you want to buy?");
                        quantity = keyboard.nextInt();
                        if (quantity > 0) {
                            if (quantity * 10 > hero.getMoney()) {
                                System.out.println("You do not have enough money!");
                            } else {
                                System.out.println("You get " + quantity + " potion");
                                //hero.setPotion(+quantity); 
                                hero.setMoney(hero.getMoney()-quantity * 10);
                                hero.ppm.setAmount(hero.hpm.getAmount()+quantity);
                            }
                        } else {
                            System.out.println("You enter wrong number, please try again");
                        }
                    }
                case "3":
                    while (quantity <= 0) {
                        System.out.println("How many you want to buy?");
                        quantity = keyboard.nextInt();
                        if (quantity > 0) {
                            if (quantity * 10 > hero.getMoney()) {
                                System.out.println("You do not have enough money!");
                            } else {
                                System.out.println("You get " + quantity + " ball");
                                //hero.setBall(+quantity);
                                hero.setMoney(hero.getMoney()-quantity * 10);
                                hero.pokeball.setAmount(hero.hpm.getAmount()+quantity);
                            }
                        } else {
                            System.out.println("You enter wrong number, please try again");
                        }
                    }
            }
        } while (choice.compareTo("4") != 0);
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
