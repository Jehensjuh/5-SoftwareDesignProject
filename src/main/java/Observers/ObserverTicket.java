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
        //Update de personen
        double current;
        for(Person p : t.getPayers())
        {
            current = p.getAmountPaid();
            p.setAmountPaid(t.getAmount(p) + current);
        }
    }
}
