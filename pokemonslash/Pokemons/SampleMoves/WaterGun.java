package pokemonslash.Pokemons.SampleMoves;

import pokemonslash.Move;
import pokemonslash.Pokemons.Pokemon;

public class WaterGun extends Move {

    public WaterGun() {
        isAttack = true;
        isStatusEffect = false;
        isSpecial = true;
        power = 40;//weili
        name = "Water Gun";
        maxpp = 40;
        pp = 25;
        type = "Water";
        accuracy = 100;
    }

    @Override
    public void useMove(Pokemon attacker, Pokemon defender) {
        if (isAttack) {
            dealDamage(attacker, defender);
        }
        if (isStatusEffect) {
            changeStats(attacker, defender, 0, "None");
        }
    }
}
