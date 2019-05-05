
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class HyperFang extends Move{
    
    public HyperFang() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 80;//weili
        name = "Hyper Fang";
        maxpp = 24;
        pp = 15;
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
