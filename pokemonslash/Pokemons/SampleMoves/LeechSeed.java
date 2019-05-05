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
public class LeechSeed extends Move{

    public LeechSeed() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 0;
        name = "Leech Seed";
        maxpp = 16;
        pp = 10;
        type="Grass";
        accuracy=90;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
