
package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;


public class Psyduck extends Pokemon {
    public Psyduck(String name, int level) {
        super(name, level,PokemonBaseStats.PSYDUCK);
        type1="Water";
        type2="None";
    }

    @Override
    public Pokemon evolution(Pokemon oldPokemon) {
     if (this.level == 33) {
            Golduck  golduck  = new Golduck (name, level);
            golduck.EV = this.EV;
            golduck.IV = this.IV;
            golduck.gender = this.gender;
            return golduck;
        } else {
            return oldPokemon;
        }
    }
    
    @Override
    public Move learnNewMoves(){
        return null;
    }
}
