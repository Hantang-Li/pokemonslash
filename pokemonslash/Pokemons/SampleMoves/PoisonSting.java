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
public class PoisonSting extends Move {

    public PoisonSting() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 15;
        name = "poison Sting";
        maxpp = 56;
        pp = 35;
        type = "Poison";
        accuracy = 100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isAttack) {
            dealDamage(attacker, defender);
        }
    }

}
