
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class SuperFang extends Move{
    
    public SuperFang() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 10;//various  wrong!!!!
        name = "Super Fang";
        maxpp = 16;
        pp = 10;
        type="Normal";
        accuracy=90;
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
