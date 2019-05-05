
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Flamethrower extends Move{

    public Flamethrower() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;
        power = 90;//weili
        name = "Flamethrower";
        maxpp = 24;
        pp = 15;
        type="Fire";
        accuracy=100;
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
