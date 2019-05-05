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
public class PoisonPowder extends Move{

    public PoisonPowder() {
        isAttack = false;
        isStatusEffect = false;
        isSpecial = false;
        power = 0;
        name = "Poison Powder";
        maxpp = 56;
        pp = 35;
        type="Poison";
        accuracy=75;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
