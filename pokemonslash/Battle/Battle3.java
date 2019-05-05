
package pokemonslash.Battle;

import java.util.Random;
import java.util.Scanner;
import pokemonslash.GameCharacter;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Pokemons.SampleMoves.Scratch;
import pokemonslash.Pokemons.SampleMoves.Tackle;
import pokemonslash.Pokemons.SampleMoves.TailWhip;


public class Battle3 {
    public GameCharacter hero;
    public GameCharacter trainer;
    public Pokemon wildPokemon;
    public boolean isBattleOver=false;
    public int TimesToChooseEscape=0;
    
    public Action heroaction= new Action();
    public Action traineraction= new Action();
    public LevelUp LevelUp= new LevelUp();
    public UseItems UseItems= new UseItems();
    public SwicthPokemon SwicthPokemon= new SwicthPokemon();
    public Escape Escape= new Escape();
    public UseMoves UseMoves= new UseMoves();

    Scanner keyboard = new Scanner(System.in); 
    
    
    public  Battle3(GameCharacter hero, Pokemon wildPokemon) {
        this.hero = hero;
        wildPokemon.Move[0]=new TailWhip();
        wildPokemon.Move[1]=new Scratch();
        wildPokemon.Move[2]=new Tackle();
        wildPokemon.Move[3]=new Tackle();
        trainer =new GameCharacter(" ");
        this.wildPokemon=wildPokemon;
        trainer.addPokemon(wildPokemon);
        //No Pokemon!!!!!!
        //Fight with trainter   
        isBattleOver=false;
        TimesToChooseEscape=0;
        if(HeroCanStartBattle(hero)){
            HeroShowedWithWildPokemon(hero,trainer.Team[0],hero.Team[0]);
            BattleChoice(hero.Team[0],trainer.Team[0]);
        } 
    }
    
    public void HeroShowedWithWildPokemon(GameCharacter hero,Pokemon wildPokemon,Pokemon pokemonOfHero){
        String continueButton;
        WildPokemonAppear(wildPokemon);
           
        System.out.println("\t\t"+hero.getName());
        System.out.println(" Wild "+wildPokemon.getName()+" appeared!");
        System.out.println(" Go "+pokemonOfHero.getName()+" !\n\n");
        
        System.out.println("\n\tPress any button to continue!");
        continueButton=keyboard.nextLine();
        System.out.print("\n");
    }   
    
    public void WildPokemonAppear(Pokemon wildpokemon){
        System.out.println(" _______________________");
        System.out.println("| "+wildpokemon.baseStats.nameOfPokemon+"      "+"Lv"+wildpokemon.level);//+Tp.gender
        System.out.print("|\tHP");
        showHpLine(wildpokemon,wildpokemon.HP);
        System.out.println("\t");
        System.out.println(" ----------------------- ");
        System.out.print("\t\t\t\t\t"+wildpokemon.getName()+"\n\n");  
    }
    

    public  Battle3(GameCharacter hero, GameCharacter trainer) {
        this.hero = hero;
        this.trainer = trainer;
        isBattleOver=false;
        TimesToChooseEscape=0;
        
        if(HeroCanStartBattle(hero)){
            HeroShowedWithTrainer(hero,trainer);
            BattleChoice(hero.Team[0],trainer.Team[0]);
        } 
    }
    
    public void TrainerShowed(GameCharacter trainer){   
        System.out.print("\n\t");
        for(int i=0;i<6;i++){
            if(trainer.Team[i]!=null){
                System.out.print("*");
            }
            else{
                System.out.print("o");
            }
        }
        System.out.println();
        System.out.println("-----------------");
        System.out.println("                   \t\t"+trainer.getName());
    }
    
    
    public void HeroShowedWithTrainer(GameCharacter hero,GameCharacter trainer){
        String continueButton;
        TrainerShowed(trainer);
           
        System.out.println("\n\n\t\t"+hero.getName());
        System.out.print("\t\t\t\t ");
        for(int i=0;i<6;i++){
            if(trainer.Team[i]!=null){
                System.out.print("*");
            }
            else{
                System.out.print("o");
            }
        }
        System.out.println();
        System.out.println("\t\t\t\t-----------------");              
        System.out.println("\n "+trainer.getName()+" TRAINER MAY \n would like to battle!");
        System.out.println(" Go "+hero.Team[0].getName()+" !\n\n");
        
        System.out.println("\n\tPress any button to continue!");
        continueButton=keyboard.nextLine();
        System.out.print("\n");
    }
    
    
    
    
    
   
    
