package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

public class SmokeScreen extends Move {

    public SmokeScreen() {
        isAttack = false;
        isStatusEffect = true;
        isSpecial = false;
        power = 0;//weili
        name = "Smoke Screen";
        maxpp = 32;
        pp = 20;
        type = "Normal";
        accuracy = 100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isStatusEffect) {
            changeStats(attacker, defender, -1, "Accuracy");
        }
    }
}
