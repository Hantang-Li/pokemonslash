package pokemonslash.Maps;

import java.util.Scanner;
import pokemonslash.*;
import pokemonslash.Pokemons.*;
import pokemonslash.Pokemons.SampleMoves.Growl;
import pokemonslash.Pokemons.SampleMoves.Scratch;
import pokemonslash.Pokemons.SampleMoves.Tackle;
import pokemonslash.Pokemons.SampleMoves.TailWhip;
import pokemonslash.Pokemons.pokemonClass.Bulbasaur;
import pokemonslash.Pokemons.pokemonClass.Charmander;
import pokemonslash.Pokemons.pokemonClass.Squirtle;


public class OakHouse extends GameMap{
    public OakHouse(){
        super(10,16,"OakHouse");
        fillMap();
        fillMapWithNpc();
    }
    
    public void fillMap(){
        int i, j;
        
        for(j=0;j<10;j++){
            for(i=0;i<16;i++){
                mapArray[j][i] = new MapTile(j,i,MapSymbol.HOUSEFLOOR);
            }
        }
        //pokeball
        mapArray[1][4] = new MapTile(1,4,MapSymbol.TABLEWITHPOKEBALL);
        mapArray[2][4] = new MapTile(2,4,MapSymbol.TABLEWITHPOKEBALL);
        for(i=5;i<10;i++){
            mapArray[1][i] = new MapTile(1,i,MapSymbol.TABLEWITHPOKEBALL_BACK);
        }
        mapArray[2][5] = new MapTile(2,5,MapSymbol.POKEBALL,null,1);
        mapArray[2][7] = new MapTile(2,7,MapSymbol.POKEBALL,null,1);
        mapArray[2][9] = new MapTile(2,9,MapSymbol.POKEBALL,null,1);
        
        mapArray[1][10] = new MapTile(1,10,MapSymbol.TABLEWITHPOKEBALL);
        mapArray[2][10] = new MapTile(2,10,MapSymbol.TABLEWITHPOKEBALL);
        //boundry
        for(i = 0; i < 10; i++){
            for(j = 0; j < 16; j++){
                mapArray[0][j] = new MapTile(0,j,MapSymbol.BOUNDARY_INHOUSE); 
                mapArray[9][j] = new MapTile(9,j,MapSymbol.BOUNDARY_INHOUSE); 
                mapArray[i][0] = new MapTile(i,0,MapSymbol.BOUNDARY_INHOUSE); 
                mapArray[i][15] = new MapTile(i,10,MapSymbol.BOUNDARY_INHOUSE); 
                
            } 
        }
        
        mapArray[8][6] = new MapTile(8,6,MapSymbol.BOUNDARY_A);
        mapArray[8][7] = new MapTile(15,13,MapSymbol.DOOR,"PalletTown",0);
        mapArray[8][8] = new MapTile(8,8,MapSymbol.BOUNDARY_A);
        
        mapArray[5][7] = new MapTile(5,7,MapSymbol.SPACEFORNPC,null,2);

    }
    
    public void fillMapWithNpc() {
         // npc Dr.B
        mapArray[5][7].resident = new NotPlayerC("Dr.B", "You are talking to Oak.");
        //chat
    }
    
    //gamemap can have an integer method, but overidden method can be void!
    @Override
    public GameCharacter communication1(GameCharacter hero) {
        
        if(hero.progress == 0){
            String choice;
            Scanner keyboard = new Scanner(System.in);
            do{
                System.out.println("Which Pokémon do you want to choose?\n1. Bulbasaur\n2. Charmander\n3. Squirtle");
                choice = keyboard.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("You got a Bulbasaur"); 
                        Bulbasaur b = new Bulbasaur("Bulbasaur",5);
                        Tackle tc = new Tackle();
                        Growl gw = new Growl();
                        b.Move[0] = tc;
                        b.Move[1] = gw;
                        hero.addPokemon(b);
                        break;
                    case "2":        
                        System.out.println("You got a Charmander"); 
                        Charmander c = new Charmander("Charmander",5);
                        Scratch sc = new Scratch();
                        Growl gr = new Growl();
                        c.Move[0] = sc;
                        c.Move[1] = gr;
                        hero.addPokemon(c);
                        break;
                    case "3":
                        System.out.println("You got a Squirtle"); 
                        Squirtle s = new Squirtle("Squirtle",5);
                        Tackle tk = new Tackle();
                        TailWhip tw = new TailWhip();
                        s.Move[0] = tk;
                        s.Move[1] = tw;
                        hero.addPokemon(s);
                        break;
                }
            }while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")));
            System.out.println("Doctor wants to tell youn something, go and see him in this room!"); 
            hero.progress = 1;
            return hero;
        }else {
            System.out.println("You already chosed a Pokémon!"); 
            return hero;
        }
    }
    //story game guide
    @Override
    public GameCharacter communication2(GameCharacter hero) {
        if(hero.progress == 0){
            System.out.println("Please choose a Pokemon!\nThey are on the table at the end of the room!");
            return hero;
        }else if(hero.progress == 1){
            System.out.println("Now you have a Pokemon,\nYou should go to the house on right upper corner,\nMr Bob's can teach you ho to fight!"
                    + "\nI will give you some items and it will be useful later!");
            hero.hpm.setAmount(5);
            hero.ppm.setAmount(5);
            hero.setMoney(200);
            System.out.println("\nyou got 5 Ether and Hpup!\nyou got 200 dolloars! Press any button to continue");
            hero.progress = 2;
            Scanner keyboard = new Scanner(System.in);
            String button;
            button = keyboard.nextLine();
            return hero;
        }else if(hero.progress == 2){
            System.out.println("You should go to the house on right upper corner,\nMr Bob's can teach you hot to fight!");
            return hero;
        }else if(hero.progress == 3){
            System.out.println("Now you can begin your journey, \nbob's son is in route1, go and find him!");
            hero.pokeball.setAmount(5);
            System.out.println("\nyou got 5 pokeballs! Press any button to continue");
            Scanner keyboard = new Scanner(System.in);
            String button;
            button = keyboard.nextLine();
            hero.progress = 4;
            return hero;
        }else if(hero.progress == 4){
            System.out.println("Find bob's son he is in Route1\nGood luck!");
            return hero;
        }else{
            System.out.println("Yo! " + hero.getName() + " how are you!");
            return hero;
        }
    }

    @Override
    public GameCharacter communication3(GameCharacter hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