    public void MovesMenu(Pokemon pokemonOfHero,Pokemon opponent){
        
        if(isBattleOver==false){
            String choice;
        int choice2=0;
        do{        
            for(int i=0;i<4;i++){
                if((i==0)||(i==2)){
                    System.out.print("|  ("+(i+1)+")");
                    if(pokemonOfHero.Move[i]==null){
                         System.out.print("--\t\t");
                    }
                    else{
                        System.out.print(pokemonOfHero.Move[i].name+"\t\t");
                    }
                }
                else{
                    System.out.print("  ("+(i+1)+")");
                    if(pokemonOfHero.Move[i]==null){
                        System.out.println("--\t\t|");
                    }
                    else{
                        System.out.println(pokemonOfHero.Move[i].name+"\t|");
                    }
                }
            }
            choice=keyboard.nextLine();
            if(choice.equals("1")){
                choice2=0;
            }
            else if(choice.equals("2")){
                choice2=1;
            }
            else if(choice.equals("3")){
                choice2=2;
            }
            else if(choice.equals("4")){
                choice2=3;
            }
            else if(choice.equals("5")){
                choice2=5;
            }  
        }while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5"))||((choice.equals("5")==false)&&(pokemonOfHero.Move[choice2]==null)));
       
        
        if(choice2==5){
            BattleChoice(pokemonOfHero,opponent);
        }
        else{
            for(int i=0;i<4;i++){
                if((i==0)||(i==2)){
                    System.out.print("|  ("+(i+1)+")");
                    if(pokemonOfHero.Move[i]==null){
                         System.out.print("--\t\t");
                    }
                    else{
                        System.out.print(pokemonOfHero.Move[i].name+"\t\t");
                    }
                }
                else if(i==1){
                    System.out.print("  (2)");
                    if(pokemonOfHero.Move[i]==null){
                        System.out.print("--\t\t|");
                    }
                    else{
                        System.out.print(pokemonOfHero.Move[i].name+"\t|");
                    }
                    System.out.println("| PP  "+pokemonOfHero.Move[choice2].pp+"/"+pokemonOfHero.Move[choice2].maxpp);
                }
                else if(i==3){
                    System.out.print("  (4)");
                    if(pokemonOfHero.Move[i]==null){
                        System.out.print("--\t\t|");
                    }
                    else{
                        System.out.print(pokemonOfHero.Move[i].name+"\t|");
                    }
                    System.out.println("| TYPE/"+pokemonOfHero.Move[choice2].type);
                }
            }
            System.out.println("                    Use "+pokemonOfHero.Move[choice2].name+" Y/N");
        
            choice=keyboard.nextLine();
            if(choice.compareToIgnoreCase("Y")==0){
                heroaction.numberOfMoves=choice2+1;
            }
            else{
                MovesMenu(pokemonOfHero,opponent); 
            }     
        }       
            
        }
        
        
        
    }  
    
    
    
    
    public void showHpLine(Pokemon wildpokemon,int HP) {
        for(int i=0;i<HP*10/wildpokemon.stats.HP;i++){
           System.out.print("-");
        }
        System.out.print(" ");
    }
    
      
   
    public void BattleChoice(Pokemon pokemonOfHero,Pokemon opponent){
        if(isBattleOver==false){
         WildPokemonAppear(opponent);
        PokemonOfHeroShowed(pokemonOfHero);
        String choice=Menu(pokemonOfHero);
        traineraction.sequence=3;
        pokemonOfHero.inBattle=true;
        
        if(choice.equals("1")){
            TimesToChooseEscape=0;
            WildPokemonAppear(opponent);
            PokemonOfHeroShowed(pokemonOfHero);
            heroaction=UseMoves;
            MovesMenu(pokemonOfHero,opponent);
            BattleSequence(pokemonOfHero,opponent,choice);
        }      
        else if(choice.equals("2")){  
            UseItems.bag(pokemonOfHero,wildPokemon,hero,opponent);
            heroaction=UseItems;
            if(UseItems.choiceOfItem.equalsIgnoreCase("4")){
                BattleChoice(pokemonOfHero,opponent);
            }
            else if((hero.hpm.numberOfPokemon!=7)&&(hero.ppm.numberOfPokemon!=7)&&(hero.pokeball.numberOfPokemon!=7)){
                BattleSequence(pokemonOfHero,opponent,choice); 
            } 
            else{
                BattleChoice(pokemonOfHero,opponent);
            }
        }
        else if(choice.equals("3")){   
            SwicthPokemon.ChoseWhichOneToSwitch(hero);
            heroaction=SwicthPokemon; 
            if(SwicthPokemon.numberOfPokemonToSwitch!=1){
                BattleSequence(pokemonOfHero,opponent,choice);
            }
            else{
                BattleChoice(pokemonOfHero,opponent);
            }
        }
        else{
            TimesToChooseEscape++;
            heroaction.sequence=0;
            BattleSequence(pokemonOfHero,opponent,choice);
        }   
                       
        }
        
    }
    
