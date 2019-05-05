                package pokemonslash;

import java.io.Serializable;
import java.util.Scanner;
import pokemonslash.Items.*;
import pokemonslash.Pokemons.*;

public class GameCharacter implements Serializable {
    //declear variables
    private String name;
    //private char mapSymbol;
    public MapTile currentTile;
    public String message;
    public int progress;
    private int money;
    //private int fightTrainer;
    public String currentmap;
    public String deadmap;
    public Hpup hpm;
    public Ether ppm;
    public Pokeball pokeball;
    public Boat boat;
    public boolean fight;
    public Pokemon[] Team = new Pokemon[6];
    public Pokemon[] pc = new Pokemon[30];

    public GameCharacter(String name) {
        deadmap = "HouseA";
        fight = true;
        this.name = name;
        hpm = new Hpup();
        ppm = new Ether();
        pokeball = new Pokeball();
        boat = new Boat();
        progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addPokemon(Pokemon newPokemon) {
        for (int i = 0; i < 6; i++) {
            if ((this.Team[i] == null) && (newPokemon != null)) {
                this.Team[i] = newPokemon;
                newPokemon = null;
            }
        }
    }

    public void viewPokémon() {
        int i;
        for (i = 0; i < 6; i++) {
            if (Team[i] != null) {
                System.out.println(i + 1 + " . " + Team[i].getBaseStats().nameOfPokemon + "; name: " + Team[i].getName() + "; Lv: " + Team[i].level);
                System.out.println("currentHp=" + Team[i].HP + "\n" + Team[i].getStats().toString());//print stat, see toString method in PokemonStat
                int j;
                for (j = 0; j < 4; j++) {
                    if(Team[i].Move[j] != null){
                    System.out.println("Pokemon moves: " + Team[i].Move[j].name);
                    }
                }
            } else {
                System.out.println(i + 1 + " . no Pokémon here");
            }
        }
    }

    public void viewPc() {
        int i;
        for (i = 0; i < 30; i++) {

            if (pc[i] != null) {
                System.out.println(i + 1 + " . " + pc[i].getBaseStats().nameOfPokemon + "; name: " + pc[i].getName() + "; Lv: " + pc[i].level);
                System.out.println("currentHp=" + pc[i].HP + "\n" + Team[i].getStats().toString());//print stat, see toString method in PokemonStat
            } else {
                System.out.println(i + 1 + " . no Pokémon here");
            }
        }
    }

    public void switchPokemon() {
        Scanner keyboard = new Scanner(System.in);
        int i, choice, choiceTwo;
        Pokemon bufferPokemon;

        do {
            viewPokémon();
            System.out.println("Which pokemon do you want to switch?");
            choice = keyboard.nextInt();
            System.out.println("What position do you want to put this pokemon to?");
            choiceTwo = keyboard.nextInt();
            if (choice < 1 || Team[choice - 1] == null || choiceTwo < 1 || Team[choiceTwo - 1] == null) {
                System.out.println("Please enter the correct number");
            } else {
                bufferPokemon = Team[choiceTwo - 1];
                Team[choiceTwo - 1] = Team[choice - 1];
                Team[choice - 1] = bufferPokemon;
            }
        } while (choice < 1 || choice > 6);

    }

    public boolean checkpokemon() {
        for (int k = 0; k < 6; k++) {
            if (Team[k] != null) {
                if (Team[k].HP > 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
