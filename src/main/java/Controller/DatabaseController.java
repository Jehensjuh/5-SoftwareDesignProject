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
    public boolean nameInDatabase(String name) {
        return dbp.nameInDatabase(name);
    }

    @Override
    public void addEntry(Ticket ticket) {
        dbt.addEntry(ticket);
    }

    @Override
    public Ticket getTicket(String personName, String ticketName) {
        return dbt.getTicket(personName, ticketName);
    }

    @Override
    public HashMap<Person,HashMap<Person,Double>> getBill() {
        //makes a map
        HashMap<Person, HashMap<Person, Double>> bill = new HashMap<Person, HashMap<Person, Double>>();
        //sorts the database
        ArrayList<Person> plist = this.dbp.getDbpSorted();
        ArrayList<Person> rplist = this.dbp.getDbpReversed();
        for (Person p : plist) {
            HashMap<Person, Double> persondebt = new HashMap<Person, Double>();
            for (Person p2 : rplist) {
                if (p.getAmountPaid() < -0.01) {
                    if (p2.getAmountPaid() >= -p.getAmountPaid()) {
                        double roundedDebt = Math.round(p.getAmountPaid()*100);
                        persondebt.put(p2, -roundedDebt/100);
                        //p pays everything to p2
                        p2.setAmountPaid(p2.getAmountPaid() + p.getAmountPaid());
                        p.setAmountPaid(0.0);
                        break;
                    }
                    else if (p2.getAmountPaid() > 0.01){
                        double roundedDebt = Math.round(p2.getAmountPaid()*100);
                        persondebt.put(p2, roundedDebt/100);
                        //p pays a part to p2
                        p.setAmountPaid(p.getAmountPaid() + p2.getAmountPaid());
                        p2.setAmountPaid(0.0);
                    }
                }
                else
                {
                    p.setAmountPaid(0.0);
                }
            }
            bill.put(p, persondebt);
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