
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class DragonRage extends Move{

    public DragonRage() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;
        power = 40;//bian hua  danshi gu ding 40HPshang hai 
        name = "Dragon Rage";
        maxpp = 16;
        pp = 10;
        type="Dragon";
        accuracy=100;
    }
    

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
    if (isAttack) {
            dealDamage(attacker, defender);
        }
    }
    
}
