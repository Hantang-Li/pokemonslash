
package pokemonslash.Pokemons;

import java.io.Serializable;


public class PokemonStat implements Serializable{
    public int HP, attack, defense, special, speed;

    public PokemonStat() {
        attack=0;
        defense=0;
        special=0;
        speed=0;
        HP=0;
    }
    
    public PokemonStat(int HP, int attack, int defense, int special, int speed) {
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.special = special;
        this.speed = speed;
        
    }

    @Override
    public String toString() {
        return "PokemonStat:" + "\n attack=" + attack + "\n defense=" + defense + "\n special=" + special + "\n speed=" + speed;
    }
    
    
}
