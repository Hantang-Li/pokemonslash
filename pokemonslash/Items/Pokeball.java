
package pokemonslash.Items;

import java.util.Random;
import java.util.Scanner;
import pokemonslash.GameCharacter;
import pokemonslash.Pokemons.Pokemon;

public class Pokeball extends Items {
       
    public boolean PokemonCatched=false;
    
    public Pokemon function(Pokemon pokemon) {
        int m;
        int f;
        Random rnd=new Random();
        m = rnd.nextInt(255)+1;
        f = (pokemon.maxhp*255*4)/(pokemon.HP*12);
        if (f > m){
            return pokemon;  
        }else{
            return null;
        }
    }

    @Override
    public void choiceItems(GameCharacter hero) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Use a pokeball  (Y/N)");
        String choice;
        choice=keyboard.nextLine();  
        if(choice.equalsIgnoreCase("N")){
            numberOfPokemon=7;
        }
        else{
            numberOfPokemon=0;
        }
    }

    
    public void useItems(GameCharacter hero,Pokemon wildPokemon,Pokemon opponent) {
        Scanner keyboard = new Scanner(System.in); 
        String continueButton;
        if(wildPokemon==null){
            catchPokemonFailed(hero,opponent);
            System.out.println("The trianer blocked the Pokeball\nDon't be a thief!\n\n");
           
            System.out.println("\n\tPress any button to continue!");
            continueButton=keyboard.nextLine();
            System.out.print("\n");
        }else{
        for(int i=0; i<=6; i++){   
            if(i==6){
                if(hero.pokeball.getAmount()>0){
                    int j=-1;
                    do{
                       j++;
                    }while(hero.pc[j]!=null);
                    hero.pc[j] = hero.pokeball.function(wildPokemon);
                    if(hero.pc[j] == null){
                        catchPokemonFailed(hero,wildPokemon);
                        System.out.println("Failed, you can try again!\n\n");
                        hero.pokeball.setAmount(hero.pokeball.getAmount()-1);
                        
                        System.out.println("\n\tPress any button to continue!");
                        continueButton=keyboard.nextLine();
                        System.out.print("\n");
                    }else{
                        catchPokemonSuccessfully(hero,wildPokemon);
                        System.out.println("You successfully catched a pokemon!\n\nYour pokemon was sent to pc\n\n");
                        hero.pokeball.setAmount(hero.pokeball.getAmount()-1);
                        PokemonCatched=true;
                }
                }else{
                    System.out.println("you have no pokeball!");
                }
               break; 
            }
            if(hero.Team[i] == null){   
                if(hero.pokeball.getAmount()>0){
                    hero.Team[i] = hero.pokeball.function(wildPokemon);
                    if(hero.Team[i] == null){
                        catchPokemonFailed(hero,wildPokemon);
                        System.out.println("Failed, you can try again!\n\n");
                        hero.pokeball.setAmount(hero.pokeball.getAmount()-1);
                        System.out.println("\n\tPress any button to continue!");
                        continueButton=keyboard.nextLine();
                        System.out.print("\n");
                    }else{
                        catchPokemonSuccessfully(hero,wildPokemon);
                        System.out.println("you successfully catched a pokemon!\n\n");
                        hero.pokeball.setAmount(hero.pokeball.getAmount()-1);
                        PokemonCatched=true;
                }
                }else{
                    System.out.println("you have no pokeball!");
                }
                break;
            }
        } 
        } 
    }


    public void catchPokemonSuccessfully(GameCharacter hero,Pokemon Tp) {
        System.out.println(" _______________________");
        System.out.println("| "+Tp.baseStats.nameOfPokemon+"      "+"Lv"+Tp.level);//+Tp.gender
        System.out.print("|\tHP");
        showHpLine(Tp,Tp.HP);
        System.out.println("\t");
        System.out.println(" ----------------------- ");
        System.out.println("\t\t\t\t * * *");  
        System.out.print("\t\t\t\t (-O-)\n\n");  
        System.out.println("\t"+hero.getName()+"\n\n\n");  
        System.out.println(hero.getName()+" used\nPokeball");

        
    }
    
    public void catchPokemonFailed(GameCharacter hero,Pokemon opponent) {
        System.out.println(" _______________________");
        System.out.println("| "+opponent.baseStats.nameOfPokemon+"      "+"Lv"+opponent.level);//+Tp.gender
        System.out.print("|\tHP");
        showHpLine(opponent,opponent.HP);
        System.out.println("\t");
        System.out.println(" ----------------------- ");
        System.out.println("\t\t\t\t");  
        System.out.print("\t\t\t\t (-O-)\n\n");  
        System.out.println("\t"+hero.getName()+"\n\n\n");  
        System.out.println(hero.getName()+" used\nPokeball");
    }
    
    
    public void showHpLine(Pokemon pokemonOfhero,int HP) {
       for(int i=0;i<HP*10/pokemonOfhero.stats.HP;i++){
           System.out.print("-");
        }
        System.out.print(" ");

    }

    @Override
    public Pokemon useItems(Pokemon pokemon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pokemon functionForEnemy(Pokemon pokemon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
