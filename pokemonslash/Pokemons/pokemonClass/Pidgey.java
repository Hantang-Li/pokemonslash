package pokemonslash.Pokemons.pokemonClass;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.PokemonBaseStats;


public class Pidgey extends Pokemon {
    public Pidgey(String name, int level) {
        super(name, level,PokemonBaseStats.PIDGEY);
        type1="Normal";
        type2="Flying";
    }

    @Override
    public Pokemon evolution(Pokemon oldPokemon) {
    if (this.level == 18){
            Pidgeotto  pidgeotto = new Pidgeotto (name, level);
            pidgeotto.EV = this.EV;
            pidgeotto.IV = this.IV;
            pidgeotto.gender = this.gender;
            return pidgeotto;
        } else {
            return oldPokemon;
        }
    }
    @Override
    public Move learnNewMoves(){
        return null;
    }
}
