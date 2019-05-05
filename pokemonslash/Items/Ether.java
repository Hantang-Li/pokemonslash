package pokemonslash.Items;

import java.util.Random;
import java.util.Scanner;
import pokemonslash.GameCharacter;
import pokemonslash.Pokemons.Pokemon;

public class Ether extends Potion {

    public Pokemon useItems(Pokemon pokemon) {
        System.out.println("pp restored");
        pokemon.Move[numberOfMove - 1].pp += 10;
        if (pokemon.Move[numberOfMove - 1].pp > pokemon.Move[numberOfMove - 1].maxpp) {
            pokemon.Move[numberOfMove - 1].pp = pokemon.Move[numberOfMove - 1].maxpp;
        }
        this.setAmount(this.getAmount() - 1);
        return pokemon;
    }

    @Override
    public Pokemon functionForEnemy(Pokemon pokemon) {
        int choice;
        Random rnd = new Random();
        choice = rnd.nextInt(4);

        if (pokemon.Move[choice].pp < (pokemon.Move[choice].maxpp - 10)) {
            pokemon.Move[choice].pp += 10;
            System.out.println("Your enemy's pp restored");
            this.setAmount(this.getAmount() - 1);
            return pokemon;
        } else {
            return pokemon;
        }
    }

    @Override
    public void choiceItems(GameCharacter hero) {
        if (this.getAmount() > 0) {
            String choice, choice2 = null;
            Scanner keyboard = new Scanner(System.in);
            boolean exception;
            boolean exception2;
            do {
                for (int i = 0; i < 6; i++) {
                    if (hero.Team[i] != null) {
                        System.out.println(i + 1 + hero.Team[i].getName());
                    }
                }
                exception = false;
                System.out.println("Which pokemon's PP are you going to restore? (7 cancel)");
                choice = keyboard.nextLine();

                try {
                    if (Integer.parseInt(choice) != 7) {
                        do {

                            try {
                                exception2 = false;
                                for (int i = 0; i < 4; i++) {

                                    if (hero.Team[Integer.parseInt(choice) - 1].Move[i] != null) {
                                        System.out.println((i + 1) + ". " + hero.Team[Integer.parseInt(choice) - 1].Move[i].name);
                                    }
                                }

                                System.out.println("Which move's pp are you going to restore?");
                                choice2 = keyboard.nextLine();

                                if (Integer.parseInt(choice2) != 5) {
                                    if (Integer.parseInt(choice) != 7) {
                                        if (hero.Team[Integer.parseInt(choice) - 1].Move[Integer.parseInt(choice2) - 1].pp < (hero.Team[Integer.parseInt(choice) - 1].Move[Integer.parseInt(choice2) - 1].maxpp)) {
                                            numberOfPokemon = Integer.parseInt(choice);
                                            numberOfMove = Integer.parseInt(choice2);
                                            exception = false;
                                            break;

                                        } else {
                                            System.out.println("No need to restore pp");
                                            exception = true;
                                        }
                                    }

                                }
                            } catch (NumberFormatException e) {
                                System.out.println("you must enter a number!");
                                exception2 = true;
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("valid choice 5 to cancel");
                                exception2 = true;
                            }

                        } while (exception2 = true);
                    } else {
                        break;
                    }
                    if (exception == false) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("you must enter a number!");
                    exception = true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("array nindex o b");
                    exception = true;
                } catch (NullPointerException e) {
                    System.out.println("valid choice");
                    exception = true;
                }
            } while (exception = true);
            numberOfPokemon = Integer.parseInt(choice);
        } else {
            System.out.println("You have no PPup!");
            numberOfPokemon = 7;
        }
    }
}
