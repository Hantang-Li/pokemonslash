
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class WingAttack extends Move{
    
    public WingAttack() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 60;//weili
        name = "Wing Attack";
        maxpp = 56;
        pp = 35;
        type="Flying";
        accuracy=100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isAttack) {
            dealDamage(attacker, defender);
        }
    }
}
