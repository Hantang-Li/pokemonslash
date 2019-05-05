package pokemonslash;

import java.io.Serializable;

public class MapTile  implements Serializable {
    int x,y;
    public MapSymbol ms;
    public NotPlayerC resident;
    public String destination;
    int communicationMethod;
    public MapTile(int y, int x, MapSymbol ms) {
        this.ms = ms;
        this.x = x;
        this.y = y;
        this.resident = null;
    }
    
    public MapTile(int y, int x, MapSymbol ms, String destination, int communicationMethod) {
        this.ms = ms;
        this.x = x;
        this.y = y;
        this.destination = destination;
        this.communicationMethod = communicationMethod;
        this.resident = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}

//MapTile Dest