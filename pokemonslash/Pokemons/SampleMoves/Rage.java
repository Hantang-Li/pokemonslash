
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Rage extends Move{
    
    public Rage() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 20;//weili
        name = "Rage";
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
    }
}
