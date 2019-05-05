package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;
import pokemonslash.Pokemons.SampleMoves.Ember;
import pokemonslash.Pokemons.SampleMoves.FireSpin;
import pokemonslash.Pokemons.SampleMoves.Flamethrower;
import pokemonslash.Pokemons.SampleMoves.Leer;
import pokemonslash.Pokemons.SampleMoves.Rage;
import pokemonslash.Pokemons.SampleMoves.Slash;

public class Charmander extends Pokemon{

    
    public Charmander(String name, int level) {
        super(name, level,PokemonBaseStats.CHARMANDER);
        type1="Fire";
        type2="None";

    }
     
     
    @Override
    public Pokemon evolution(Pokemon oldPokemon){
       if(this.level ==16){
           Charmeleon charmeleon = new Charmeleon(name,level);
            charmeleon.EV = this.EV;
            charmeleon.IV = this.IV;
            charmeleon.gender = this.gender;
            System.out.println("What?"+name+" is evolving!");
            return charmeleon;     
       }
       else{
           return oldPokemon;
       }
    }
    
    @Override
    public Move learnNewMoves(){
        Move newMove ;
        if(this.level ==9){
           newMove=new Ember();
           return newMove;
        }
        if(this.level ==15){
           newMove=new Leer();
           return newMove;
        }
        if(this.level ==22){
           newMove=new Rage();
           return newMove;
        }
        if(this.level ==30){
           newMove=new Slash();
           return newMove;
        }
        if(this.level ==38){
           newMove=new Flamethrower();
           return newMove;
        }
        if(this.level ==46){
           newMove=new FireSpin();
           return newMove;
        }
        return null;
    }
    
    
    
   
}
