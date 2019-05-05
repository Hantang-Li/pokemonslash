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
public class RazorLeaf extends Move{

    public RazorLeaf() {
        isAttack = true;
        isStatusEffect = true;
        isSpecial = false;
        power = 55;
        name = "Razor Leaf";
        maxpp = 40;
        pp = 25;
        type="Grass";
        accuracy=95;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isAttack) {
            dealDamage(attacker, defender);
        }
        if (isStatusEffect) {
            changeStats(attacker, attacker, 1, "Critical hit");
        }
    }
    
}
