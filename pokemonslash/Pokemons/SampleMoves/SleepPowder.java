/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

/**
 *
 * @author LHT
 */
public class SleepPowder extends Move{

    public SleepPowder() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;
        name = "Sleep Powder";
        maxpp = 32;
        pp = 15;
        type = "Grass";
        accuracy = 75;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
