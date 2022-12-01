package Database;

import Person.Person;
import Tickets.Ticket;
import Database.TicketDatabase;

import java.util.ArrayList;
import java.util.Objects;

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
        if(this.dbp.indexOf(p) == -1)
        {
            this.dbp.add(p);
        }
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

    //Functie om een persoon te verwijderen op naam
    public void removePersonName(String s)
    {
        for(Person p : dbp)
        {
            if(Objects.equals(p.getName(), s))
            {
                if (this.dbp.indexOf(p) != -1) {
                    this.dbp.remove(p);
                    p.setAmountPaid(0);
                }
            }
            else
            {
                System.out.println("Name not found!");
            }
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

    //Functie om te zien of een persoon in de database zit
    public boolean inDatabase(Person p)
    {
        if(this.dbp.indexOf(p) != -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Functie om te zien of een persoon in de database zit op naam
    public boolean nameInDatabase(String s)
    {
        for(Person p : dbp)
        {
            if(Objects.equals(p.getName(), s))
            {
                return true;
            }
        }
        return false;
    }
}
