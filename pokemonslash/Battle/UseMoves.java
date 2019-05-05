
package pokemonslash.Battle;

import java.util.Random;
import pokemonslash.Pokemons.Pokemon;



public class UseMoves extends Action{ 
    
     
    public void UseMoves(Pokemon attacker,Pokemon defender,int choice) {  
        sequence=3;
        if(attacker.Move[choice-1].accuracy*attacker.accuracy.getValue()/defender.evasion.getValue()>=getAccuracy()){  
            attacker.Move[choice-1].useMove(attacker,defender);
            if(defender.HP<=0){
                defender.HP=0;
                System.out.println(defender.getName()+"\nfainted!");
            } 
        }  
        else{
            System.out.println("Miss....");
        }    
    }
        
    private int getAccuracy() {
        Random rng = new Random();
        return rng.nextInt(100)+1;  
    }
    
    
    
    
}
