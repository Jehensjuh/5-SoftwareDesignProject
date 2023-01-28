package Database;

import Person.Person;

import java.util.*;

public class PersonDatabase extends Observable
{
    //list with all the persons
    private final ArrayList<Person> dbp;
    private static PersonDatabase instance = null;

    //constructor
    private PersonDatabase() {
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
    }

    //remove a person
    public void removePerson(Person p)
    {
        if(this.dbp.contains(p))
        {
            this.dbp.remove(p);
        }
    }

    //remove person based on name
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

    //returns the database
    public ArrayList<Person> getDbp() {
        return dbp;
    }

    //sorts the database
    public ArrayList<Person> getDbpSorted()
    {
        ArrayList<Person> sorted = this.dbp;
        Collections.sort(sorted);
        return sorted;
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
    public void clearDatabase()
    {
        dbp.clear();
    }
}