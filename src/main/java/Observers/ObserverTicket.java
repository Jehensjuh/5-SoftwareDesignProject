package Observers;

import Database.Database;
import Database.TicketDatabase;

import java.util.Observable;
import java.util.Observer;

public class ObserverTicket implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        //Gebruik het ticket dat doorgegeven is om de amountPaid van elke persoon up te daten
    }
}
