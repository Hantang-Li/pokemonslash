
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Slash extends Move{
    
    public Slash() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 70;//weili
        name = "Slash";
        maxpp = 32;
        pp = 20;
        type="Normal";
        accuracy=100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isAttack) {
            dealDamage(attacker, defender);
        }
        if (isStatusEffect) {
            changeStats(attacker, defender, 0, "Critical hit");
        }
    }
}
