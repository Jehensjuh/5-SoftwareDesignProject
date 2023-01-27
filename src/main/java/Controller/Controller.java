package Controller;

import Database.Database;
import Database.TicketDatabase;
import Factory.TicketFactory;
import Database.TicketDatabase;
import Person.Person;
import Database.PersonDatabase;
import Tickets.Ticket;
import Tickets.TicketTypes;

import java.util.ArrayList;
import java.util.HashMap;

public interface Controller
{
    public void addPerson(Person p);

    public void removePerson(Person p);

    public void removePersonName(String name);

    public void printPersonDatabase();

    public boolean inDatabase(Person p);

    public boolean nameInDatabase(String name);

    public void addEntry(Ticket ticket);

    public Ticket getTicket(String personName, String ticketName);

    public HashMap<Person, HashMap<Person, Double>> getBill();

    public void clearDatabase();

    public void addObserver();
}
