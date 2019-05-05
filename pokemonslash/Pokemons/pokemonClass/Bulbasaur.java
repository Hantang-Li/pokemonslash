
package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;
import pokemonslash.Pokemons.SampleMoves.Ember;
import pokemonslash.Pokemons.SampleMoves.Growth;
import pokemonslash.Pokemons.SampleMoves.LeechSeed;
import pokemonslash.Pokemons.SampleMoves.PoisonPowder;
import pokemonslash.Pokemons.SampleMoves.RazorLeaf;
import pokemonslash.Pokemons.SampleMoves.SleepPowder;
import pokemonslash.Pokemons.SampleMoves.SolarBeam;
import pokemonslash.Pokemons.SampleMoves.VineWhip;

public class Bulbasaur extends Pokemon{ 
     
    public Bulbasaur(String name, int level) {
        super(name, level,PokemonBaseStats.BULBASAUR);
        type1="Grass";
        type2="Poison";
    }

    @Override
    public Pokemon evolution(Pokemon oldPokemon) {
        if (this.level == 16) {
            Ivysaur ivysaur = new Ivysaur(name, level);
            ivysaur.EV = this.EV;
            ivysaur.IV = this.IV;
            ivysaur.gender = this.gender;
            return ivysaur;
        } 
        else if ( this.level == 32){
            return oldPokemon;
        }
        else {
            return oldPokemon;
        }
    }
    
    
    @Override
    public Move learnNewMoves(){
        Move newMove ;
        if(this.level ==7){
           newMove=new LeechSeed();
           return newMove;
        }
        if(this.level ==13){
           newMove=new VineWhip();
           return newMove;
        }
        if(this.level ==20){
           newMove=new PoisonPowder();
           return newMove;
        }
        if(this.level ==27){
           newMove=new RazorLeaf();
           return newMove;
        }
        if(this.level ==34){
           newMove=new Growth();
           return newMove;
        }
        if(this.level ==41){
           newMove=new SleepPowder();
           return newMove;
        }
        if(this.level ==48){
           newMove=new SolarBeam();
           return newMove;
        }
        return null;
    }
    

}
