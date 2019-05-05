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
 * @author hli
 */
public class StringShot extends Move {

    public StringShot() {
        isAttack = true;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;
        name = "String Shot";
        maxpp = 64;
        pp = 40;
        type="Bug";
        accuracy=95;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, defender, -1, "Speed");
        }
    }
    
}