    public void OpponentUseMoves(Pokemon pokemonOfHero,Pokemon opponent){
        String continueButton;
        WildPokemonAppear(opponent);
        PokemonOfHeroShowed(pokemonOfHero);
        traineraction.numberOfMoves=OpponentChoice(opponent);
        UseMoves.UseMoves(opponent, pokemonOfHero,traineraction.numberOfMoves); 
        System.out.println("\n\tPress any button to continue!");
        continueButton=keyboard.nextLine();
        System.out.print("\n");
    } 
    
    public void PokemonOfHeroUseMoves(Pokemon pokemonOfHero,Pokemon opponent){
        WildPokemonAppear(opponent);
        PokemonOfHeroShowed(pokemonOfHero);
        UseMoves.UseMoves(pokemonOfHero, opponent,heroaction.numberOfMoves); 
    }
    
   
    public void BattleSequence(Pokemon pokemonOfHero,Pokemon opponent,String choiceOfHero){
        if(isBattleOver==false){
            if(heroaction.sequence<traineraction.sequence){   
            if(choiceOfHero.equals("1")){     
                PokemonOfHeroUseMoves(pokemonOfHero,opponent);
            }      
            else if(choiceOfHero.equals("2")){ 
                UseItems.bagUseItems(UseItems.choiceOfItem,hero);  
            }
            else if(choiceOfHero.equals("3")){
                SwicthPokemon.SwitchPokemon(hero);
                WildPokemonAppear(opponent);
                PokemonOfHeroShowed(hero.Team[0]);
                pokemonOfHero=hero.Team[0];
            }
            else{
                if(wildPokemon==null){
                    Escape.EscapeFailed();
                    BattleChoice(pokemonOfHero,opponent);
                }
                else{
                    if(pokemonOfHero.speed.getValue()*32/opponent.speed.getValue()+30*TimesToChooseEscape>255){
                        isBattleOver=true;
                        Escape.Escape();
                        for(int k=0;k<6;k++){
                            if((hero.Team[k]!=null)&&(hero.Team[k].HP!=0)){
                                hero.Team[k].restoreAllBattleType();
                            }
                        }   
                    }
                    else{
                        Random rng = new Random();
                        if(rng.nextInt(256)< pokemonOfHero.speed.getValue()*32/(opponent.speed.getValue()/4)+30*TimesToChooseEscape){
                                isBattleOver=true;
                                Escape.Escape();
                                for(int k=0;k<6;k++){
                                    if((hero.Team[k]!=null)&&(hero.Team[k].HP!=0)){
                                        hero.Team[k].restoreAllBattleType();
                                    }
                                }       
                        }
                        else{
                            System.out.print("Failed to run!\n\n");
                            BattleChoice(pokemonOfHero,opponent);
                        }
                    }
                    
                }
            }     
            if(hero.pokeball.PokemonCatched){
                choiceOfHero="4";
                hero.pokeball.PokemonCatched=false;
            }
            
            if((opponent.HP>0)&&(choiceOfHero.equals("4") == false)){
                OpponentUseMoves(hero.Team[0],opponent);  
            }  
        } 
        else if(heroaction.sequence==traineraction.sequence){ 
            if(pokemonOfHero.speed.getValue()>opponent.speed.getValue()){  
                PokemonOfHeroUseMoves(pokemonOfHero,opponent);
                if(opponent.HP>0){
                    OpponentUseMoves(pokemonOfHero,opponent);    
                }       
            }   
            else if(pokemonOfHero.speed.getValue()<opponent.speed.getValue()){
                OpponentUseMoves(pokemonOfHero,opponent);
                if(pokemonOfHero.HP>0){
                    PokemonOfHeroUseMoves(pokemonOfHero,opponent);
                }   
            }
            else{
                if(getAccuracy()>50){
                    OpponentUseMoves(pokemonOfHero,opponent);
                    if(pokemonOfHero.HP>0){
                        PokemonOfHeroUseMoves(pokemonOfHero,opponent);
                    }   
                }
            }
        }
        

        if(choiceOfHero.equals("4")==false){
            if(opponent.HP>0){
                if(hero.Team[0].HP>0){
                    BattleChoice(hero.Team[0],opponent);
                }
                else{
                    int i=-1;
                    do{
                        i++;
                    }while(((hero.Team[i]!=null)&&(hero.Team[i].HP==0)));
                    if(hero.Team[i]==null){
                        System.out.println("You failed!");
                        isBattleOver=true;
                    }
                    else{
                        System.out.println("Switch anotehr Pokemon");
                        SwicthPokemon.ChoseWhichOneToSwitch(hero);
                        SwicthPokemon.SwitchPokemon(hero);
                        BattleChoice(hero.Team[0],opponent);
                }
            }  
            }
            else{
                if(wildPokemon==null){
                    int i=-1;
                    do{
                        i++;
                    }while(((trainer.Team[i]!=null)&&(trainer.Team[i].HP==0)));
                    if(trainer.Team[i]==null){
                        System.out.println("You Won!");  
                        isBattleOver=true;
                        LevelUp.LevelUp(hero, trainer,wildPokemon);
                        for(int k=0;k<6;k++){
                            if((hero.Team[k]!=null)&&(hero.Team[k].HP!=0)){
                                hero.Team[k].restoreAllBattleType();
                            }
                        }
                    }
                    else{
                        BattleChoice(hero.Team[0],trainer.Team[i]);
                    }        
                }
                else{
                    System.out.println("You Won!");
                    isBattleOver=true;
                    LevelUp.LevelUp(hero,trainer,wildPokemon);         
                    for(int k=0;k<6;k++){
                        if((hero.Team[k]!=null)&&(hero.Team[k].HP!=0)){
                            hero.Team[k].restoreAllBattleType();
                        }
                    }
                }
            }
        }           
        }
        
        
    }
    
