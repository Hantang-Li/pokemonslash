/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonslash.Battle;

import java.util.Scanner;
import pokemonslash.GameCharacter;
import pokemonslash.Pokemons.Pokemon;

public class SwicthPokemon extends Action {

    //switch
    //item
    //moves
    public void ChoseWhichOneToSwitch(GameCharacter hero) {//BUG FIXED!!!
        String continueButton;
        sequence = 1;
        int i;
        for (i = 0; i < 6; i++) {
            if (hero.Team[i] != null) {
                System.out.println(i + 1 + " . " + hero.Team[i].getBaseStats().nameOfPokemon + " name: " + hero.Team[i].getName() + "HP: " + hero.Team[i].HP);//print stat, see toString method in PokemonStat
            } else {
                System.out.println(i + 1 + " . no Pokémon here");
            }
        }
        String choice;
        Scanner keyboard = new Scanner(System.in);
        boolean exception = false;
        do {
            exception = false;
            System.out.println("Exchange which pokemon?");
            choice = keyboard.nextLine();
            try {
                if(hero.Team[Integer.parseInt(choice)-1].HP==0){
                    System.out.println("Your pokemon dead!");
                    exception = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("you must enter a number!");
                exception = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("AIOOBE");
                if (Integer.parseInt(choice) != 7) {
                    exception = true;
                }
            } catch (NullPointerException e) {
                System.out.println("You have no pokemon here!");
                exception = true;
            }
        } while (exception == true);
        System.out.println("\n\tPress any button to continue!");
        continueButton = keyboard.nextLine();
        System.out.print("\n");
        numberOfPokemonToSwitch = Integer.parseInt(choice);
    }

    public void SwitchPokemon(GameCharacter targetTrainner) {
        Pokemon buffer;
        buffer = targetTrainner.Team[0];
        targetTrainner.Team[0] = targetTrainner.Team[numberOfPokemonToSwitch - 1];
        targetTrainner.Team[numberOfPokemonToSwitch - 1] = buffer;
    }

}
