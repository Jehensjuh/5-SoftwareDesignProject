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
                if(i != this.creator){ //creator has paid upfront so value does not have to change
                    tempValue -= this.getAmount(i); //total amount of debt decreases because a bit was already paid back
                    payers.put(i, -this.getAmount(i)); //person has paid this amount so their value becomes a negative one now (used for further computations)
                }
//                else
//                {
//                    tempValue -= this.getAmount(i); // tempValue = tempValue - amount of creator???? that would leave a negative value or 0 depending on who comes first in list??
//                    payers.put(i,amountUpfront-this.getAmount(i)); //creator should not be in payers
//                }
            }
        }
        double amountDue = tempValue/(indebted.size()+1); //remainder of debt gets evenly divided over all remaining payers (and the creator, they have to pay too!)
        double creatorAmount = tempValue - amountDue; //the creator also has to pay, so the amount he expects from other people is the amount that hasn't been paid yet - his own share
        this.creator.setAmountPaid(creatorAmount);//Alexander is this correct?? maybe we should update the amountupfront so everything stays within ticket?, this way you could extract the amountupfront from the ticket later
        for(Person i:indebted)
        {
            if(i != this.creator)//just to be sure
            {
                payers.put(i,-amountDue); //these people have paid 0, so 0 - amountDue leaves a negative balance
            }
        }
    }
}
