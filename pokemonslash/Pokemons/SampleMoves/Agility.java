package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

public class Agility extends Move {

    public Agility() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;//weili
        name = "Agility";
        maxpp = 48;
        pp = 30;
        type = "Psychic";
        accuracy = 100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, attacker, +2, "Speed");
        }
    }
    
    
}
