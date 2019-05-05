
package pokemonslash.Pokemons.pokemonClass;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;


public class Ivysaur extends Pokemon {

    public Ivysaur(String name, int level) {
        super(name, level,PokemonBaseStats.IVYSAUR);
        type1="Grass";
        type2="None";
        //Move[0] = 
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
