
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class QuickAttack extends Move{
   
    public QuickAttack() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 40;//weili
        name = "Quick Attack";
        maxpp = 48;
        pp = 30;
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
