import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        vendingMachine Julians = new vendingMachine();

        while (true) {

            String currMoney = String.format("%.2f", Julians.totalMoney);
            System.out.println("Money: $" + currMoney);
            System.out.println("(S)hows Products - (I)nsert Coins - (B)uy - (A)dd Item -(R)emove Coins - (Q)uit");

            String userInput = input.nextLine();


            if (userInput.compareTo("S") == 0 || userInput.compareTo("s") == 0) {

                ArrayList<String> inventory = Julians.showItems();

                for (String currItem : inventory) {
                    System.out.println(currItem);
                }

                System.out.println();

            }
            else if (userInput.compareTo("I") == 0 || userInput.compareTo("i") == 0) {

                System.out.println("A - Dollar @ $1.00\nB - Quarter @ $0.25\nC - Dime @ $0.10\nD - Nickel @ $0.05");

                char option;

                int formatOption = -1;

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
            else if (userInput.compareTo("B") == 0 || userInput.compareTo("b") == 0) {

                ArrayList<String> inventory = Julians.showItems();

                for (String currItem : inventory) {
                    System.out.println(currItem);
                }

                System.out.println("\nMake a selection:");
                String selection = input.next();

                char formatSelection = selection.charAt(0);

                System.out.println(Julians.getItem(formatSelection));

                System.out.println();

                // Input Reset
                input.nextLine();
            }
            else if (userInput.compareTo("A") == 0 || userInput.compareTo("a") == 0) {

                System.out.println("Description:");
                String newName = input.nextLine();

                System.out.println("Price:");
                double newPrice = input.nextDouble();

                System.out.println("Quantity:");
                int newQuantity = input.nextInt();

                Product newItem = new Product(newName, newPrice, newQuantity);

                Julians.addItem(newItem);

                System.out.println();

                // Input Reset
                input.nextLine();
            }
            else if (userInput.compareTo("R") == 0 || userInput.compareTo("r") == 0) {

                String returnMoney = String.format("%.2f", Julians.removeCoins());
                System.out.println("Returned $" + returnMoney);
                System.out.println();
            }
            else if (userInput.compareTo("Q") == 0 || userInput.compareTo("q") == 0) {
                System.out.println("Have a nice day!");
                System.exit(0);
            }
            else {
                System.out.println("Sorry, please make a another selection.");
                System.out.println();
            }


        }


    }


}
