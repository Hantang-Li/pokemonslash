package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;
/**
 *
 * @author hli
 */
public class Caterpie extends Pokemon {

public Caterpie(String name, int level) {
        super(name, level,PokemonBaseStats.CATERPIE);
        type1="Bug";
        type2="None";
        
    }

    @Override
    public Pokemon evolution(Pokemon oldPokemon) {
        if (this.level == 7) {
            Metapod metapod = new Metapod(name, level);
            metapod.EV = this.EV;
            metapod.IV = this.IV;
            metapod.gender = this.gender;
            return metapod;
        } else {
            return oldPokemon;
        }
    }
    @Override
    public Move learnNewMoves(){
        return null;
    }
}
