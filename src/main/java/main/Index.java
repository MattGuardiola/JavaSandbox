package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Index {



    public static Customer buyTicket(ArrayList<Customer> customers){
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("How many tickets would you like to buy?");
        int ticketNumber = scanner.nextInt();
        customers.add(new Customer(name,ticketNumber));
        return new Customer(name,ticketNumber);
    }

    public static void addCustomer(Customer customer, ArrayList<Customer> customers){
        System.out.println(customer.getName() + ", you are number " + 1 + " in line. You are purchasing " + customer.getTicketNumber() + " tickets");
    }






    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        buyTicket(customers);

        System.out.println(customers);



    }
}
