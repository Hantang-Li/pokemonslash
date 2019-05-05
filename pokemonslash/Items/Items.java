package pokemonslash.Items;

import java.io.Serializable;
import pokemonslash.GameCharacter;
import pokemonslash.Pokemons.Pokemon;

abstract class Items implements Serializable {

    public int amount;
    public int numberOfPokemon,numberOfMove;
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public abstract void choiceItems(GameCharacter hero);

    
    public abstract Pokemon useItems(Pokemon pokemon);
    
    public abstract Pokemon functionForEnemy(Pokemon pokemon);

}
