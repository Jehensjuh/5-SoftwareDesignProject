package Database;

import Person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class PersonDatabase extends Database
{

    private final ArrayList<Person> dbp; //Arraylist containing all persons
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

    //add person to database
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

    //remove person from database
    //gives error when person still has to pay
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

    //delete person using their name
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

    //checks whether a person is in the database
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

    //checks whether a person is in the database using their name
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

    @Override
    public void clearDatabase()
    {
        dbp.clear();
    }
}