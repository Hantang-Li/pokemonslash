package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Ember extends Move{
    
    public Ember() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;
        power = 40;//weili
        name = "Ember";
        maxpp = 40;
        pp = 25;
        type="Fire";
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
