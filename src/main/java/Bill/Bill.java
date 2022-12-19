package Bill;

import Database.PersonDatabase;
import Database.TicketDatabase;
import Person.Person;
import Tickets.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Bill {
    public Bill(){}

    //Berekent rekening
    public static HashMap<Person,HashMap<Person,Double>> getBill(PersonDatabase pdb)
    {
        //Maakt een map aan
        HashMap<Person,HashMap<Person,Double>> bill = new HashMap<Person,HashMap<Person,Double>>();
        //Sorteer de database en laat iedereen betalen
        pdb.sortDatabase();
        ArrayList<Person> plist = pdb.getDbp();
        ArrayList<Person> rplist = pdb.getDbpReversed();
        for(Person p:plist)
        {
            HashMap<Person,Double> persondebt = new HashMap<Person,Double>();
            if(p.getAmountPaid() != 0)
            {
                //De persoon moet nog betalen of geld krijgen
                //Aangezien de lijst gesorteerd is, kan je nooit een persoon met een positief bedrag
                //tegenkomen --> alleen maar betalen
                for(Person p2:rplist)
                {
                    if(p2.getAmountPaid() >= -p.getAmountPaid())
                    {
                        //zet in een map dat p aan p2 betaalt
                        persondebt.put(p2,-p.getAmountPaid());
                        //p betaalt al zijn schulden aan p2
                        p2.setAmountPaid(p2.getAmountPaid()+p.getAmountPaid());
                        p.setAmountPaid(0.0);
                        break;
                    }
                    else
                    {
                        //zet in een map dat p aan p2 betaalt
                        persondebt.put(p2,p2.getAmountPaid());
                        //p betaalt een deel van zijn schulden aan p2
                        p.setAmountPaid(p.getAmountPaid()+p2.getAmountPaid());
                        p2.setAmountPaid(0.0);
                    }
                }
                bill.put(p,persondebt);
                persondebt = null;
            }
        }
        return bill;
    }
}