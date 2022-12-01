package Bill;

import Database.PersonDatabase;
import Database.TicketDatabase;
import Person.Person;

import java.util.HashMap;

public class Bill {
    private PersonDatabase pdb;
    private TicketDatabase tdb;
    public Bill(PersonDatabase pdb, TicketDatabase tdb){
        this.pdb=pdb;
        this.tdb=tdb;
    }
    public HashMap<Person, Double>getBill(){//calulates final bill;
        HashMap<Person,Double>bill = new HashMap<Person, Double>();

        return bill;
    }


}
