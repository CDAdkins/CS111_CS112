/* 
 * <Chris Adkins>, <5/9/2018>
 * <CS111>, <Les Russell>
 * Assignment 10, Project 1
 */

public class Order {
    
    // The class for each individual order, anything that can be gathered from the file regarding an order will first be loaded in to here.

    private int itemQuantity = 0;
    private double itemPrice = 0.0;
    private String itemName = null;

    public double getExtendedPrice() {
        return itemPrice * itemQuantity;
    }

    public Order (int itemQuantity, double itemPrice, String itemName) {
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }

    public String getOrderName() {
        return this.itemName;
    }

    public int getItemQuantity() {
        return this.itemQuantity;
    }

    public double getItemPrice() {
        return this.itemPrice;
    }
}