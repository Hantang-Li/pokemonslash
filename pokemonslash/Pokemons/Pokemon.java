
package pokemonslash.Pokemons;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import pokemonslash.Move;
import pokemonslash.Pokemons.SampleMoves.*;


public abstract class Pokemon  implements Serializable {
    //variables
    public int maxhp, HP, level;
    protected String name;
    public String gender;
    public PokemonBaseStats baseStats;
    public PokemonStat EV;
    public PokemonStat IV;   
    public  PokemonStat stats;
    public String type1;
    public String type2;
    public  Move[] Move=new Move[4];
    public boolean inBattle = false;
    public boolean LevelUped=false;
            
    public BattleType defence = new BattleType(0,0);
    public BattleType attack = new BattleType(0,0);
    public BattleType speed = new BattleType(0,0);
    public BattleType specialAttack = new BattleType(0,0);
    public BattleType specialDefence = new BattleType(0,0);
    public BattleType evasion = new BattleType(0,0);
    public BattleType accuracy = new BattleType(0,0);
   
//changed constructor to inherit baseStats from subclass
    public Pokemon(String name, int level, PokemonBaseStats baseStats) {
        //constructor
        this.name = name;
        this.level = level;
        Random rng = new Random();
        IV = new PokemonStat(0,rng.nextInt(16),rng.nextInt(16),rng.nextInt(16),rng.nextInt(16));
        EV = new PokemonStat();
        stats = new PokemonStat();
        this.baseStats = baseStats;
        calculateStat();    
        defence = new BattleType((double)stats.defense,0);
        attack = new BattleType((double)stats.attack,0);
        speed = new BattleType((double)stats.speed,0);
        specialAttack = new BattleType((double)stats.special,0);
        specialDefence = new BattleType((double)stats.special,0); 
        evasion = new BattleType(100,0);
        accuracy = new BattleType(100,0);
        HP=stats.HP;
        maxhp = stats.HP;
    } 
    
    public void restoreAllBattleType(){
        defence = new BattleType((double)stats.defense,0);
        attack = new BattleType((double)stats.attack,0);
        speed = new BattleType((double)stats.speed,0);
        specialAttack = new BattleType((double)stats.special,0);
        specialDefence = new BattleType((double)stats.special,0); 
    }
    
    
    public void changeMoves(Move newMove) {   
        for (int i=0;i<4;i++){
            if ((this.Move[i]==null) && (newMove!=null)){
                this.Move[i] = newMove;
                newMove = null;
            }
        }   
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public PokemonBaseStats getBaseStats() {
        return baseStats;
    }

    public PokemonStat getStats() {
        return stats;
    }
    
    
    public String getName() {
        return name;
    }

    public BattleType getAttack() {
        return attack;
    }

    public void setAttack(BattleType attack) {
        this.attack = attack;
    }

    public BattleType getDefence() {
        return defence;
    }

    public void setDefence(BattleType defence) {
        this.defence = defence;
    }
    
    
    
    public void rename(){
        Scanner keyboard = new Scanner(System.in);
        String choice;
        String newName;
        System.out.println("Would you like to rename your pokemon? ");
        choice = keyboard.nextLine();
        if (choice.equalsIgnoreCase("yes")){
            System.out.println("What would you like to name this Pokemon to? ");
            newName = keyboard.nextLine();
            this.name = newName; 
        }
    }
    
    public void calculateStat() {//PokemonStat EV, PokemonStat IV, int level
        stats.HP = ((int)((IV.HP+baseStats.HP)*2+((Math.sqrt(EV.HP)/4)))*level/50)+level+10;
        stats.attack = (((int)((IV.attack+baseStats.attack)*2+((Math.sqrt(EV.attack)/4)))*level)/50)+5;
        stats.defense = (((int)((IV.defense+baseStats.defense )*2+((Math.sqrt(EV.defense)/4)))*level)/50)+5;
        stats.special = (((int)((IV.special+baseStats.special)*2+((Math.sqrt(EV.special)/4)))*level)/50)+5;
        stats.speed = (((int)((IV.speed+baseStats.speed)*2+((Math.sqrt(EV.speed)/4)))*level)/50)+5;
    }
    
   
    public Pokemon(Pokemon oldPokemon) {
        this.name = oldPokemon.name;
        this.IV = oldPokemon.IV;
        this.EV = oldPokemon.EV;
        this.level = oldPokemon.level;
        stats = new PokemonStat();
    } 

    @Override
    public String toString() {
        return "Pokemon{" + "name=" + name + ", level=" + level + ", base=" + baseStats + ", EV=" + EV + ", IV=" + IV + ", stats=" + stats + ", baseStats=" + baseStats ;
    }
    //calculate exp range
    private int calculateExpEnd(int level) {
        int exp =0;   
        if (baseStats.expSpeed == 1){
            exp = ((6/5)*level*level*level)-(15*level*level)+(100*level)-140;
        }
        else if (baseStats.expSpeed == 2){
            exp = level*level*level;
        }
        else if (baseStats.expSpeed == 3){
            exp = (4*level*level*level)/5;
        }
        else if (baseStats.expSpeed == 4){
            exp = (5*level*level*level)/4;
        }
        return exp;
    }
    
    
    //EVERY time u beat a pokemon
    public int calculateGainExpA1(int baseExpYieldOfFaintedPokemon,int LevelOfFaintedPokemon,int numberOfUnfaintedPokemon ) {
        return (1*1*baseExpYieldOfFaintedPokemon*1*LevelOfFaintedPokemon*1*1*1)/(7*numberOfUnfaintedPokemon);
    }
    //trainer
    public int calculateGainExpA2(int baseExpYieldOfFaintedPokemon,int LevelOfFaintedPokemon,int numberOfUnfaintedPokemon) {
        return (int)(1.5*1*baseExpYieldOfFaintedPokemon*1*LevelOfFaintedPokemon*1*1*1)/(7*numberOfUnfaintedPokemon);
    }
   
    //wild
    public int levelUp1(int baseExpYieldOfFaintedPokemon,int LevelOfFaintedPokemon,int numberOfUnfaintedPokemon) {
        if (calculateGainExpA1(baseExpYieldOfFaintedPokemon, LevelOfFaintedPokemon, numberOfUnfaintedPokemon) >= calculateExpEnd(level)) {
            level++;  
            LevelUped=true;
        }
        return level;
    }
    
    public int levelUp2(int baseExpYieldOfFaintedPokemon,int LevelOfFaintedPokemon,int numberOfUnfaintedPokemon) {   
        if (calculateGainExpA2(baseExpYieldOfFaintedPokemon, LevelOfFaintedPokemon, numberOfUnfaintedPokemon) >= calculateExpEnd(level)) {
            level++;
            LevelUped=true;
        }
        return level;
    }
    
    public abstract Pokemon evolution(Pokemon oldPokemon);
    
    public abstract Move learnNewMoves();
    
}
