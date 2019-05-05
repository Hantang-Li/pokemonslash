
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Withdraw extends Move{
    
    public Withdraw() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;//weili
        name = "Withdraw";
        maxpp = 64;
        pp = 40;
        type="Water";
        accuracy=100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, attacker, +1, "Defence");
        }
    }
}
