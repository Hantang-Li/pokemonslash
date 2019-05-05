
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Leer extends Move{
    
    public Leer() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;//weili
        name = "Leer";
        maxpp = 48;
        pp = 30;
        type="Normal";
        accuracy=100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, defender, -1, "Defence");
        }
    }
}
