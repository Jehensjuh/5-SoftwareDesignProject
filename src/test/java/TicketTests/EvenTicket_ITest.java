package TicketTests;

import Controller.Controller;
import Controller.DatabaseController;
import Database.Database;
import Database.TicketDatabase;
import Database.PersonDatabase;
import Factory.TicketFactory;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class EvenTicket_ITest {

    PersonDatabase pdb = PersonDatabase.getInstance();
    TicketDatabase tdb = TicketDatabase.getInstance();
    Person p1 = new Person("Jan");
    Person p2 = new Person("An");
    Person p3 = new Person("Bob");
    Controller controller = new DatabaseController();


    public EvenTicket_ITest(){

    }
    @Before
    public void Initialize(){
        TicketFactory f = new TicketFactory();
        Ticket t = f.getTicket(p1,90, TicketTypes.AirplaneTicket,"air");
        //t.addPayer(p1);
        t.addPayer(p2);
        t.addPayer(p3);
        controller.addEntry(t);
    }

    @Test
    public void t_DivideBill(){
        //controller.getTicket("Jan","air").divideBill();
        System.out.println(controller.getTicket("Jan","air").getAmount(p1));
        assertThat("testing amount debt",90 == controller.getTicket("Jan","air").getAmount(p1));
        assertThat("testing amount debt",-45 == controller.getTicket("Jan","air").getAmount(p2));
        assertThat("testing amount debt",-45 == controller.getTicket("Jan","air").getAmount(p3));
    }
}
