package pokemonslash.Pokemons.SampleMoves;

import java.util.Random;
import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

public class Bubble extends Move {

    public Bubble() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;
        power = 40;//weili
        name = "Bubble";
        maxpp = 48;
        pp = 30;
        type = "Water";
        accuracy = 100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        Random Rng = new Random();
        int chance = Rng.nextInt(11);
        if (isAttack) {
            dealDamage(attacker, defender);
        }
        if (isStatusEffect) {
            if(chance ==0 ){
                changeStats(attacker, defender, -1, "speed");
            }
            
        }
    }
}
