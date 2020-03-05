/*
    Lionel Quintanilla and Nathanael Gastelum
    March 4, 2019
    Purpose: This class represents the Product object. It consists of
    a String name, a double price , and int quantity for each item and
    methods for getting and setting the name, price, and quantity for
    the Product, as well as getting a String version of the Product's
    information.
    */

public class Product {

    // Instance variables

    // String of name
    private String name;
    // double of price
    private double price;
    // int of quantity
    private int quantity;

    // Product(): Default constructor
    /**
     * Default Product constructor
     */
    public Product() {
        setName("");
        setPrice(0.00);
        setQuantity(0);
    }

    // Product(): Constructor. Takes String, double, and int parameter.
    /**
     * Overloaded Product constructor
     * @param newName Product name
     * @param newPrice Product price
     * @param newQuantity Product quantity
     */
    public Product(String newName, double newPrice, int newQuantity) {

        setName(newName);
        setPrice(newPrice);
        setQuantity(newQuantity);

    }

    // getName(): Gets name String value. Takes no parameter. Returns String.
    /**
     * Gets Product Name
     * @return Product name as a String
     */
    public String getName() {
        return name;
    }

    // setName(): Sets name String variable. Takes String parameter. Returns void.
    /**
     * Sets Product Name
     * @param name New String
     */
    public void setName(String name) {
        this.name = name;
    }

    // setPrice(): Sets price double variable. Takes double parameter. Returns void.
    /**
     * Sets Product price
     * @param price New double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    // getPrice(): Gets price double variable. Takes no parameter. Returns double.
    /**
     * Gets Product price
     * @return Product price as a double
     */
    public double getPrice() {
        return price;
    }

    // getQuantity(): Gets quantity int variable. Takes no parameter. Returns int.
    /**
     * Gets Product quantity
     * @return Product price as an int
     */
    public int getQuantity() {
        return quantity;
    }

    // setPrice(): Sets quantity int variable. Takes int parameter. Returns void.
    /**
     * Sets Product amount
     * @param quantity New int
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // itemListing(): Gets String with name and price of Product. Takes no parameter. Returns String.
    /**
     * Lists Product name and price
     * @return Product name and price as a String
     */
    public String itemListing() {
        return name + " @ " + String.format("%.2f", getPrice());
    }

    // toString(): Returns information about Product as String. Takes no parameters. Returns String.
    /**
     * Gets Product details
     * @return Product name, price, and quantity as a String
     */
    @Override
    public String toString() {
        return getName() + " @ " + String.format("%.2f", getPrice()) + ", " + getQuantity() + " left";
    }
}
