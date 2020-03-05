import java.util.ArrayList;

public class vendingMachine {

    private ArrayList<Product> products;

    double totalMoney = 0;

    public vendingMachine() {

        products = new ArrayList<>();
    }

    public void addItem(Product newItem) {

        products.add(newItem);
    }

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

    public double removeCoins() {

        double coinsReturned = totalMoney;
        totalMoney = 0.00;

        return coinsReturned;
    }
}
