package pokemonslash;

import java.io.Serializable;

public abstract class GameMap  implements Serializable {

    public MapTile[][] mapArray;
    public int ySize,xSize;
    public String name;
    public boolean pass;
    
    public GameMap(int ySize, int xSize,String name) {
        //dot
        this.ySize=ySize;
        this.xSize=xSize;
        this.mapArray=new MapTile[ySize][xSize];
        this.name=name;
        for(int i=0;i<ySize;i++){
            for(int j=0;j<xSize;j++){
                mapArray[i][j] = new MapTile(i,j,MapSymbol.GROUND);
            }
        }
    }
    
    void  showMap(MapTile heroTile,Game myGame){
        for(int i=heroTile.y-5;i<heroTile.y+5;i++){
            for(int j=heroTile.x-5;j<heroTile.x+5;j++){
                if((i<0)||(i>ySize-1)||(j>xSize-1)||(j<0)){
                   System.out.print(" ");
                }
                else if ((heroTile.x==j)&& (heroTile.y==i)){
                    System.out.print(myGame.hero.getName().charAt(0));
                }
                //npc
                else if (mapArray[i][j].resident != null){
                    System.out.print(mapArray[i][j].resident.getName().charAt(0));
                }
                else{
                   System.out.print(mapArray[i][j].ms.symbol);
                }
            }
            System.out.println();
        }
    }

    public abstract void fillMap();
    public abstract GameCharacter communication1(GameCharacter hero);
    public abstract GameCharacter communication2(GameCharacter hero);
    public abstract GameCharacter communication3(GameCharacter hero);
}
