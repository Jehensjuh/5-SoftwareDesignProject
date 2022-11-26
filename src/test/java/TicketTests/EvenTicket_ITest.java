package TicketTests;

import Database.Database;
import Database.TicketDatabase;
import Factory.TicketFactory;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class EvenTicket_ITest {
    TicketDatabase db = TicketDatabase.getInstance();
    Person p1 = new Person("Jan");
    Person p2 = new Person("An");
    Person p3 = new Person("Bob");
    public EvenTicket_ITest(){

    }
    @Before
    public void Initialize(){
        TicketFactory f = new TicketFactory();
        Ticket t = f.getTicket(p1,90, TicketTypes.AirplaneTicket,"air");
        t.addPayer(p2,0);
        t.addPayer(p3,0);
        db.addEntry(p1,t);
    }

    @Test
    public void t_DivideBill(){
        db.getTicket("Jan","air").divideBill();
        assertThat("testing amount debt",-90 == db.getTicket("Jan","air").getAmount(p1));
        assertThat("testing amount debt",-30 == db.getTicket("Jan","air").getAmount(p2));
        assertThat("testing amount debt",-30 == db.getTicket("Jan","air").getAmount(p3));
    }
}
