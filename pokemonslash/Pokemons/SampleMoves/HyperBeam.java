
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class HyperBeam extends Move {

    public HyperBeam() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;
        power = 150;//weili
        name = "Hyper Beam";
        maxpp = 8;
        pp = 5;
        type = "Normal";
        accuracy = 90;
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
