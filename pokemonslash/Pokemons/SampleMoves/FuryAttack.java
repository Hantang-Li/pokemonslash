
package pokemonslash.Pokemons.SampleMoves;

import java.util.Random;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class FuryAttack extends Move{
    
    public FuryAttack() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 15;//weili
        name = "Fury Attack";
        maxpp = 32;
        pp = 20;
        type="Normal";
        accuracy=85;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        Random RNG = new Random();
        int chance;

        chance = RNG.nextInt(7);
        if (isAttack) {
            if (chance == 0 || chance == 1) {
                dealDamage(attacker, defender);
                dealDamage(attacker, defender);
            }
        } else if (chance == 2 || chance == 3) {
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
        } else if (chance == 4) {
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
        } else {
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
            dealDamage(attacker, defender);
        }
        if (isStatusEffect) {
            changeStats(attacker, defender, 0, "None");
        }
    }
}
