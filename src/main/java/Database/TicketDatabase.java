package Database;

import Person.Person;
import Tickets.Ticket;

import java.util.HashMap;
//Database containing all created Tickets and the Person who created them.
public class TicketDatabase extends Database{

    private final HashMap<Person, Ticket> tD;
    //should be made singleton
    public TicketDatabase(){
        this.tD = new HashMap<Person, Ticket>();
    }


}
