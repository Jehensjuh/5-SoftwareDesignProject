package Tickets;

import Person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Ticket {
    protected Person creator;
    protected double amountUpfront;
    protected TicketTypes type;
    protected HashMap<Person, Double> payers;
    //a name given to a certain instance of a ticket eg. "Quick" for restaurant ticket.
    protected String ticketName;

    public Ticket(Person creator, double amountUpfront, TicketTypes type, String name){
        this.amountUpfront= amountUpfront;
        this.creator = creator;
        this.type = type;
        this.payers = new HashMap<Person, Double>();
        this.ticketName = name;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public abstract void divideBill();

    public Person getCreator() {
        return creator;
    }

    public double getAmountUpfront() {
        return amountUpfront;
    }

    public TicketTypes getType() {
        return type;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public void setAmountUpfront(double amountUpfront) {
        this.amountUpfront = amountUpfront;
    }

    public List<Person> getPayers(){
        return new ArrayList<Person>(payers.keySet());
    }

    public void addPayer(Person person, double amount){
        payers.put(person,amount);
    }

    public void addPayer(Person person) {payers.put(person,0.0);}

    public Double getAmount(Person person){
        return payers.get(person); //gives back value linked to person
    }

    public void removePayer(Person person){
        payers.remove(person);
    }
}
