package Controller;

import Database.TicketDatabase;
import Factory.PersonFactory;
import Factory.TicketFactory;
import Person.Person;
import Database.PersonDatabase;
import Tickets.Ticket;

import java.util.HashMap;

public abstract interface Controller
{
    public abstract PersonDatabase getDatabasePerson();

    public abstract TicketDatabase getDatabaseTicket();

    public abstract PersonFactory getPersonFactory();

    public abstract TicketFactory getTicketFactory();

    public abstract void addPerson(Person p);

    public abstract void removePerson(Person p);

    public abstract void removePersonName(String name);

    public abstract void printPersonDatabase();

    public abstract boolean inDatabase(Person p);

    public abstract boolean nameInDatabase(String name);

    public abstract void addEntry(Ticket ticket);

    public abstract Ticket getTicket(String personName, String ticketName);

    public abstract HashMap<Person, HashMap<Person, Double>> getBill();

    public abstract void clearDatabase();

    public abstract void addObserver();
}
