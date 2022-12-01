package Database;

import Person.Person;
import Tickets.Ticket;

import java.util.ArrayList;

public class PersonDatabase extends Database
{
    //Lijst met al de personen
    private final ArrayList<Person> dbp;

    //Constructor
    public PersonDatabase() {
        this.dbp = new ArrayList<Person>();
    }

    //Functie om een persoon toe te voegen
    public void addPerson(Person p)
    {
        this.dbp.add(p);
    }

    //Functie om een persoon te verwijderen
    public void removePerson(Person p)
    {
        if(this.dbp.indexOf(p) != -1)
        {
            this.dbp.remove(p);
            p.setAmountPaid(0);
        }
    }

    //Functie om de lijst te printen
    public void printDatabase()
    {
        System.out.println("Personen");
        for (Person p : dbp)
        {
            System.out.println(p.getName() + " " + p.getAmountPaid());
        }
        System.out.println();
    }
}
