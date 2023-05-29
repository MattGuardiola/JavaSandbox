package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Index {


    public static Event createEvent(ArrayList<Event> events){
       Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the event you would like to add?");
        String name = scanner.nextLine();
        System.out.println("How many tickets are available for this event?");
        int availability = scanner.nextInt();
        System.out.println("What is the price per ticket to this event?");
        double price = scanner.nextDouble();
        events.add(new Event(name,price,availability));
        System.out.println("You have scheduled " + name + " with " + availability + " tickets available at " + price + "$ each.");
        return new Event(name, price, availability);
    }




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
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

//        buyTicket(customers);
//        buyAnotherTicket(customers);

        createEvent(events);

        System.out.println(events);
        System.out.println(customers);



    }
}
