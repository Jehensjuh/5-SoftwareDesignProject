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

    //Berekent rekening
    public HashMap<Person,HashMap<Person,Double>> getBill()
    {
        pdb.sortDatabase();

        //Maakt een map aan
        HashMap<Person,Double> persondebt = new HashMap<Person,Double>();
        HashMap<Person,HashMap<Person,Double>> bill = new HashMap<Person,HashMap<Person,Double>>();

        return bill;
    }


}
