package Database;

import Person.Person;
import Tickets.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
//Database containing all created Tickets and the Person who created them.
public class TicketDatabase extends Database{

    private final HashMap<Person, ArrayList<Ticket>> tD;

    public TicketDatabase(HashMap<Person, ArrayList<Ticket>> tD) {
        this.tD = tD;
    }
    //should be made singleton



}
