package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

public class Harden extends Move {

    public Harden() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;//weili
        name = "Harden";
        maxpp = 48;
        pp = 30;
        type = "Normal";
        accuracy = 100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, attacker, +1, "Defence");
        }
    }
}
