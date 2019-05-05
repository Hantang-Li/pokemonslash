
package pokemonslash.Pokemons;

import java.io.Serializable;


public enum PokemonMoves  implements Serializable {
    ABSORB("Absorb","Grass","Special",20,100,20,"Leeches 50% of the damage dealt.",0,0,0,0),
    ACID("Acid","Poison","Physical",40,10,30,"10% chance to lower the target's Defense by one stage.",0,-66/100,0,0),
    ACID_ARMOR("Acid Armor","Poison","None",-100,-1,40,"Boosts the user's Defense by two stages.",0,200/100,0,0),
    AGILITY("Agility","Psychic","None",-1,-100,30,"Boosts the user's Speed by two stages. Negates the Speed drop of paralysis.",0,0,200/100,0),
    AMNESIA("Amnesia","Psychic","None",-1,-100,20,"Boosts the user's Special by two stages.",0,0,0,200/100),
    AURORA_BEAM("Aurora Beam","Ice","Special",65,10,20,"10% chance to lower the user's Attack by one stage.",-66/100,0,0,0),
    BARRAGE("Barrage","Normal","Physical",15,85,20,"Hits two to five times.",0,0,0,0),
    BARRIER("Barrier","Psychic","None",-1,-100,30,"Boosts the user's Defense by two stages.",0,200/100,0,0);
    public final int power,PP,attack,defense,speed,special;
    public final String NameOfMove,TypeOfMove,categoryOfMove,description;
    public final double accuracy;
    
    private PokemonMoves(String NameOfMove,String TypeOfMove,String categoryOfMove,int power,double accuracy, int PP,String description,int attack ,int defense,int speed,int special ) {
        this.power = power;
        this.PP = PP;
        this.NameOfMove = NameOfMove;
        this.TypeOfMove = TypeOfMove;
        this.categoryOfMove = categoryOfMove;
        this.description = description;
        this.accuracy = accuracy; 
        this.attack = attack;
        this.special = special;
        this.speed = speed;
        this.defense = defense;
        
    }

}
