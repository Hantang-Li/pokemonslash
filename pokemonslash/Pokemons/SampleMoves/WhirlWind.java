
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class WhirlWind extends Move{
   
    public WhirlWind() {
        isAttack = false;
        isStatusEffect = false;
        isSpecial = false;
        power = 0;//weili
        name = "WhirlWind";
        maxpp = 32;
        pp = 20;
        type="Normal";
        accuracy=100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, defender, 0, "None");
        }
    }   
}
