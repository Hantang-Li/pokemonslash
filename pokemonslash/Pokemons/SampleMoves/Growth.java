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
public class Growth extends Move {

    public Growth() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;
        name = "Growth";
        maxpp = 32;
        pp = 20;
        type = "Normal";
        accuracy = 95;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, attacker, 1, "Special attack");
            changeStats(attacker, attacker, 1, "Special defence");
        }
    }

}
