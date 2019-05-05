
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Confusion extends Move{

    public Confusion() {
        isAttack = true;
        isStatusEffect = false;//hunluan zhuangtai ???
        isSpecial = true;
        power = 50;//weili
        name = "Confusion";
        maxpp = 40;
        pp = 25;
        type="Psychic";
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
