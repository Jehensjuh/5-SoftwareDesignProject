package Tickets;

import Person.Person;

import java.util.ArrayList;

public class UnevenTicket extends Ticket{


    public UnevenTicket(Person creator, double amountUpfront, TicketTypes type, String name) {
        super(creator, amountUpfront, type, name);
    }

    /**
     * method calculates the amount each person has to pay and updates their balance in the payers hashmap of this ticket.
     */
    @Override
    public void divideBill() {
    //alle mensen die al een value hebben moeten niets meer betalen. totaal - bedragen al betaald / mensen die nog niets betaald hebben = bedrag dat mensen die nog niets betaald hebben moeten betalen
        double amountDue = 0.0;
        double tempValue = this.amountUpfront;
        ArrayList<Person> indebted = new ArrayList<Person>();
        for(Person i : payers.keySet()){
            if(payers.get(i) == 0.0){ //if the person in question hasn't paid anything yet
                indebted.add(i);    //name get's added to the list
            }
            else{
                if(i != this.creator){ //creator has paid upfront so value does not have to change
                    tempValue -= payers.get(i); //total amount of debt decreases because a bit was already paid back
                    payers.put(i, payers.get(i) * -1); //person has paid this amount so their value becomes a negative one now (used for further computations)
                }
            }
        }
        amountDue = tempValue/indebted.size(); //remainder of debt get's evenly devided over all remaining persons
        for(Person i:indebted){
            payers.put(i,payers.get(i) - amountDue); //these people have paid 0, so 0 - amountDue leaves a negative balance
        }
    }
}
