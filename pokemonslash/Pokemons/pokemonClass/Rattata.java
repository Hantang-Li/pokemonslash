
package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;

public class Rattata extends Pokemon {
    public Rattata(String name, int level) {
        super(name, level,PokemonBaseStats.RATTATA);
        type1="Normal";
        type2="None";
    }

    /**
     *
     * @param oldPokemon
     * @return
     */
    @Override
    public Pokemon evolution(Pokemon oldPokemon) {
     if (this.level == 20) {
            Raticate raticate = new Raticate(name, level);
            raticate.EV = this.EV;
            raticate.IV = this.IV;
            raticate.gender = this.gender;
            return raticate;
        } else {
            return oldPokemon;
        }
    }
    
     @Override
    public Move learnNewMoves(){
        return null;
    }
}
