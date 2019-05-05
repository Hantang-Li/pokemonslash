package pokemonslash;

import java.io.Serializable;

public enum MapSymbol implements Serializable{
    BOUNDARY_A('|',false,"ouch! you knocked a wall."),
    BOUNDARY_B('-',false,"ouch! you knocked a wall."),
    BOUNDARY_INHOUSE(' ',false,null),
    WALL('-',false,"ouch! you knocked a wall, you should use the door."),
    GRASS('*',false,null),
    ROOF_A('\\',false,"ouch! you should use the door."),
    ROOF_B('/',false,"ouch! you should use the door."),
    ROOF_C('=',false,"ouch! you should use the door."),
    ROOF_D('_',false,"ouch! you should use the door."),
    ROOF_E('\\',false,"ouch! you should use the door."),
    FLOOR('.',false,"ouch! you should use the door."),
    DOOR('.',true,"I walk into the house"),
    GROUND(' ',true,null),
    BOOKSHELF('#',false,"ouch! Thers is a bookshelf, you cannot pass"),
    TV('+',false,"ouch! There is a TV, you cannot pass"),
    TABLE('=',false,"ouch! Thers is a table, you cannot pass"), 
    HOUSEFLOOR('·',true,null),
    TABLEWITHPOKEBALL('|',false,null),
    TABLEWITHPOKEBALL_BACK('_',false,null),
    POKEBALL('O',false,"Those are Pokéballs for new trainers!"),
    TELEPORT_INITIAL1('O',true,"OOH I teleported to left cornor."),
    TREE('*',false,"Ohh I knocked a tree!"),
    MEADOW('·',true,"Is any pokemon there?"),
    UNPASSDOOR(' ',false,"Please ask the guard"),
    SPACEFORNPC(' ',false,null),
    POOL('~',false,"There is a pool,you cannot pass!"),
    GYMTAG('+',false,"Welcome to gym"),
    WATER('~',true,null),
    COUNTER('$',false,null);
    
    public char symbol;
    public boolean isWalkable;
    public String message;

    MapSymbol(char symbol, boolean isWalkable, String message) {
        this.symbol = symbol;
        this.isWalkable = isWalkable;
        this.message = message;
    }

}
