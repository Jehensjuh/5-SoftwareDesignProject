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
    //add person
    public void addPerson(Person p);

    //remove person
    public void removePerson(Person p);

    //remove person using name
    public void removePersonName(String name);

    //print person database
    public void printPersonDatabase();

    //checks whether a person is in the database
    public boolean inDatabase(Person p);

    //checks whether a person is in the database using their name
    public Boolean nameInDatabase(String name);

    //sorts the database by amountPaid
    public void sortDatabase();

    //returns database
    public ArrayList<Person> getDbp();

    //returns reversed database
    public ArrayList<Person> getDbpReversed();

    //returns all tickets linked to a person
    public void getInvolvedTickets(Person p);

    //add ticket
    public void addEntry(Ticket ticket);

    //returns tickets linked to a creator
    public ArrayList<Ticket> getTickets(Person creator);

    //returns all creators
    public ArrayList<Person> getCreators();

    //returns ticket based on creator name and ticketname
    public Ticket getTicket(String personName, String ticketName);

    //checks whether a person is the creator of a ticket
    public boolean isCreator(Person creator);

    //calculates bill
    public HashMap<Person, HashMap<Person, Double>> getBill();

    //clears database
    public void clearDatabase();

    //adds observer
    public void addObserver();
}
