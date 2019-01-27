/* 
 * <Chris Adkins>, <5/9/2018>
 * <CS111>, <Les Russell>
 * Assignment 10, Project 1
 */

public class Invoice {

    // Congregates all of the known info about the customer and their orders into an invoice

    private Customer customer;
    private double subTotal = 0.0;
    private double taxRate = 7.5;

    public Invoice(Customer customer) {
        this.customer = customer;
    }

    public void getItemsOrdered() {
        customer.getOrders();
    }

    public double getSubTotal() {
        for (int ndx = 0; ndx < this.customer.orders.length; ndx++) {
            this.subTotal += this.customer.orders[ndx].getExtendedPrice();
        }
        return this.subTotal;
    }

    public double getTax() {
        return this.subTotal * (taxRate / 100);
    }

    public double getTotal() {
        return this.subTotal + this.getTax();
    }

    public String getCustomerName() {
        return customer.getCustomerName();
    }
}
