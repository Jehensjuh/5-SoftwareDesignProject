package TicketTests;

import Database.TicketDatabase;
import Factory.TicketFactory;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class UnevenTicket_ITest {
    TicketDatabase db = TicketDatabase.getInstance();
    Person p1 = new Person("Jan");
    Person p2 = new Person("An");
    Person p3 = new Person("Bob");
    Person p4 = new Person("Tim");

    public UnevenTicket_ITest(){

    }

    @Before
    public void Initialize(){
        TicketFactory f = new TicketFactory();
        Ticket t = f.getTicket(p1,100, TicketTypes.RestaurantTicket,"rest");
        t.addPayer(p2,10);
        t.addPayer(p3,0);
        t.addPayer(p4,0);
        db.addEntry(p1,t);
    }

    @Test
    public void t_DivideBill(){
        db.getTicket("Jan","rest").divideBill();
        assertThat("testing amount debt",-100 == db.getTicket("Jan","rest").getAmount(p1));
        assertThat("testing amount debt",-10 == db.getTicket("Jan","rest").getAmount(p2));
        assertThat("testing amount debt",-45 == db.getTicket("Jan","rest").getAmount(p3));
        assertThat("testing amount debt",-45 == db.getTicket("Jan","rest").getAmount(p4));

    }
}
