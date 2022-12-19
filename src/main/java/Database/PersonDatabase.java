package Database;

import Person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

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
        if(!this.dbp.contains(p))
        {
            this.dbp.add(p);
        }
        else
        {
            System.out.println("Person already in database");
        }
    }

    //Functie om een persoon te verwijderen
    //error geven als de persoon nog moet betalen
    public void removePerson(Person p)
    {
        if(this.dbp.contains(p))
        {
            if(p.getAmountPaid() != 0)
            {
                System.out.println("Person still has to pay");
            }
            this.dbp.remove(p);
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
                this.removePerson(p);
                break;
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
        return this.dbp.contains(p);
    }

    public Person getPerson(String name){
        for(Person p:this.dbp){
            if(Objects.equals(p.getName(), name)){
                return p;
            }
        }
        return new Person("error");
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