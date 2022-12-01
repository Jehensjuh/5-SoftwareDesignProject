package Person;
import Tickets.Ticket;
import Database.TicketDatabase;
import Database.Database;

public class Person {
    private String name;
    private double amountPaid;
    public Person(String name) {
        this.name = name;
        this.amountPaid = 0.0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}