package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;

/**
 *
 * @author hli
 */
public class Weedle extends Pokemon {
    public Weedle(String name, int level) {
        super(name, level,PokemonBaseStats.WEEDLE);
        type1="Bug";
        type2="Poison";
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
