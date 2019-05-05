package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;

public class Squirtle extends Pokemon{

    public Squirtle(String name, int level) {
        super(name, level,PokemonBaseStats.SQUIRTLE);
        type1="Water";
        type2="None";
    }

    @Override
    public Pokemon evolution(Pokemon oldPokemon) {
        if (this.level == 16) {
            Wartortle wartortle  = new Wartortle(name, level);
            wartortle.EV = this.EV;
            wartortle.IV = this.IV;
            wartortle.gender = this.gender;
            return wartortle;
        } else {
            return oldPokemon;
        }
    }
    
     @Override
    public Move learnNewMoves(){
        return null;
    }
   
}
