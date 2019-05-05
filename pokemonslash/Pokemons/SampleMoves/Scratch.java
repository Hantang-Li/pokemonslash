
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

public class Scratch extends Move {

    public Scratch() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 35;
        name = "Scratch";
        maxpp = 35;
        pp = maxpp;
        type="Normal";
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
