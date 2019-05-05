
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class FocusEnergy extends Move{
    
    public FocusEnergy() {
        isAttack = false;
        isStatusEffect = false;
        isSpecial = false;
        power = 0;//weili
        name = "Focus Energy";
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
            changeStats(attacker, defender, +2, "Critical Hit");
        }
    }
}
