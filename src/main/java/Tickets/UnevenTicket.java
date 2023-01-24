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
    //uneven: people who paid upfront have already paid so they don't have to pay extra. The rest gets divided over all other members evenly
        double tempValue = this.amountUpfront;
        ArrayList<Person> indebted = new ArrayList<Person>();
        for(Person i : payers.keySet()){
            if(this.getAmount(i) == 0){ //if the person in question hasn't paid anything yet
                indebted.add(i);    //person gets added to the list
            }
            else{
                tempValue -= this.getAmount(i); //total amount of debt decreases because a bit was already paid back
                if(i != this.creator){ //creator has paid upfront so value does not have to change
                    payers.put(i, -this.getAmount(i)); //person has paid this amount so their value becomes a negative one now (used for further computations)
                }
                else
                {
                    payers.put(i,amountUpfront-this.getAmount(i));
                }
            }
        }
        double amountDue = tempValue/(indebted.size()); //remainder of debt gets evenly divided over all remaining payers
        for(Person i:indebted)
        {
            if(i != this.creator)
            {
                payers.put(i,-amountDue); //these people have paid 0, so 0 - amountDue leaves a negative balance
            }
            else
            {
                payers.put(i,amountUpfront-amountDue);
            }
        }
        if (!payers.containsKey(creator))
        {
            payers.put(this.creator, this.amountUpfront);
        }
    }
}
