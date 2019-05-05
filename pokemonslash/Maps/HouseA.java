package pokemonslash.Maps;

import java.util.Scanner;
import pokemonslash.*;

public class HouseA extends GameMap{
    
    public HouseA(){
        super(11,11,"HouseA");
        fillMap();
        fillMapWithNpc();
    }
    
    public void fillMap(){
        int i, j;
        
        //HOUSEFLOOR
        for(j=0;j<10;j++){
            for(i=0;i<10;i++){
                mapArray[j][i] = new MapTile(j,i,MapSymbol.HOUSEFLOOR);
            }
        }
        
        //BOOKSHELF
        mapArray[1][0] = new MapTile(1,0,MapSymbol.BOOKSHELF);
        mapArray[1][1] = new MapTile(1,1,MapSymbol.BOOKSHELF);
        mapArray[1][2] = new MapTile(1,2,MapSymbol.BOOKSHELF);
        mapArray[1][3] = new MapTile(1,3,MapSymbol.BOOKSHELF);

        //TV
        mapArray[1][6] = new MapTile(1,6,MapSymbol.TV);
        mapArray[1][7] = new MapTile(1,7,MapSymbol.TV);
        
        //TABLE
        for(i=3;i<7;i++){
            mapArray[4][i] = new MapTile(4,i,MapSymbol.TABLE);
            mapArray[5][i] = new MapTile(5,i,MapSymbol.TABLE);
            mapArray[6][i] = new MapTile(6,i,MapSymbol.TABLE);
        }
        
        //BOUNDARY_INHOUSE
        for(i = 0; i < 11; i++){
            for(j = 0; j < 11; j++){
                mapArray[0][j] = new MapTile(0,j,MapSymbol.BOUNDARY_INHOUSE); 
                mapArray[10][j] = new MapTile(10,j,MapSymbol.BOUNDARY_INHOUSE); 
                mapArray[i][0] = new MapTile(i,0,MapSymbol.BOUNDARY_INHOUSE); 
                mapArray[i][10] = new MapTile(i,10,MapSymbol.BOUNDARY_INHOUSE); 
                
            } 
        }
        
        
        //DOOR
        mapArray[9][3] = new MapTile(9,3,MapSymbol.BOUNDARY_A);
        mapArray[9][4] = new MapTile(8,5,MapSymbol.DOOR,"PalletTown",0);
        mapArray[9][5] = new MapTile(9,5,MapSymbol.BOUNDARY_A);
        
        //space for npc
        mapArray[5][7] = new MapTile(5,7,MapSymbol.SPACEFORNPC,null,1);

    }
    public void fillMapWithNpc() {
        // npc Mom and chat
        mapArray[5][7].resident = new NotPlayerC("MOM", "Hi! hows going?");
        
        
    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        if(hero.progress == 0){
            System.out.println("Hi my dear " + hero.getName() + "\nI heard Oak Doctor is finding you now,\ngo to the Oak house which located in right downer corner and see him!");
            return hero;
        }else if(hero.progress == 2){
            System.out.println("Hi my dear " + hero.getName() + "\nGo to bob's room and he is waiting for you");
            return hero;
        }else if(hero.progress == 4){
            System.out.println("Hi my dear " + hero.getName() + "\ngood luck on your journey\nyou will be a good pokemon trainer as me!\nIf you need help, just find me and I will heal your pokemon!");
            heal(hero);
            return hero;
        }else{
            System.out.println("Hi! my dear " + hero.getName() + " how are you!");
            heal(hero);
            return hero;
        }
    }

    @Override
    public GameCharacter communication2(GameCharacter hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameCharacter communication3(GameCharacter hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void heal(GameCharacter hero){
        String choice;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Do you want to heal all of your Pokemons? (Y/N)");
            choice = keyboard.nextLine();
            if (choice.compareToIgnoreCase("Y") == 0) {
                for (int i = 0; i < 6; i++) {
                    if (hero.Team[i] != null) {
                        hero.Team[i].HP = hero.Team[i].stats.HP;
                        System.out.println("Your " + (i+1) + " pokemon is healed!");
                    }

                }
            } else if (choice.compareToIgnoreCase("N") == 0) {
                System.out.println("See you again~");
            
            } else {
                System.out.println("Just tell me yes or no!");
            }
        } while (choice.compareToIgnoreCase("Y") != 0 && choice.compareToIgnoreCase("N") != 0 );
    }
    
}