    public String Menu(Pokemon pokemonOfHero) {     
        String choice;
        do{        
            System.out.println("|  (1)FIGHT\t\t(2)BAG        |  What will ");
            System.out.println("|  (3)POKEMON\t\t(4)RUN        |  "+pokemonOfHero.getName()+" do?");  
            choice=keyboard.nextLine();
        }while(!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")));
        return choice;
    }
     
    public void PokemonOfHeroShowed(Pokemon pokemonOfHero){
        System.out.println("\t   "+pokemonOfHero.getName());    
        System.out.println("\t\t\t\t _______________________");
        System.out.println("\t\t\t\t| "+pokemonOfHero.baseStats.nameOfPokemon+"        "+"Lv"+pokemonOfHero.level);
        System.out.print("\t\t\t\t|\tHP");
        showHpLine(pokemonOfHero,pokemonOfHero.HP);
        System.out.println("\t");
        System.out.println("\t\t\t\t|\t\t  "+pokemonOfHero.HP+"/"+pokemonOfHero.stats.HP);
        System.out.println("\t\t\t\t ----------------------- ");                 
    }
    
  
    
    public void fight(Pokemon attacker,Pokemon defender,int choice) {    
        if(attacker.Move[choice-1].accuracy*attacker.accuracy.getValue()/defender.evasion.getValue()>=getAccuracy()){  
            attacker.Move[choice-1].useMove(attacker,defender);
            if(defender.HP<=0){
                defender.HP=0;   
                System.out.println(defender.getName()+"failed !");
            } 
        }  
        else{
            System.out.println(attacker.getName()+"'s move missed....");
        }    
    }
    
    public int getAccuracy() {
        Random rng = new Random();
        return rng.nextInt(100)+1;  
    }
    
   
    
    public int OpponentChoice(Pokemon opponent) { 
        Random rng = new Random();
        int choice;
        do{
           choice=rng.nextInt(4)+1;  
        }while(opponent.Move[choice-1]==null);
        return choice;
    }

    private boolean HeroCanStartBattle(GameCharacter hero) {
        int i=-1;
        do{
            i++;
        }while(((hero.Team[i]!=null)&&(hero.Team[i].HP==0)));
        if(hero.Team[i]==null){
            System.out.println("You can not start a battle!");
            return false;
        }
        else{
            return true;
        }
    }
    
    
    
}
