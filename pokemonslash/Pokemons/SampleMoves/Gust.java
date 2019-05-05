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
public class Gust extends Move {

    public Gust() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 40;
        name = "Gust";
        maxpp = 35;
        pp = maxpp;
        type="Normal";
        accuracy = 100;
    }


    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
       if (isAttack) {
            dealDamage(attacker, defender);
        }
    }
}
