
package pokemonslash.Pokemons.pokemonClass;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;


public class Raticate extends Pokemon{

    public Raticate(String name, int level) {
        super(name, level,PokemonBaseStats.RATICATE);
        type1="Normal";
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
