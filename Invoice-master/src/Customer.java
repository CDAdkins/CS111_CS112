/* 
 * <Chris Adkins>, <5/9/2018>
 * <CS111>, <Les Russell>
 * Assignment 10, Project 1
 */

public class Customer {

    // The blueprint for a customer, can handle the name, ID, and the orders that the customer has

    private int     customerId   = 0;
    private String  customerName = null;
    public Order[] orders = new Order[5];

    public void addOrder(int itemQuantity, double itemPrice, String itemName) { // I honestly hate myself for writing these next 15 lines. I'm missing something, but I couldn't get a switch to work.
        Order itemOrdered = new Order(itemQuantity, itemPrice, itemName);       // Maybe a for-loop to run through the array would be cleaner, but it works, which is nice.
        if (this.orders[0] == null) {
            this.orders[0] = itemOrdered;
        } else if (this.orders[1] == null) {
            this.orders[1] = itemOrdered;
        } else if (this.orders[2] == null) {
            this.orders[2] = itemOrdered;
        } else if (this.orders[3] == null) {
            this.orders[3] = itemOrdered;
        } else if (this.orders[4] == null) {
            this.orders[4] = itemOrdered;
        } else if (this.orders[5] == null) {
            this.orders[5] = itemOrdered;
        }
    }

    public Order[] getOrders() {
        return this.orders;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Customer (int customerId, String customerName) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

}
