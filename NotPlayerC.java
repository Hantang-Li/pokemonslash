
package pokemonslash;

import java.io.Serializable;

//npc
public class NotPlayerC extends GameCharacter  implements Serializable {

    public NotPlayerC(String name) {
        super(name);
    }
    public NotPlayerC(String name, String message) {
        super(name);
        this.message = message;
    }
    public MapTile getCurrentTile() {
        return currentTile;
    }

    public String getMessage(){
        return this.message;
    }

}
