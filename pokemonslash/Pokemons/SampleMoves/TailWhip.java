
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

public class TailWhip extends Move{
    
    public TailWhip() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;
        name = "Tail Whip";
        maxpp = 48;
        pp = 30;
        type="None";
        accuracy=100;
    }


    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, defender, -1, "Defence");
        }
    }
}
