
package pokemonslash.Battle;

import pokemonslash.GameCharacter;
import pokemonslash.Pokemons.Pokemon;


public class Escape extends Action{
    
    public void EscapeFailed(){
        System.out.println("No!There's no running\nform a TRAINER battle!\n\n");
    }
    
    public void Escape(){ 
        System.out.println("Got away safely!!!");     
    }
    
    
 
}
