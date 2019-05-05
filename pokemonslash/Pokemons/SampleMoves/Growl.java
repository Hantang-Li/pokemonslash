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
public class Growl extends Move{

    public Growl() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;
        name = "Growl";
        maxpp = 64;
        pp = 40;
        type="Normal";
        accuracy=100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, defender, -1, "Attack");
        }
    }
    
}
