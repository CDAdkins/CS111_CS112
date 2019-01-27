/* 
 * <Chris Adkins>, <5/9/2018>
 * <CS111>, <Les Russell>
 * Assignment 10, Project 1
 *
 * Program Description
 * This program reads a given text file to look for customer data and order data. 
 * It then creates an invoice listing the customer's information as well as his
 * orders. It then prints the invoice along with the Sub Total, Tax, and Total.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InvoiceDriver {
    
    /* 
     * The driver class handles reading the file and printing the invoice. It also
     * handles the declaration, initialization, and the instantiation of some of the variables 
     * and objects.
     */

    private Customer customer1 = null;
    private Customer customer2 = null;
    private Invoice invoice1 = null;
    private Invoice invoice2 = null;

    public static void main(String[] args) {
        String fileName = "CustomerOrders.txt";
        InvoiceDriver iD = new InvoiceDriver();
        iD.loadInvoices(fileName);
    }

    public void loadInvoices(String fileName) {
        try { // If we have more to read, look for "C", if you find "C", make a new customer and start looking for new orders "O".
            Scanner inputStream = new Scanner(new FileInputStream(fileName));
            while (inputStream.hasNext()) {
                if(inputStream.next().equals("C")) {
                    customer1 = new Customer(inputStream.nextInt(), inputStream.nextLine());
                    while(inputStream.next().equals("O")) {
                        customer1.addOrder(inputStream.nextInt(), inputStream.nextDouble(), inputStream.nextLine());
                    }
                    customer2 = new Customer(inputStream.nextInt(), inputStream.nextLine());
                    while(inputStream.next().equals("O")) {
                        customer2.addOrder(inputStream.nextInt(), inputStream.nextDouble(), inputStream.nextLine());
                    }
                    invoice1 = new Invoice(customer1);
                    invoice2 = new Invoice(customer2);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Can't open file.");
        } finally {
            printInvoices();
        }
    }

    public void printInvoices(){
        System.out.print("Customer Name:");
        System.out.println(customer1.getCustomerName());
        System.out.print("Customer ID: ");
        System.out.println(customer1.getCustomerId());
        System.out.println("Items Ordered:");
        for(int ndx = 0; ndx < customer1.orders.length; ndx ++) {
            System.out.print(customer1.orders[ndx].getItemQuantity() + " $");
            System.out.print(customer1.orders[ndx].getItemPrice());
            System.out.print(customer1.orders[ndx].getOrderName());
            System.out.printf(": $%.2f%n",customer1.orders[ndx].getExtendedPrice());
        }
        System.out.print("Subtotal: ");
        System.out.println(invoice1.getSubTotal());
        System.out.print("Tax: ");
        System.out.printf("$%.2f %n", invoice1.getTax());
        System.out.print("Total: ");
        System.out.printf("$%.2f %n %n", invoice1.getTotal());

        System.out.print("Customer Name:");
        System.out.println(customer2.getCustomerName());
        System.out.print("Customer ID: ");
        System.out.println(customer2.getCustomerId());
        System.out.println("Items Ordered:");
        for(int ndx = 0; ndx < customer2.orders.length; ndx ++) {
            System.out.print(customer2.orders[ndx].getItemQuantity() + " $");
            System.out.print(customer2.orders[ndx].getItemPrice());
            System.out.print(customer2.orders[ndx].getOrderName());
            System.out.printf(": $%.2f%n",customer2.orders[ndx].getExtendedPrice());
        }
        System.out.print("Subtotal: ");
        System.out.println(invoice2.getSubTotal());
        System.out.print("Tax: ");
        System.out.printf("$%.2f %n", invoice2.getTax());
        System.out.print("Total: ");
        System.out.printf("$%.2f %n", invoice2.getTotal());
    }
}