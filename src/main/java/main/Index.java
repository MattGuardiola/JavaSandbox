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
        System.out.println(name + ", you are number " + customers.size() + " in line. You are purchasing " + ticketNumber + " tickets");
        return new Customer(name,ticketNumber);
    }


    public static void buyAnotherTicket(ArrayList<Customer> customers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would someone else like to buy tickets?");
        String choice = scanner.nextLine().toLowerCase();
        if(choice.equals("yes")){
            buyTicket(customers);
            buyAnotherTicket(customers);
        } else if (choice.equals("no")){
            System.out.println("Goodbye...");
        } else {
            System.out.println("Not a valid entry");
            buyAnotherTicket(customers);
        }
    }






    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        buyTicket(customers);
        buyAnotherTicket(customers);


        System.out.println(customers);



    }
}
