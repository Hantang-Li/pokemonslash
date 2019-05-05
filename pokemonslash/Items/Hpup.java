package pokemonslash.Items;

import java.util.Scanner;
import pokemonslash.GameCharacter;
import pokemonslash.Pokemons.Pokemon;

public class Hpup extends Potion {

   
    @Override
    public Pokemon functionForEnemy(Pokemon pokemon) {
        if (pokemon.HP < pokemon.maxhp - 10) {
            if (this.getAmount() > 0) {
                pokemon.HP += 10;
                System.out.println("Your enemy restored hp!");
                this.setAmount(this.getAmount() - 1);
                return pokemon;
            } else {
                return pokemon;
            }
        } else {
            return pokemon;
        }

    }

    @Override
    public Pokemon useItems(Pokemon pokemon) {
        System.out.println("Successfully restored!");
        pokemon.HP += 10;
        if (pokemon.HP > pokemon.stats.HP) {
            pokemon.HP = pokemon.stats.HP;
        }
        this.setAmount(this.getAmount() - 1);
        return pokemon;
    }

    @Override
    public void choiceItems(GameCharacter hero) {
        boolean exception = true;
        if (this.getAmount() > 0) {
            String choice = null;
            Scanner keyboard = new Scanner(System.in);
            for (int i = 0; i < 6; i++) {
                if (hero.Team[i] != null) {
                    System.out.println("your pokemon " + hero.Team[i].getName() + " HP is " + hero.Team[i].HP);
                }
            }

            do {

                do {
                    exception = false;
                    try {
                        System.out.println("Which pokemon's HP are you going to restore? (7 cancel)");
                        choice = keyboard.nextLine();
                        if(hero.Team[Integer.parseInt(choice) - 1].HP == 0){
                            System.out.println("This pokemon is dead");
                        }else if (hero.Team[Integer.parseInt(choice) - 1].HP < hero.Team[Integer.parseInt(choice) - 1].stats.HP) {
                            numberOfPokemon = Integer.parseInt(choice);
                        } else {
                            System.out.println("No need to restore HP");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("you must enter a number!");
                        exception = true;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        if (Integer.parseInt(choice) != 7) {
                            exception = true;
                        }
                    } catch (NullPointerException e) {
                        System.out.println("You have no pokemon here!");
                        exception = true;
                    }
                } while (exception == true || choice == "");

            } while (Integer.parseInt(choice) > 7 || Integer.parseInt(choice) < 0);
                numberOfPokemon = Integer.parseInt(choice);
        } else {
            System.out.println("You have no Hpup!");
            numberOfPokemon = 7;
        }
    }

}
