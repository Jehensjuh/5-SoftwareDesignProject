package Observers;

import Person.Person;
import Tickets.Ticket;

import java.util.Observable;
import java.util.Observer;

public class ObserverTicket implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        //uses the ticket to updaye amountPaid of every person
        Ticket t = (Ticket) arg;
        double current;
        for(Person p : t.getPayers())
        {
            current = p.getAmountPaid();
            double roundedAmount =  Math.round(t.getAmount(p)*100) + current*100;
            p.setAmountPaid(roundedAmount/100);
        }
    }
}
