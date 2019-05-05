
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class HydroPump extends Move {

    public HydroPump() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;
        power = 110;//weili
        name = "HydroPump";
        maxpp = 8;
        pp = 5;
        type="Water";
        accuracy=80;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
    if (isAttack) {
            dealDamage(attacker, defender);
        }
    }
    
}
