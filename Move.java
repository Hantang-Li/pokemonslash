
package pokemonslash;
import java.io.Serializable;
import pokemonslash.Pokemons.Pokemon;
import pokemonslash.Battle.*;

abstract public class Move  implements Serializable {
    
   public boolean isAttack;
    public boolean isStatusEffect;
    public boolean isSpecial;
    public int power;
    public String name;
    public int maxpp;
    public int pp;
    public int accuracy;
    double damage;
    public String type;
    public double[][]typeChart=new double[16][16] ;
    
    public Move() {

    }
    abstract public void useMove(Pokemon attacker, Pokemon defender);
    
    public void dealDamage(Pokemon attacker, Pokemon defender) {
        double modifier = calculateModifier(attacker,defender);
        //special attack
        if (isSpecial) {
            damage = (int) Math.round((((((2 * attacker.level) / 5.0) + 2) * power * ((attacker.specialAttack.getValue()* 1.0) / (defender.specialDefence.getValue() * 1.0)) / 50.0) + 2) * modifier);
        } 
        //phsical attack
        else { 
            damage = (int) Math.round((((((2 * attacker.level) / 5.0) + 2) * power * ((attacker.attack.getValue() * 1.0) / (defender.defence.getValue() * 1.0)) / 50.0) + 2) * modifier);
        } 
        defender.HP -= damage;
        pp--;
        System.out.println(attacker.getName() + " useed " + name+" \nfor " + damage + " damage!\n\n");
    }

    public void changeStats(Pokemon releaser, Pokemon target, int stageChange, String stats) {
        pp--;
        if (stats.equalsIgnoreCase("Speed")) {
            target.speed.changeStage(stageChange);
        } else if (stats.equalsIgnoreCase("Attack")) {
            target.attack.changeStage(stageChange);
        } else if (stats.equalsIgnoreCase("Defence")) {
            target.defence.changeStage(stageChange);
        } else if (stats.equalsIgnoreCase("Special attack")) {
            target.specialAttack.changeStage(stageChange);
        } else if (stats.equalsIgnoreCase("Special defence")) {
            target.specialDefence.changeStage(stageChange);
        } else {
            
        }
        System.out.println(releaser.getName() + " uses " + name + "\nto change " + target.getName() + "'s  " +stats + " stage for"+stageChange+"\n\n");
    }
    

    public double calculateModifier(Pokemon attacker, Pokemon defender) {
        TypeChart();
        double modifier=1.0;
        if((attacker.type1.equalsIgnoreCase(type))||(attacker.type2.equalsIgnoreCase(type))){
            modifier=modifier*1.5; 
            System.out.println("same type (*1.5)");
        }
        modifier=modifier*FindValue(type,defender.type1)*FindValue(type,defender.type2); 
        if(FindValue(type,defender.type1)*FindValue(type,defender.type2)==0){
            System.out.println("ineffective");
        }
        else if((FindValue(type,defender.type1)*FindValue(type,defender.type2)==0.25)||(FindValue(type,defender.type1)*FindValue(type,defender.type2)==0.5)){
            System.out.println("not very effective");
        }
        else if((FindValue(type,defender.type1)*FindValue(type,defender.type2)==1)){
            
        }
        else if((FindValue(type,defender.type1)*FindValue(type,defender.type2)==2)||(FindValue(type,defender.type1)*FindValue(type,defender.type2)==4)){
            System.out.println("super effective");
        }
        return modifier;
    }   
    
    public void TypeChart() {
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                typeChart[i][j]=1;
            }
        }
        for(int i=0;i<16;i++){
           typeChart[i][15]=1;
        }
        for(int j=0;j<16;j++){
           typeChart[15][j]=1;
        }
        
        typeChart[0][5]=0.5;
        typeChart[0][7]=0;
        typeChart[1][0]=2;
        typeChart[1][2]=0.5;
        typeChart[1][3]=0.5;
        typeChart[1][5]=2;
        typeChart[1][6]=0.5;
        typeChart[1][7]=0;
        typeChart[1][12]=0.5;
        typeChart[1][13]=2;
        typeChart[2][1]=2;
        typeChart[2][5]=0.5;
        typeChart[2][6]=2;
        typeChart[2][10]=2;
        typeChart[2][11]=0.5;
        typeChart[8][5]=0.5;
        typeChart[8][6]=2;
        typeChart[8][8]=0.5;
        typeChart[8][9]=0.5;
        typeChart[8][10]=2;
        typeChart[8][12]=2;
        typeChart[8][12]=0.5;
    }
    
    public double FindValue(String attakerType,String defenderType) {
        return typeChart[FindChart(attakerType)][FindChart(defenderType)];    
    }
    
    public int FindChart(String Type){
        if(Type.equalsIgnoreCase("Normal")){
            return 0;
        }
        else if(Type.equalsIgnoreCase("Fight")){
            return 1;
        }
        else if(Type.equalsIgnoreCase("Flying")){
            return 2;
        }
        else if(Type.equalsIgnoreCase("Poison")){
            return 3;
        }
        else if(Type.equalsIgnoreCase("Ground")){
            return 4;
        }
        else if(Type.equalsIgnoreCase("Rock")){
            return 5;
        }
        else if(Type.equalsIgnoreCase("Bug")){
            return 6;
        }
        else if(Type.equalsIgnoreCase("Ghost")){
            return 7;
        }
        else if(Type.equalsIgnoreCase("Fire")){
            return 8;
        }
        else if(Type.equalsIgnoreCase("Water")){
           return 9;
        }
        else if(Type.equalsIgnoreCase("Grass")){
           return 10;
        }
        else if(Type.equalsIgnoreCase("Electr")){
           return 11;
        }
        else if(Type.equalsIgnoreCase("Psvchc")){
            return 12;
        } 
        else if(Type.equalsIgnoreCase("Ice")){
            return 13;
        } 
        else if(Type.equalsIgnoreCase("Dragon")){
           return 14;
        } 
        else{
           return 15;
        }
    }
    
    
}
