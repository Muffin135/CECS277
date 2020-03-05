
public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String newName, double newPrice, int newQuantity) {

        setName(newName);
        setPrice(newPrice);
        setQuantity(newQuantity);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String itemListing() {
        return name + " @ " + String.format("%.2f", getPrice());
    }

    @Override
    public String toString() {
        return getName() + " @ " + String.format("%.2f", getPrice()) + ", " + getQuantity() + " left";
    }
}
