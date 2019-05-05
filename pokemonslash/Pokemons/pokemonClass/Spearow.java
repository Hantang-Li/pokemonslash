package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;

/**
 *
 * @author hli
 */
public class Spearow extends Pokemon {
    public Spearow(String name, int level) {
        super(name, level,PokemonBaseStats.SPEAROW);
        type1="Normal";
        type2="Flying";
    }

    @Override
    public Pokemon evolution(Pokemon oldPokemon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public Move learnNewMoves(){
        return null;
    }
}
