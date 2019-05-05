
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;


public class Disable extends Move {

    public Disable() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;
        name = "Disable";
        maxpp = 32;
        pp = 20;
        type="Normal";
        accuracy=100;
    }
    /////not finished

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
