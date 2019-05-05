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
public class VineWhip extends Move{

    public VineWhip() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = false;
        power = 45;
        name = "Vine Whip";
        maxpp = 40;
        pp = 25;
        type="Grass";
        accuracy=100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isAttack) {
            dealDamage(attacker, defender);
        }
    }
    
}
