package pokemonslash.Battle;

import java.util.Scanner;
import pokemonslash.GameCharacter;
import pokemonslash.Items.Ether;
import pokemonslash.Items.Hpup;
import pokemonslash.Items.Pokeball;
import pokemonslash.Pokemons.Pokemon;

public class UseItems extends Action {

    Scanner keyboard = new Scanner(System.in); 
    Pokemon wildPokemon,opponent;
    
    
    public void bag(Pokemon pokemonOfHero, Pokemon wildPokemon, GameCharacter hero,Pokemon opponent) {
        this.wildPokemon=wildPokemon;
        this.opponent=opponent;
        
        sequence=2;
        System.out.println("       ____");
        System.out.println("      /    \\");
        System.out.println("     _|____|_");
        System.out.println("   /  |    |  \\ ");
        System.out.println("  /            \\");
        System.out.println("  |  1.pokeball|");
        System.out.println("  |  --------  |");
        System.out.println("  |  2.Ether   |");
        System.out.println("  |  --------  |");
        System.out.println("  |  3.Hpup    |");
        System.out.println("  |  --------  |");
        System.out.println("  ______________ ");
        String choice;
        do {
            System.out.println("Which item do you want to use?(exit enter 4)");
            choice = keyboard.nextLine();
            switch (choice) {
                case "1":
                    hero.pokeball.choiceItems(hero);
                    break;
                case "2":
                    hero.ppm.choiceItems(hero);
                    break;
                case "3":
                    hero.hpm.choiceItems(hero);
                    break;
                case "4":
                    break;
            }
        } while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")));
        choiceOfItem = choice;
    }

    public void bagUseItems(String choice, GameCharacter hero) {
        switch (choice) {
            case "1":
                hero.pokeball.useItems(hero, wildPokemon, opponent);
                break;
            case "2":
                if (hero.ppm.numberOfPokemon < 7) {
                    hero.ppm.useItems(hero.Team[hero.ppm.numberOfPokemon - 1]);
                    break;
                }
                break;
            case "3":
                if (hero.hpm.numberOfPokemon < 7) {
                    hero.hpm.useItems(hero.Team[hero.hpm.numberOfPokemon - 1]);
                }
                break;
            case "4":
                break;
        }
    }

  
}
