package Database;

import Person.Person;
import Tickets.EvenTicket;
import Tickets.Ticket;
import Tickets.TicketTypes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

//Database containing all created Tickets and the Person who created them.
public class TicketDatabase extends Database{

    private final HashMap<Person, ArrayList<Ticket>> tD;
    private static TicketDatabase instance = null;

    private TicketDatabase(){
        this.tD = new HashMap<Person, ArrayList<Ticket>>();
    }

    public static TicketDatabase getInstance(){//singleton
        if (instance == null){
            instance = new TicketDatabase();
        }
        return instance;
    }

    public void addEntry(Ticket ticket) {
        for(Person i: tD.keySet()){
            if(i == ticket.getCreator()){//if the person is already in the hashmap
                tD.get(i).add(ticket);//add the ticket to their arraylist
                return;//we're done here
            }
        }
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();//person is not yet in the hashmap so we need to create a new arraylist
        ticketList.add(ticket);//add the ticket to the arraylist
        tD.put(ticket.getCreator(),ticketList);//create new entry in the hashmap for this person
        //Geef het ticket door om persoon up te daten
        Object objectTicket = ticket;
        setChanged();
        notifyObservers(objectTicket);
    }

    public ArrayList<Ticket> getTickets(Person creator){
        for(Person i:tD.keySet()){
            if(i == creator){
                return tD.get(creator);
            }
        }
        return new ArrayList<Ticket>(); //if the person is not in the hashmap return empty list (should be exception catch)
    }

    public ArrayList<Person> getCreators(){
        ArrayList<Person> personlist = new ArrayList<Person>();
        personlist.addAll(tD.keySet());
        return personlist;
    }

    public Ticket getTicket(String personName, String ticketName){
        Ticket returnTicket = new EvenTicket(new Person(personName),0, TicketTypes.OtherTicket,"error");
        for(Person i:tD.keySet()){
            if(i.getName() == personName){
                ArrayList<Ticket> ticketList = tD.get(i);
                for(Ticket t:ticketList){
                    if(t.getTicketName() == ticketName){
                        returnTicket = t;
                    }
                }
            }
        }
        return returnTicket;
    }

    public boolean isCreator(Person creator){
        for(Person i:tD.keySet()){
            if(i == creator){
                return true;
            }
        }
        return false;
    }

    /*
    //Een functie die al de tickets teruggeeft
    public ArrayList<Ticket> getAllTickets()
    {
        ArrayList<Ticket> allTickets = new ArrayList<Ticket>();
        for(Person p:tD.keySet())
        {
            for(Ticket t:tD.get(p))
            {
                allTickets.add(t);
            }
        }
        return allTickets;
    }
    */

    //Functie die al de tickets van de persoon geeft
    public ArrayList<Ticket> getInvolvedTickets(Person p) {
        ArrayList<Ticket> involvedTickets = new ArrayList<Ticket>();
        for (Person i : tD.keySet()) {
            for (Ticket t : tD.get(i)) {
                if (t.getCreator() == p) {
                    involvedTickets.add(t);
                } else {
                    for (Person payer : t.getPayers()) {
                        if (payer == p) {
                            involvedTickets.add(t);
                        }
                    }
                }
            }
        }
        return involvedTickets;
    }

}
