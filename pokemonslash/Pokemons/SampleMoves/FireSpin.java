
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class FireSpin extends Move{

    public FireSpin() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;
        power = 35;//
        name = "Fire Spin";
        maxpp = 24;
        pp = 15;
        type="Fire";
        accuracy=85;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
    if (isAttack) {
            dealDamage(attacker, defender);
        }
        if (isStatusEffect) {
            changeStats(attacker, defender, 0, "None");
        }
    }
    
    
}
