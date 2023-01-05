package Database;

import Person.Person;
import Tickets.EvenTicket;
import Tickets.Ticket;
import Tickets.TicketTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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
        ticket.divideBill();
        for(Person i: tD.keySet()){
            if(i == ticket.getCreator()){//if the person is already in the hashmap
                tD.get(i).add(ticket);//add the ticket to their arraylist
                return;//we're done here
            }
        }
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();//person is not yet in the hashmap so we need to create a new arraylist
        ticketList.add(ticket);//add the ticket to the arraylist
        tD.put(ticket.getCreator(),ticketList);//create new entry in the hashmap for this person
        //relay ticket to update the person
        setChanged();
        notifyObservers(ticket);
    }

    public ArrayList<Ticket> getTickets(Person creator){
        for(Person i:tD.keySet()){
            if(i == creator){
                return tD.get(creator);
            }
        }
        return new ArrayList<Ticket>(); //if the person is not in the hashmap return empty list (should be exception catch)
    }

    public HashMap<Person, ArrayList<Ticket>> getDatabase() {
        return tD;
    }

    public ArrayList<Person> getCreators(){
        return new ArrayList<Person>(tD.keySet());
    }

    public Ticket getTicket(String personName, String ticketName){
        Ticket returnTicket = new EvenTicket(new Person(personName),0, TicketTypes.ChooseTicket,"error");
        for(Person i:tD.keySet()){
            if(Objects.equals(i.getName(), personName)){
                ArrayList<Ticket> ticketList = tD.get(i);
                for(Ticket t:ticketList){
                    if(Objects.equals(t.getTicketName(), ticketName)){
                        returnTicket = t;
                    }
                }
            }
        }
        return returnTicket;
    }

    public double getAmountOfTickets(){//returns the amount of tickets that are in the database
        double ticketCounter = 0;
        if(!tD.isEmpty()){//if the database is not empty
            for(Person i:tD.keySet()){
                ticketCounter += tD.get(i).size();//add the amount of tickets in the ticketlist to ticketcounter
            }
        }
        //if the database is empty we will return 0
        return ticketCounter;
    }

    public boolean isCreator(Person creator){
        for(Person i:tD.keySet()){
            if(i == creator){
                return true;
            }
        }
        return false;
    }

    //returns all tickets linked to a person
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

    @Override
    public void clearDatabase()
    {
        tD.clear();
    }

}
