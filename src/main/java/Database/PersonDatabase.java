package Database;

import Person.Person;
import Tickets.Ticket;
import Database.TicketDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Observer;

public class PersonDatabase extends Database
{
    //Lijst met al de personen
    private final ArrayList<Person> dbp;
    private static PersonDatabase instance;

    //Constructor
    public PersonDatabase() {
        this.dbp = new ArrayList<Person>();
    }

    public static PersonDatabase getInstance(){//singleton
        if (instance == null){
            instance = new PersonDatabase();
        }
        return instance;
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
    //error geven als de persoon nog moet betalen?
    public void removePerson(Person p)
    {
        if(this.dbp.indexOf(p) != -1)
        {
            if(p.getAmountPaid() != 0)
            {
                this.dbp.remove(p);
                p.setAmountPaid(0);
            }
            else
            {
                System.out.println("Person still has to pay");
            }
        }
        else
        {
            System.out.println("Person not in database");
        }
    }

    //Functie om een persoon te verwijderen op naam
    public void removePersonName(String s)
    {
        for(Person p : dbp)
        {
            if(Objects.equals(p.getName(), s))
            {
                if(p.getAmountPaid() != 0)
                {
                    this.dbp.remove(p);
                    p.setAmountPaid(0);
                    break;
                }
                else
                {
                    System.out.println("Person still has to pay");
                    break;
                }
            }
        }
        System.out.println("Person not in database");
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

    public void sortDatabase()
    {
        Collections.sort(this.dbp);
    }

    public ArrayList<Person> getDbp() {
        return dbp;
    }

    public ArrayList<Person> getDbpReversed()
    {
        ArrayList<Person> reversed = new ArrayList<Person>();
        for(int i=dbp.size()-1;i>=0;i--)
        {
            reversed.add(dbp.get(i));
        }
        return reversed;
    }
}
