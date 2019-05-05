package pokemonslash.Maps;

import java.util.Random;
import java.util.Scanner;
import pokemonslash.*;
import pokemonslash.Battle.Battle3;
import pokemonslash.Pokemons.SampleMoves.Scratch;
import pokemonslash.Pokemons.SampleMoves.TailWhip;
import pokemonslash.Pokemons.pokemonClass.Pidgey;
import pokemonslash.Pokemons.pokemonClass.Psyduck;

public class HouseB extends GameMap{
    
    public HouseB(){
        super(11,11,"HouseB");
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
        mapArray[9][4] = new MapTile(8,14,MapSymbol.DOOR,"PalletTown",0);
        mapArray[9][5] = new MapTile(9,5,MapSymbol.BOUNDARY_A);
        
        mapArray[6][7] = new MapTile(6,7,MapSymbol.SPACEFORNPC,null,1);
        

    }


    public void fillMapWithNpc() {
        // npc Bob
        mapArray[6][7].resident = new NotPlayerC("Bob", "");
        
        
    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        Random rnd = new Random();
        if(hero.progress <2){
            System.out.println("Hey " + hero.getName() + ", nice to meet you");
            return hero;
        }else if(hero.progress == 2){
            GameCharacter bob = new GameCharacter("Bob");
            System.out.println("I heard Oak's order, " + hero.getName() + " \nyour first opponient will be me! Go! Psyduck\n(Enter any button to continue)");
            Scanner keyboard = new Scanner(System.in);
            String button;
            button = keyboard.nextLine();
            Psyduck psyduck = new Psyduck("psyduck",3);
            Scratch scratch = new Scratch();
            psyduck.Move[0]=scratch;
            TailWhip tailWhuip = new TailWhip();
            psyduck.Move[1] = tailWhuip;
            bob.Team[0] = psyduck;
            Battle3 houseBBattle = new Battle3(hero,bob);
            if (bob.Team[0].HP <=0){
                System.out.println("you won, go see the doctor, he is in his house!");
                hero.setMoney(hero.getMoney()+100);
                System.out.println("You got 100 dollars!");
                hero.progress = 3;
            }else{
                System.out.println("This is your first fight, do not lose!!!");
                hero.Team[0].HP = hero.Team[0].maxhp;
                communication1(hero);
            }
            return hero;
        }else if(hero.progress == 3){
            System.out.println("Go see the doctor, he is in his house!");
            return hero;
        }else if(hero.progress == 4){
            System.out.println("My son is in Route1, he will teach you how to catch a pokemon");
            return hero;
        }else{
            
            System.out.println("How are you");
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
}

