package Database;

import Person.Person;
import Tickets.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Override
    public void addEntry(Person creator, Ticket ticket) {
        for(Person i: tD.keySet()){
            if(i == creator){//if the person is already in the hashmap
                tD.get(i).add(ticket);//add the ticket to their arraylist
                return;//we're done here
            }
        }
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();//person is not yet in the hashmap so we need to create a new arraylist
        ticketList.add(ticket);//add the ticket to the arraylist
        tD.put(creator,ticketList);//create new entry in the hashmap for this person
    }

    public ArrayList<Ticket> getTickets(Person creator){
        for(Person i:tD.keySet()){
            if(i == creator){
                return tD.get(creator);
            }
        }
        return new ArrayList<Ticket>(); //if the person is not in the hashmap return empty list (should be exception catch)
    }

    public boolean isCreator(Person creator){
        for(Person i:tD.keySet()){
            if(i == creator){
                return true;
            }
        }
        return false;
    }

}
