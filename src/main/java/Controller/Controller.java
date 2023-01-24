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

    public Boolean nameInDatabase(String name);

    public void sortDatabase();

    public ArrayList<Person> getDbp();

    public ArrayList<Person> getDbpReversed();

    public void addEntry(Ticket ticket);

    public ArrayList<Ticket> getTickets(Person creator);

    public ArrayList<Person> getCreators();

    public Ticket getTicket(String personName, String ticketName);

    public boolean isCreator(Person creator);

    public HashMap<Person, HashMap<Person, Double>> getBill();

    public void clearDatabase();

    public void addObserver();
}
