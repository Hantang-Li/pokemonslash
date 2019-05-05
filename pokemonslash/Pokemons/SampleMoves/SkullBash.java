
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class SkullBash extends Move{
    
    public SkullBash() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 130;//weili
        name = "Skull Bash";
        maxpp = 16;
        pp = 10;
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
