package Controller;

import Observers.ObserverTicket;
import Person.Person;
import Database.TicketDatabase;
import Database.PersonDatabase;
import Tickets.Ticket;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseController implements Controller {

    private final PersonDatabase dbp;
    private final TicketDatabase dbt;

    public DatabaseController() {
        this.dbp = PersonDatabase.getInstance();
        this.dbt = TicketDatabase.getInstance();
    }
    //temporary
    public PersonDatabase getPersonDatabase(){
        return this.dbp;
    }

    public TicketDatabase getTicketDatabase(){
        return this.dbt;
    }

    @Override
    public void addPerson(Person p) {
        dbp.addPerson(p);
    }

    @Override
    public void removePerson(Person p) {
        dbp.removePerson(p);
    }

    @Override
    public void removePersonName(String name) {
        dbp.removePersonName(name);
    }

    @Override
    public void printPersonDatabase() {
        this.dbp.printDatabase();
    }

    @Override
    public boolean inDatabase(Person p) {
        return dbp.inDatabase(p);
    }

    @Override
    public Boolean nameInDatabase(String name) {
        return dbp.nameInDatabase(name);
    }

    @Override
    public void sortDatabase() {}

    @Override
    public ArrayList<Person> getDbp() {
        return dbp.getDbp();
    }

    @Override
    public ArrayList<Person> getDbpReversed() {
        return dbp.getDbpReversed();
    }

    @Override
    public void getInvolvedTickets(Person p)
    {
        dbt.getInvolvedTickets(p);
    }

    @Override
    public void addEntry(Ticket ticket) {
        dbt.addEntry(ticket);
    }

    @Override
    public ArrayList<Ticket> getTickets(Person creator) {
        return dbt.getTickets(creator);
    }

    @Override
    public ArrayList<Person> getCreators() {
        return dbt.getCreators();
    }

    @Override
    public Ticket getTicket(String personName, String ticketName) {
        return dbt.getTicket(personName, ticketName);
    }

    @Override
    public boolean isCreator(Person creator) {
        return dbt.isCreator(creator);
    }

    @Override
    public HashMap<Person,HashMap<Person,Double>> getBill() {
        //Maakt een map aan
        HashMap<Person, HashMap<Person, Double>> bill = new HashMap<Person, HashMap<Person, Double>>();
        //Sorteer de database en laat iedereen betalen
        this.dbp.sortDatabase();
        ArrayList<Person> plist = this.dbp.getDbp();
        ArrayList<Person> rplist = this.dbp.getDbpReversed();
        for (Person p : plist) {
            HashMap<Person, Double> persondebt = new HashMap<Person, Double>();
            if (p.getAmountPaid() != 0) {
                //De persoon moet nog betalen of geld krijgen
                //Aangezien de lijst gesorteerd is, kan je nooit een persoon met een positief bedrag
                //tegenkomen --> alleen maar betalen
                for (Person p2 : rplist) {
                    if (p2.getAmountPaid() >= -p.getAmountPaid()) {
                        //zet in een map dat p aan p2 betaalt
                        persondebt.put(p2, -p.getAmountPaid());
                        //p betaalt al zijn schulden aan p2
                        p2.setAmountPaid(p2.getAmountPaid() + p.getAmountPaid());
                        p.setAmountPaid(0.0);
                        break;
                    } else {
                        //zet in een map dat p aan p2 betaalt
                        persondebt.put(p2, p2.getAmountPaid());
                        //p betaalt een deel van zijn schulden aan p2
                        p.setAmountPaid(p.getAmountPaid() + p2.getAmountPaid());
                        p2.setAmountPaid(0.0);
                    }
                }
                bill.put(p, persondebt);
                persondebt = null;
            }
        }
        return bill;
    }

    @Override
    public void clearDatabase() {
        dbp.clearDatabase();
        dbt.clearDatabase();
    }

    @Override
    public void addObserver() {
        ObserverTicket observerTicket = new ObserverTicket();
        dbt.addObserver(observerTicket);
    }
}