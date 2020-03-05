import java.util.ArrayList;


    /*
    Lionel Quintanilla and Nathanael Gastelum
    March 4, 2019
    Purpose: This class represents the Vending Machine object. It consists of
    an ArrayList of Product objects and the necessary methods for stocking and buying
    products, adding and removing money, and displaying products in the Vending Machine,
    as well as a constructor.
    */

public class vendingMachine {

    // Instance variables

    // Name of the Vending Machine
    private String name;
    // Array List of Products
    private ArrayList<Product> products;

    // The total money in the Vending Machine
    double totalMoney = 0;
    double storedMoney = 0;

    // vendingMachine(): Default constructor
    /**
     * Default Checkout constructor
     */
    public vendingMachine() {

        // Initializes new Array List
        products = new ArrayList<>();
    }

    // vendingMachine(): Constructor. Takes String parameter.

    /**
     * Overloaded Vending Machine constructor
     * @param newName Vending Machine name
     */
    public vendingMachine(String newName) {

        // Sets Vending Machine name
        setName(newName);
        // Initializes new Array List
        products = new ArrayList<>();
    }

    // setName(): Sets name String variable. Takes String parameter. Returns void.
    /**
     * Sets Vending Machine name
     * @param newName Vending Machine name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    // getName(): Gets name String value. Takes no parameter. Returns String.

    /**
     * Gets Vending Machine name
     * @return Vending Machine name as a String
     */
    public String getName() {
        return name;
    }

    // addItem(): Adds Product to Array List. Takes Product parameter. Returns void.
    /**
     * Adds Product to products array
     * @param newItem New Product
     */
    public void addItem(Product newItem) {
        products.add(newItem);
    }

    // getItem(): Gets item based on user input. Takes char parameter. Returns String.
    /**
     * Gets item selection
     * @param selection New char
     * @return Selected product as a String
     */
    public String getItem(char selection) {

        // Gets Product from Array List based on user input
        Product boughtItem = products.get(selection - 97);

        // Initializes result message
        String result;

        // If the user does not have enough money
        if (boughtItem.getPrice() > totalMoney) {
            result = "Not enough money.";
            // Returns user's money

          String returnMoney = String.format("%.2f", totalMoney);
            totalMoney = 0;

          String returnMoney = String.format("%.2f", removeCoins());

          result += "\nReturned $" + returnMoney;
        }

        // If the item is not in stock
        else if (boughtItem.getQuantity() < 1){
            result = "Sold out of " + boughtItem.itemListing();
            // Returns user's money

            String returnMoney = String.format("%.2f", totalMoney);
            totalMoney = 0;

            String returnMoney = String.format("%.2f", removeCoins());

            result += "\nReturned $" + returnMoney;
        }
        // If the user has enough money and the item is in stock
        else  {
            // Reduces stock by 1
            boughtItem.setQuantity(boughtItem.getQuantity() - 1);
            result = "Bought " + boughtItem.itemListing();
            // Charges the user's money

            storedMoney += boughtItem.getPrice();
            totalMoney = 0;

            totalMoney -= boughtItem.getPrice();

        }

        // Returns the result message
        return result;
    }

    // showItems(): Gets items in the Vending Machine as Strings. Takes no parameters. Returns Array List of String.
    /**
     * Shows inventory list
     * @return List of items as an ArrayList of Strings
     */
    public ArrayList<String> showItems() {

        // Initializes Array List of String
        ArrayList<String> inventory = new ArrayList<>();

        // Empty message
        if (products.size() == 0) {
            inventory.add("The vending machine is empty.");
        }
        // Message with items in stock
        else {

            for (int i = 0; i < products.size(); i++) {
                // Creates an index for user to chose from
                char selectLetter = (char) (i + 97);
                // Gets the item's name and price
                String currItem = selectLetter + " - " + products.get(i).itemListing();
                // Adds to list
                inventory.add(currItem);
            }
        }

        // Returns Array List
        return inventory;
    }

    // showItems(): Gets items in the Vending Machine as Products. Takes no parameters. Returns Array List of Product.
    /**
     * Shows inventory list
     * @return List of items as an ArrayList of Products
     */
    public ArrayList<Product> stock() {

        // Initializes Array List of Product
        ArrayList<Product> stock = new ArrayList<>();

        // Same functionality as showItems() but with Product instead of String

        if (products.size() == 0) {
            return stock;
        }
        else {

            for (int i = 0; i < products.size(); i++) {
                Product currItem = products.get(i);
                stock.add(currItem);
            }
        }

        return stock;
    }

    // addCoins(): Adds money to the Vending Machine. Takes int parameter. Return void.
    /**
     * Deposits coins in the vending machine
     * @param newCoins New int
     */
    public void addCoins(int newCoins) {

        if (newCoins == 0) {
            totalMoney += 1.00;
        }
        else if (newCoins == 1) {
            totalMoney += 0.25;
        }
        else if (newCoins == 2) {
            totalMoney += 0.10;
        }
        else if (newCoins == 3) {
            totalMoney += 0.05;
        }
    }

    // removeCoins(): Removes money from Vending Machine and resets money. Takes no parameters. Returns double.
    /**
     * Removes all coins from vending machine
     * @return Stored coins as double
     */
    public double removeCoins() {

        double coinsReturned = storedMoney;
        storedMoney = 0.00;

        return coinsReturned;
    }

    // toString(): Returns information about Vending Machine as String. Takes no parameters. Returns String.
    /**
     * Gets Product details
     * @return Vending Machine name and list of items as a String
     */
    public String toString() {

        String inventory = "";

        if (products.size() == 0) {
            inventory += "The vending machine is empty.";
        }
        else {

            for (int i = 0; i < products.size(); i++) {
                String currItem = products.get(i).toString();
                inventory += currItem;
            }
        }

        return inventory;
    }
}
