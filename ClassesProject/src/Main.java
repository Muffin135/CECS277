import java.util.ArrayList;
import java.util.Scanner;

    /*
    Lionel Quintanilla and Nathanael Gastelum
    March 4, 2019
    Purpose: This is the main class of the project. It consists of a Vending Machine object
    and the logic required for handling and passing user inputs. When passing user inputs,
    the class uses methods from the Vending Machine object. This project is intended to
    simulating the workings of a real Vending Machine where you can buy items with money,
    and also restock the Vending Machine.
    */

public class Main {

    public static void main(String[] args) {

        // User input object
        Scanner input = new Scanner(System.in);

        vendingMachine Julians = new vendingMachine("Julian's");

        while (true) {

            String currMoney = String.format("%.2f", Julians.totalMoney);
            System.out.println("Money: $" + currMoney);
            System.out.println("(S)hows Products - (I)nsert Coins - (B)uy - (A)dd Item -(R)emove Coins - (Q)uit");

            // Gets user's input
            String userInput = input.nextLine();

            // Gets Vending Machine's inventory with showItems() and prints inventory
            if (userInput.compareTo("S") == 0 || userInput.compareTo("s") == 0) {

                ArrayList<String> inventory = Julians.showItems();

                for (String currItem : inventory) {
                    System.out.println(currItem);
                }

                System.out.println();

            }
            // Adds money to Vending Machine with addCoins()
            else if (userInput.compareTo("I") == 0 || userInput.compareTo("i") == 0) {

                System.out.println("A - Dollar @ $1.00\nB - Quarter @ $0.25\nC - Dime @ $0.10\nD - Nickel @ $0.05");

                char option;

                int formatOption = -1;

                // Takes a char input and converts it to int to allow for A-Z inputs
                while (formatOption > 3 || formatOption < 0) {
                    System.out.println("\nPlease make a selection:");
                    option = input.next().charAt(0);
                    formatOption = option - 97;
                }

                Julians.addCoins(formatOption);

                System.out.println();

                // Input Reset
                input.nextLine();
            }
            // Takes user input to buy an item
            else if (userInput.compareTo("B") == 0 || userInput.compareTo("b") == 0) {

                // Gets the Vending Machine's inventory
                ArrayList<String> inventory = Julians.showItems();

                // If the first item is the empty message, it skips the process
                if (inventory.get(0).compareTo("The vending machine is empty.") == 0) {

                    System.out.println(inventory.get(0));
                }

                // If it is not empty, it prints Vending Machine's inventory and takes user's input
                else {

                    for (String currItem : inventory) {
                        System.out.println(currItem);
                    }

                    System.out.println("\nMake a selection:");
                    String selection = input.next();

                    char formatSelection = selection.charAt(0);

                    // Gets item using getItem() and prints success message
                    System.out.println(Julians.getItem(formatSelection));

                    // Input Reset
                    input.nextLine();
                }

                System.out.println();

            }
            // Adds item to Vending Machine stock or adds stock to existing item
            else if (userInput.compareTo("A") == 0 || userInput.compareTo("a") == 0) {

                // Gets Vending Machine stock as Products
                ArrayList<Product> stock = Julians.stock();

                // Checks to see if item is already in the Vending Machine
                boolean alreadyStocked = false;

                // Gets name of item
                System.out.println("Description:");
                String newName = input.nextLine();

                // If the item is already in the Vending Machine, then it changes changes quantity
                for (Product currItem : stock) {
                    if (currItem.getName().compareTo(newName) == 0) {
                        System.out.println("Restock Quantity:");
                        int newQuantity = input.nextInt();
                        currItem.setQuantity(newQuantity);
                        alreadyStocked = true;
                    }
                }

                // If item is not in the Vending Machine already, then it creates a new item
                if (alreadyStocked == false) {
                    System.out.println("Price:");
                    double newPrice = input.nextDouble();

                    System.out.println("Quantity:");
                    int newQuantity = input.nextInt();

                    Product newItem = new Product(newName, newPrice, newQuantity);

                    // Adds the new item with addItem()
                    Julians.addItem(newItem);
                }

                System.out.println();

                // Input Reset
                input.nextLine();
            }
            // Returns the user's money with removeCoins()
            else if (userInput.compareTo("R") == 0 || userInput.compareTo("r") == 0) {

                String returnMoney = String.format("%.2f", Julians.removeCoins());
                System.out.println("Returned $" + returnMoney);
                System.out.println();
            }
            // Quits the program
            else if (userInput.compareTo("Q") == 0 || userInput.compareTo("q") == 0) {
                System.out.println("Have a nice day!");
                System.exit(0);
            }
            // Asks for another input if the current one is invalid
            else {
                System.out.println("Sorry, please make a another selection.");
                System.out.println();
            }


        }


    }


}
