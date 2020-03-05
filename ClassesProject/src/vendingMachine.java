import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Product> products;
    double totalMoney = 0;

    // Constructor. Takes no parameters. Generates new array list.
    /**
     * Default Checkout constructor
     */
    public VendingMachine() {

        products = new ArrayList<>();
    }

    // addItem(): Method adds Product to ArrayList. Takes Product parameter. Returns Void.
    /**
     * Adds Product to products array
     * @param newItem New Product
     */
    public void addItem(Product newItem) {

        products.add(newItem);
    }

    /**
     * Gets item selection
     * @param selection New char
     * @return Selected product as a String
     */
    public String getItem(char selection) {

        Product boughtItem = products.get(selection - 97);

        String result;

        if (boughtItem.getPrice() > totalMoney) {
            result = "Not enough money.";
            String returnMoney = String.format("%.2f", removeCoins());
            result += "\nReturned $" + returnMoney;
        }
        else if (boughtItem.getQuantity() < 1){
            result = "Sold out of " + boughtItem.itemListing();
            String returnMoney = String.format("%.2f", removeCoins());
            result += "\nReturned $" + returnMoney;
        }
        else  {
            boughtItem.setQuantity(boughtItem.getQuantity() - 1);
            result = "Bought " + boughtItem.itemListing();
            totalMoney -= boughtItem.getPrice();
        }

        return result;
    }

    /**
     * Shows inventory list
     * @return List of items as an ArrayList of Strings
     */
    public ArrayList<String> showItems() {

        ArrayList<String> inventory = new ArrayList<>();

        if (products.size() == 0) {
            inventory.add("The vending machine is empty.");
        }
        else {

            for (int i = 0; i < products.size(); i++) {
                char selectLetter = (char) (i + 97);
                String currItem = selectLetter + " - " + products.get(i).itemListing();
                inventory.add(currItem);
            }
        }

        return inventory;
    }

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

    /**
     * Removes all coins from vending machine
     * @return Stored coins as double
     */
    public double removeCoins() {

        double coinsReturned = totalMoney;
        totalMoney = 0.00;

        return coinsReturned;
    }
}
