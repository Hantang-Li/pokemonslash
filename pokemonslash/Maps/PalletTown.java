package pokemonslash.Maps;
import pokemonslash.*;

public class PalletTown extends GameMap{
    public PalletTown() {
        super(20,20,"PalletTown"); //Create a 20 by 20 map, or however big, can change here      
        fillMap();
        fillMapWithNpc();
    }

    
    public void fillMap(){
        int i, j;
        
        
        for(i = 0; i < 20; i++){
            for(j = 0; j < 20; j++){
                mapArray[0][j] = new MapTile(0,j,MapSymbol.BOUNDARY_B); 
                mapArray[19][j] = new MapTile(19,j,MapSymbol.BOUNDARY_B); 
                mapArray[i][0] = new MapTile(i,0,MapSymbol.BOUNDARY_A); 
                mapArray[i][19] = new MapTile(i,19,MapSymbol.BOUNDARY_A); 
                
            } 
        }
        //left cornor bush
        for(i = 15; i < 19; i++){
            for(j = 1; j < 5; j++){
                mapArray[14][j] = new MapTile(14,j,MapSymbol.BOUNDARY_B); 
                mapArray[i][j] = new MapTile(i,j,MapSymbol.GRASS); 
                mapArray[i][5] = new MapTile(i,j,MapSymbol.BOUNDARY_A); 
            } 
        }
        //square house
        for(i = 11; i < 15; i++){
            mapArray[i][10] = new MapTile(i,10,MapSymbol.BOUNDARY_A); 
            mapArray[i][11] = new MapTile(i,11,MapSymbol.WALL); 
            mapArray[i][12] = new MapTile(i,11,MapSymbol.BOUNDARY_A); 
            mapArray[i][14] = new MapTile(i,11,MapSymbol.BOUNDARY_A); 
            mapArray[i][15] = new MapTile(i,15,MapSymbol.WALL); 
            mapArray[i][16] = new MapTile(i,16,MapSymbol.BOUNDARY_A); 
        }
        for(j = 11; j < 16; j++){
            mapArray[12][j] = new MapTile(12,j,MapSymbol.WALL); 
            mapArray[11][j] = new MapTile(12,j,MapSymbol.BOUNDARY_B); 
        }
        //2 upper houses
        for(i = 6; i < 8; i++){
            mapArray[i][3] = new MapTile(i,3,MapSymbol.BOUNDARY_A);
            mapArray[i][4] = new MapTile(i,4,MapSymbol.BOUNDARY_A);
            mapArray[i][6] = new MapTile(i,6,MapSymbol.BOUNDARY_A);
            mapArray[i][7] = new MapTile(i,7,MapSymbol.WALL);
            mapArray[i][8] = new MapTile(i,8,MapSymbol.BOUNDARY_A);
            mapArray[i][11] = new MapTile(i,11,MapSymbol.BOUNDARY_A);
            mapArray[i][12] = new MapTile(i,12,MapSymbol.WALL);
            mapArray[i][13] = new MapTile(i,13,MapSymbol.BOUNDARY_A);
            mapArray[i][15] = new MapTile(i,15,MapSymbol.BOUNDARY_A);
            mapArray[i][16] = new MapTile(i,16,MapSymbol.BOUNDARY_A);
        }
       
        
        mapArray[4][5] = new MapTile(4,5,MapSymbol.BOUNDARY_B);
        mapArray[4][14] = new MapTile(4,14,MapSymbol.BOUNDARY_B);
        mapArray[5][5] = new MapTile(5,5,MapSymbol.BOUNDARY_B);
        mapArray[5][14] = new MapTile(5,14,MapSymbol.BOUNDARY_B);
        mapArray[5][3] = new MapTile(5,3,MapSymbol.ROOF_B);
        mapArray[5][8] = new MapTile(5,8,MapSymbol.ROOF_A);
        mapArray[5][11] = new MapTile(5,11,MapSymbol.ROOF_B);
        mapArray[5][16] = new MapTile(5,16,MapSymbol.ROOF_A);
        
        mapArray[0][9] = new MapTile(0,9,MapSymbol.BOUNDARY_A);
        
        
        mapArray[0][11] = new MapTile(0,11,MapSymbol.BOUNDARY_A);
        
        mapArray[7][14] = new MapTile(8,4,MapSymbol.DOOR,"HouseB",0);
        mapArray[7][5] = new MapTile(8,4,MapSymbol.DOOR,"HouseA",0);
        mapArray[14][13] = new MapTile(7,7,MapSymbol.DOOR,"OakHouse",0);
        mapArray[17][17] = new MapTile(2,2,MapSymbol.TELEPORT_INITIAL1);
        
        mapArray[19][9] = new MapTile(19,9,MapSymbol.BOUNDARY_A);
        mapArray[19][10] = new MapTile(1,10,MapSymbol.SPACEFORNPC,null,3);
        mapArray[19][11] = new MapTile(19,11,MapSymbol.BOUNDARY_A);
        
        mapArray[9][10] = new MapTile(9,10,MapSymbol.SPACEFORNPC,null,1);//for dr
        mapArray[0][10] = new MapTile(9,10,MapSymbol.SPACEFORNPC,null,2);//for guard
    }

    public void fillMapWithNpc() {
         // npc Dr.B
        mapArray[9][10].resident = new NotPlayerC("Dr.B", "Hi! My name is Dr. B");
        //chat
        mapArray[0][10].resident = new NotPlayerC("Guard", "How are you");
        mapArray[19][10].resident = new NotPlayerC("Guard", "How are you");
        
    }

    @Override
    public GameCharacter communication1(GameCharacter hero) {
        if(hero.progress == 0){
            System.out.println("Welcom to pallet town, let's go to my house on the right downward corner, I'll give you a pokemon!");
            return hero;
        }else if(hero.progress == 1){
            System.out.println("Let's talk in my room, I have something that needs to give to you");
            return hero;
        }else if(hero.progress == 2){
            System.out.println("You should go to the house on right upper corner, Mr Bob's son can teach you anything about pokemon!");
            return hero;
        }else if(hero.progress == 3){
            System.out.println("Let's talk in my room!");
            return hero;
        }else{System.out.println("Yo! " + hero.getName() + " how are you!");
            return hero;
        }
    }

    @Override
    public GameCharacter communication2(GameCharacter hero) {
        if(hero.progress <=3){
            System.out.println("you needs a pokemon and pass the test to pass the door, go to see Dr.Oak!");
            return hero;
        }else{
            mapArray[0][10] = new MapTile(18,9,MapSymbol.GROUND,"Route1",0);
            System.out.println("You are going to Route1");
            return hero;
        }
    }

    @Override
    public GameCharacter communication3(GameCharacter hero) {
        if(hero.boat.getAmount()==0){
            System.out.println("you needs a boat to pass the door, you will find a boat on your journey for sure!");
            return hero;
        }else{
            mapArray[19][10] = new MapTile(1,10,MapSymbol.GROUND,"Route21",0);
            System.out.println("You are going to Route21");
            return hero;
        }
    }

    
    
}
