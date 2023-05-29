package main;

public class Customer {
    private String name;
    private int ticketNumber;

    public Customer(String name, int ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", ticketNumber=" + ticketNumber +
                '}';
    }
}
