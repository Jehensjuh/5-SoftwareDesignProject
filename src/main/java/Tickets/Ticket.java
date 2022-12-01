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
    protected String ticketName; //a name given to a certain instance of a ticket eg. "Quick" for restaurant ticket.

    public Ticket(Person creator, double amountUpfront, TicketTypes type, String name){
        this.amountUpfront= amountUpfront;
        this.creator = creator;
        this.type = type;
        this.payers = new HashMap<Person, Double>();
        this.payers.put(creator,-amountUpfront); //creator pays upfront so his balance becomes -amountUpfront
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
        ArrayList<Person> payerPeople = new ArrayList<Person>();
        payerPeople.addAll(payers.keySet());
        return payerPeople;
    }

    public void addPayer(Person person, double amount){
        payers.put(person,amount);
    }

    public Double getAmount(Person person){
        return payers.get(person); //gives back value linked to person
    }

    public void removePayer(Person person){
        payers.remove(person);
    }
    //use?
    public List<Double> getAllAmounts(){
        ArrayList<Double> amounts = new ArrayList<Double>();
        for(Person i : payers.keySet()){
            amounts.add(payers.get(i));
        }
        return amounts;
    }
}
