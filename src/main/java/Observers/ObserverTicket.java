package Observers;

import Database.Database;
import Database.TicketDatabase;
import Database.PersonDatabase;
import Tickets.Ticket;
import Person.Person;

import java.util.Observable;
import java.util.Observer;

public class ObserverTicket implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        //Gebruik het ticket dat doorgegeven is om de amountPaid van elke persoon up te daten
        Ticket t = (Ticket) arg;
        //Update creator
        double current = t.getCreator().getAmountPaid();
        t.getCreator().setAmountPaid(-t.getAmountUpfront() + current);
        //Update de rest
        for(Person p : t.getPayers())
        {
            if(p!=t.getCreator())
            {
                current = p.getAmountPaid();
                p.setAmountPaid(t.getAmount(p) + current);
            }
        }
    }
}
