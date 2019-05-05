
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

public class Tackle extends Move {

    public Tackle() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 40;
        name = "Tackle";
        maxpp = 56;
        pp = maxpp;
        type="Normal";
        accuracy=100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isAttack) {
            dealDamage(attacker, defender);
        }
    }

}