package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Index {

    public static void printLogo(){
        System.out.println("""
                ,--------.,--.      ,--.            ,--.             ,------. ,--.                             \s
                '--.  .--'`--' ,---.|  |,-. ,---. ,-'  '-. ,---.     |  .--. '|  | ,---.  ,--,--. ,---.  ,---. \s
                   |  |   ,--.| .--'|     /| .-. :'-.  .-'(  .-'     |  '--' ||  || .-. :' ,-.  |(  .-' | .-. :\s
                   |  |   |  |\\ `--.|  \\  \\\\   --.  |  |  .-'  `)    |  | --' |  |\\   --.\\ '-'  |.-'  `)\\   --.\s
                   `--'   `--' `---'`--'`--'`----'  `--'  `----'     `--'     `--' `----' `--`--'`----'  `----'\s
                                                                                                               \s
                """);
    }


    public static void mainMenu(ArrayList<Event> events, ArrayList<Customer> customers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println(" ");
        System.out.println("1: Add an event");
        System.out.println("2: Purchase Tickets for an event");
        System.out.println("3: See a list of all events");
        System.out.println("4: Exit");
        System.out.println(" ");
        System.out.println("Please select a number between 1 and 3");
        int menuChoice = scanner.nextInt();
        if(menuChoice == 1){
            createEvent(events);
            createAnotherEvent(events,customers);
        } else if (menuChoice == 2){
            buyTicket(events, customers);
            buyAnotherTicket(events, customers);
        } else if(menuChoice == 3){
            printEvents(events);
            mainMenu(events, customers);
        } else if(menuChoice == 4){
            System.out.println("Goodbye...");
        } else {
            System.out.println("Not a valid entry");
            mainMenu(events, customers);
        }
    }




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

    public static void createAnotherEvent(ArrayList<Event> events, ArrayList<Customer> customers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to schedule another event");
        String choice = scanner.nextLine().toLowerCase();
        if(choice.equals("yes")){
            createEvent(events);
            createAnotherEvent(events, customers);
        } else if (choice.equals("no")){
            mainMenu(events, customers);
        } else {
            System.out.println("Not a valid entry");
            buyAnotherTicket(events, customers);
        }
    }



    public static Customer buyTicket(ArrayList<Event> events, ArrayList<Customer> customers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which event would you like to purchase tickets for?");
        System.out.println();

        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            System.out.println(event.getName());
        }

        System.out.println();
        String chosenEvent = scanner.nextLine();

        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.getName().equalsIgnoreCase(chosenEvent)) {
                System.out.println("You would like to purchase tickets for " + event.getName() + " for " + event.getPrice() + " each");
                System.out.println("Is this correct?");
                String eventConfirmation = scanner.nextLine();

                if (eventConfirmation.equalsIgnoreCase("yes")) {
                    System.out.println("What is your name?");
                    String name = scanner.nextLine();
                    System.out.println("How many tickets would you like to buy?");
                    int ticketNumber = scanner.nextInt();
                    events.add(new Event(events.get(i).getName(), events.get(i).getPrice(), events.get(i).getAvailability() - ticketNumber));
                    events.remove(events.get(i));
                    customers.add(new Customer(name, ticketNumber));
                    System.out.println(name + ", you are number " + customers.size() + " in line. You are purchasing " + ticketNumber + " tickets");
                    return new Customer(name, ticketNumber);
                } else {
                    System.out.println("Purchase cancelled");
                    buyTicket(events,customers);
                    return null;
                }
            }
        }

        System.out.println("Not a valid entry");
        return null;
    }




    public static void buyAnotherTicket(ArrayList<Event> events, ArrayList<Customer> customers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would someone else like to buy tickets?");
        String choice = scanner.nextLine().toLowerCase();
        if(choice.equals("yes")){
            buyTicket(events, customers);
            buyAnotherTicket(events, customers);
        } else if (choice.equals("no")){
            mainMenu(events, customers);
        } else {
            System.out.println("Not a valid entry");
            buyAnotherTicket(events, customers);
        }
    }


    public static void printEvents(ArrayList<Event> events){
        System.out.println(" ");
        for (Event event: events) {
            System.out.println(event.getName() + " has " + event.getAvailability() + " tickets available at " + event.getPrice() + "$ each" );
        }
        System.out.println(" ");
    }




    public static void main(String[] args) {
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

        events.add(new Event("taylor swift", 23.99, 500));
        events.add(new Event("garth brooks", 30, 450));
        printLogo();
        mainMenu(events,customers);


        System.out.println(events);
        System.out.println(customers);

    }
}


