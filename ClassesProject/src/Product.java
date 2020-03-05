public class Product {

    private String name;
    private double price;
    private int quantity;

    /**
     * Default Product constructor
     */
    public Product() {
        new Product("", 0.0, 1);
    }

     /**
     * Overloaded Product constructor
     * @param newName Product name
     * @param newPrice Product Price
     * @param newQuantity Product quantity
     */
    public Product(String newName, double newPrice, int newQuantity) {

        setName(newName);
        setPrice(newPrice);
        setQuantity(newQuantity);

    }

    /**
     * Gets Product Name
     * @return Product name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Product Name
     * @param name New String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets Product price
     * @param price New double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets Product price
     * @return Product price as a double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets Product quantity
     * @return Product price as an int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets Product amount
     * @param quantity New int
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Lists Product name and price
     * @return Product name and price as a String
     */
    public String itemListing() {
        return name + " @ " + String.format("%.2f", getPrice());
    }

    /**
     * Gets Product details
     * @return Product name, price, and quantity as a String
     */
    @Override
    public String toString() {
        return getName() + " @ " + String.format("%.2f", getPrice()) + ", " + getQuantity() + " left";
    }
}
