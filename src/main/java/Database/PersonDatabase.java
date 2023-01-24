package Database;

import Person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class PersonDatabase extends Database
{
    //list with all the persons
    private final ArrayList<Person> dbp;
    private static PersonDatabase instance;

    //constructor
    public PersonDatabase() {
        this.dbp = new ArrayList<Person>();
    }

    //singleton
    public static PersonDatabase getInstance(){
        if (instance == null){
            instance = new PersonDatabase();
        }
        return instance;
    }

    //add a person
    public void addPerson(Person p)
    {
        if(!this.dbp.contains(p))
        {
            this.dbp.add(p);
        }
        else
        {
            //create a pop-up
            System.out.println("Person already in database");
        }
    }

    //remove a person
    public void removePerson(Person p)
    {
        if(this.dbp.contains(p))
        {
            if(p.getAmountPaid() != 0)
            {
                //creates a pop-up
                System.out.println("Person still has to pay");
            }
            this.dbp.remove(p);
        }
        else
        {
            //create a pop-up
            System.out.println("Person not in database");
        }
    }

    //remove person based on name
    public void removePersonName(String s)
    {
        for(Person p : dbp)
        {
            if(Objects.equals(p.getName(), s))
            {
                if(p.getAmountPaid() != 0)
                {
                    //creates a pop-up
                    System.out.println("Person still has to pay");
                }
                this.removePerson(p);
                break;
            }
        }
        System.out.println("Person not in database");
    }

    //print the list
    public void printDatabase()
    {
        System.out.println("Personen");
        for (Person p : dbp)
        {
            System.out.println(p.getName() + " " + p.getAmountPaid());
        }
        System.out.println();
    }

    //see if a person is in the database
    public boolean inDatabase(Person p)
    {
        return this.dbp.contains(p);
    }

    //see if a person is in the database based on name
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

    public Person getPerson(String name){
        for(Person p : dbp){
            if(Objects.equals(p.getName(), name)){
                return p;
            }
        }
        return new Person("error");
    }

    //sorts the database
    public void sortDatabase()
    {
        Collections.sort(this.dbp);
    }

    //returns the database
    public ArrayList<Person> getDbp() {
        return dbp;
    }

    //returns the reversed database
    public ArrayList<Person> getDbpReversed()
    {
        ArrayList<Person> reversed = new ArrayList<Person>();
        for(int i=dbp.size()-1;i>=0;i--)
        {
            reversed.add(dbp.get(i));
        }
        return reversed;
    }

    //clears the database
    @Override
    public void clearDatabase()
    {
        dbp.clear();
    }
}