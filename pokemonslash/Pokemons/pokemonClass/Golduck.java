
package pokemonslash.Pokemons.pokemonClass;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;

public class Golduck extends Pokemon{

    public Golduck(String name, int level) {
        super(name, level,PokemonBaseStats.GOLDUCK);
        type1="Water";
        type2="None";
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
