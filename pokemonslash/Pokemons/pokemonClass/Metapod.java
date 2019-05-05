
package pokemonslash.Pokemons.pokemonClass;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;


public class Metapod extends Pokemon{

    public Metapod(String name, int level) {
        super(name, level,PokemonBaseStats.METAPOD);
        type1="Bug";
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
