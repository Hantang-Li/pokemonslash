
package pokemonslash.Battle;

import pokemonslash.GameCharacter;
import pokemonslash.Pokemons.Pokemon;


public class LevelUp extends Action {
    
    
   public void LevelUp(GameCharacter hero,GameCharacter trainer,Pokemon wildPokemon){   
        int j=0,baseExpYieldOfFaintedPokemon=0,FullMoves=0;
        
        
            for(int i=0;i<6;i++){
                if((hero.Team[i]!=null)&&(hero.Team[i].inBattle==true)){
                    j++;
                }
            }
             
            for(int i=0;i<6;i++){
                if((trainer.Team[i]!=null)){
                    baseExpYieldOfFaintedPokemon=+trainer.Team[i].baseStats.expYield;
                }
            }
               
            
            for(int i=0;i<6;i++){
                
                int ExpEarned;
                if((hero.Team[i]!=null)&&(hero.Team[i].inBattle==true)){
                    
                    if(wildPokemon!=null){
                        //change the condition
                        hero.Team[i].levelUp1(baseExpYieldOfFaintedPokemon,hero.Team[i].level,j);   
                        ExpEarned=hero.Team[i].calculateGainExpA1(baseExpYieldOfFaintedPokemon,hero.Team[i].level,j);
                    }
                    else{
                        //change the condition
                        hero.Team[i].levelUp2(baseExpYieldOfFaintedPokemon,hero.Team[i].level,j);
                        ExpEarned=hero.Team[i].calculateGainExpA2(baseExpYieldOfFaintedPokemon,hero.Team[i].level,j);
                    }   
                    hero.Team[i].calculateStat(); 
                   
                    PokemonOfHeroShowed(hero.Team[i]);
                    System.out.print(hero.Team[i].getName()+" gained\n"+ExpEarned+" EXP.Points!");
                    
                    hero.Team[i]=hero.Team[i].evolution(hero.Team[i]);
                    
                                      
                    
                    //Learn new moves
                    if((hero.Team[i].learnNewMoves()!=null)&&(hero.Team[i].inBattle)&&(hero.Team[i].HP!=0)){
                        for(int g=0;g<4;g++){
                            if(hero.Team[i].Move[g]!=null){
                                FullMoves++;
                            }
                            if(hero.Team[i].LevelUped==false){
                               FullMoves=5;
                            }   
                        }                          
                        if(FullMoves==4){
                            System.out.println("\n"+hero.Team[i].getName()+" wants to learn "+hero.Team[i].learnNewMoves().name+" but he already has four moves");
                            System.out.println("Do you want ot exchange one move?  (Y/N)");
                            String whetherChangeMove=keyboard.nextLine();
                            if(whetherChangeMove.equalsIgnoreCase("Y")){
                                for(int g=0;g<4;g++){
                                    if(hero.Team[i].Move[g]!=null){
                                        System.out.println(g+1+" :"+hero.Team[i].Move[g].name);
                                    }
                                }
                                System.out.println("Which one would you like to exchange ?");
                                int moveToChange=keyboard.nextInt();
                                hero.Team[i].Move[moveToChange-1]=hero.Team[i].learnNewMoves(); 
                            }      
                        }
                        else if(FullMoves<4){
                            System.out.println(hero.Team[i].getName()+"learned "+hero.Team[i].learnNewMoves().name);
                            hero.Team[i].Move[FullMoves]=hero.Team[i].learnNewMoves();
                        }
                    }
                    FullMoves=0;
                    hero.Team[i].inBattle=false;
                    hero.Team[i].LevelUped=false;               
                }
            }
        }   
   
    public void PokemonOfHeroShowed(Pokemon pokemonOfHero){
        System.out.println("\n\n\n\n\t   "+pokemonOfHero.getName());    
        System.out.println("\t\t\t\t _______________________");
        System.out.println("\t\t\t\t| "+pokemonOfHero.baseStats.nameOfPokemon+"        "+"Lv"+pokemonOfHero.level);
        System.out.print("\t\t\t\t|\tHP");
        showHpLine(pokemonOfHero,pokemonOfHero.HP);
        System.out.println("\t");
        System.out.println("\t\t\t\t|\t\t  "+pokemonOfHero.HP+"/"+pokemonOfHero.stats.HP);
        System.out.println("\t\t\t\t ----------------------- ");                 
    }
    
    
    public void showHpLine(Pokemon pokemonOfhero,int HP) {
        for(int i=0;i<HP*10/pokemonOfhero.stats.HP;i++){
           System.out.print("-");
        }
        System.out.print(" ");
    }
}

