
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class MirrorMove extends Move{
    
    public MirrorMove() {
        isAttack = false;//not sure
        isStatusEffect = false;//??
        isSpecial = false;
        power = 0;//weili
        name = "Mirror Move";
        maxpp = 32;
        pp = 20;
        type="Flying";
        accuracy=100;
    }
    // dont know how to code it 
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
