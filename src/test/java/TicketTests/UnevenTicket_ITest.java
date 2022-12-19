package TicketTests;

import Database.TicketDatabase;
import Controller.Controller;
import Controller.DatabaseController;
import Database.Database;
import Database.PersonDatabase;
import Factory.TicketFactory;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class UnevenTicket_ITest {
    PersonDatabase pdb = PersonDatabase.getInstance();
    TicketDatabase tdb = TicketDatabase.getInstance();
    Person p1 = new Person("Jan");
    Person p2 = new Person("An");
    Person p3 = new Person("Bob");
    Person p4 = new Person("Tim");

    Controller controller = new DatabaseController();

    public UnevenTicket_ITest(){

    }

    @Before
    public void Initialize(){
        TicketFactory f = new TicketFactory();
        Ticket t1 = f.getTicket(p1,100, TicketTypes.RestaurantTicket,"rest");
        t1.addPayer(p1,20);
        t1.addPayer(p2,10);
        t1.addPayer(p3);
        t1.addPayer(p4);
        controller.addEntry(t1);
        Ticket t2 = f.getTicket(p2, 200, TicketTypes.RestaurantTicket, "rest2");
        t2.addPayer(p1,30);
        t2.addPayer(p2);
        t2.addPayer(p3);
        t2.addPayer(p4,70);
        controller.addEntry(t2);
    }

    @Test
    public void t_DivideBill(){
        assertThat("testing amount debt",80 == controller.getTicket("Jan","rest").getAmount(p1));
        assertThat("testing amount debt",-10 == controller.getTicket("Jan","rest").getAmount(p2));
        assertThat("testing amount debt",-35 == controller.getTicket("Jan","rest").getAmount(p3));
        assertThat("testing amount debt",-35 == controller.getTicket("Jan","rest").getAmount(p4));

        assertThat("testing amount debt",-30 == controller.getTicket("An","rest2").getAmount(p1));
        assertThat("testing amount debt",150 == controller.getTicket("An","rest2").getAmount(p2));
        assertThat("testing amount debt",-50 == controller.getTicket("An","rest2").getAmount(p3));
        assertThat("testing amount debt",-70 == controller.getTicket("An","rest2").getAmount(p4));

    }
}
