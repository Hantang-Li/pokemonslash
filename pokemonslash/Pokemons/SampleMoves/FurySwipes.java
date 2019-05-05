
package pokemonslash.Pokemons.SampleMoves;

import java.util.Random;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class FurySwipes extends Move{

    public FurySwipes() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;//?????NOT SURE
        power = 18;//weili
        name = "Fury Swipes";
        maxpp = 24;
        pp = 15;
        type="physical";
        accuracy=80;
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
