package Tickets;

import Person.Person;

public class EvenTicket extends Ticket {


    public EvenTicket(Person creator, double amountUpfront, TicketTypes type, String name) {
        super(creator, amountUpfront, type, name);
    }
    /**
     * method calculates the amount each person has to pay and updates their balance in the payers hashmap of this ticket.
     */
    @Override
    public void divideBill() {
        double amountOfPayers = this.payers.size(); //Do not forget the creator!!!!!!!!
        double amountDue = this.amountUpfront / amountOfPayers; //amount everyone has to pay
        payers.put(this.creator, this.amountUpfront - amountDue);
        for (Person i : payers.keySet()) {//maybe add a .getname
            if (i != this.creator)
            {
                payers.put(i, -amountDue); //each person has to pay their init 0 - amount due
            }
        }
    }
}
