
package pokemonslash.Pokemons;

import java.io.Serializable;

public class BattleType implements Serializable {

    double value;
    int stage;
    
    BattleType(double value, int stage) {
        this.value=value;
        this.stage=stage;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
    
    public void changeStage(int stageChange) {
        this.stage = stage+stageChange;
        this.value =value*calValue(stage);
    }
    

    public double calValue(int stage) {
        if (stage == -1) {
            return 0.66;
        } else if (stage == -2) {
            return 0.5;
        } else if (stage == -3) {
            return 0.4;
        } else if (stage == -4) {
            return 0.33;
        } else if (stage == -5) {
            return 0.28;
        } else if (stage == -6) {
            return 0.25;
        } else if (stage == 1) {
            return 1.5;
        } else if (stage == 2) {
            return 2.0;
        } else if (stage == 3) {
            return 2.5;
        } else if (stage == 4) {
            return 3.0;
        } else if (stage == 5) {
            return 3.5;
        } else if (stage == 6) {
            return 4.0;
        } else {
            return 1.0;
        }
    }
    
}
