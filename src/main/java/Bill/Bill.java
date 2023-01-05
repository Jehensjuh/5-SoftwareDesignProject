package Bill;

import Database.PersonDatabase;
import Database.TicketDatabase;
import Person.Person;
import Tickets.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Bill {
    //this class is currently redundant
    public Bill(){}

    //Calculates Bill
    public static HashMap<Person,HashMap<Person,Double>> getBill(PersonDatabase pdb)
    {
        //Create hashmap storing a person and a hashmap containing the people they have debt towards and the amount of debt towards that person.
        HashMap<Person,HashMap<Person,Double>> bill = new HashMap<Person,HashMap<Person,Double>>();
        //sorts database and calculates debts
        pdb.sortDatabase();
        ArrayList<Person> plist = pdb.getDbp();
        ArrayList<Person> rplist = pdb.getDbpReversed();
        for(Person p:plist)
        {
            HashMap<Person,Double> persondebt = new HashMap<Person,Double>();
            if(p.getAmountPaid() != 0)//person still has to pay/receive money
            {
                //list is sorted so you can never come across a person with a positive value -> only paying
                for(Person p2:rplist)
                {
                    if(p2.getAmountPaid() >= -p.getAmountPaid())
                    {
                        //store that p pays p2
                        persondebt.put(p2,-p.getAmountPaid());
                        //p pays off debt
                        p2.setAmountPaid(p2.getAmountPaid()+p.getAmountPaid());
                        //no debt left
                        p.setAmountPaid(0.0);
                        break;
                    }
                    else
                    {
                        //store that p pays p2
                        persondebt.put(p2,p2.getAmountPaid());
                        //p pays part of it's debt to p2
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