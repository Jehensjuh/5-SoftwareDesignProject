package Database;

import Person.Person;
import Tickets.Ticket;



public abstract class Database {

    public Database(){}

    public abstract void addEntry(Person person, Ticket ticket);
    //public abstract void add(Observer o);
    //public abstract void remove(Observer o);
    //public abstract void notify_observer();

}
