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
public class SolarBeam extends Move{

    public SolarBeam() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;//absolute special
        power = 120;
        name = "Solar Beam";
        maxpp = 16;
        pp = 10;
        type = "Grass";
        accuracy = 100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isAttack) {
            dealDamage(attacker, defender);
        }
        
    }
    
}
