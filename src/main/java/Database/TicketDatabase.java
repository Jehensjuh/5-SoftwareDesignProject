package Database;

import Person.Person;
import Tickets.EvenTicket;
import Tickets.Ticket;
import Tickets.TicketTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Observable;

//database containing all created tickets and the person who created them.
public class TicketDatabase extends Observable {

    private final HashMap<Person, ArrayList<Ticket>> tD;
    private static TicketDatabase instance = null;

    private TicketDatabase(){
        this.tD = new HashMap<Person, ArrayList<Ticket>>();
    }

    //singleton
    public static TicketDatabase getInstance(){
        if (instance == null){
            instance = new TicketDatabase();
        }
        return instance;
    }

    public void addEntry(Ticket ticket) {
        ticket.divideBill(); //doet automitisch de berekening
        setChanged();
        notifyObservers(ticket);
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
    }

    public HashMap<Person, ArrayList<Ticket>> getDatabase() {
        return tD;
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

    public void clearDatabase()
    {
        tD.clear();
    }
}
