
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Peck extends Move{
    
    public Peck() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 35;//weili
        name = "Peck";
        maxpp = 56;
        pp = 35;
        type="Flying";
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
