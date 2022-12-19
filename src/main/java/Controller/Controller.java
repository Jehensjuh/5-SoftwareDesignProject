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
    //Functie om een person toe te voegen
    public void addPerson(Person p);

    //Functie om een person te verwijderen
    public void removePerson(Person p);

    //Functie om een person te verwijderen op naam
    public void removePersonName(String name);

    //Functie om de database te printen
    public void printPersonDatabase();

    //Functie om te zien of een person in de database zit
    public boolean inDatabase(Person p);

    //Functie om te zien of een person in de database zit op basis van naam
    public Boolean nameInDatabase(String name);

    //Functie die de database sorteert op basis van amountPaid
    public void sortDatabase();

    //Functie die de database teruggeeft
    public ArrayList<Person> getDbp();

    //Functie die het omgekeerde van de database teruggeeft
    public ArrayList<Person> getDbpReversed();

    //Functie die al de tickets van de persoon geeft
    public void getInvolvedTickets(Person p);

    //Functie om een ticket toe te voegen
    public void addEntry(Ticket ticket);

    //Functie die al de tickets van een creator teruggeeft
    public ArrayList<Ticket> getTickets(Person creator);

    //Functie die al de creators teruggeeft
    public ArrayList<Person> getCreators();

    //Functie die een bepaalt ticket teruggeeft
    public Ticket getTicket(String personName, String ticketName);

    //Functie die ziet of een person de creator is van een ticket
    public boolean isCreator(Person creator);

    //Functie die de eindrekening maakt
    public HashMap<Person, HashMap<Person, Double>> getBill();

    //Functie die de databases leegmaakt
    public void clearDatabase();

    public void addObserver();
}
