package ObserverTests;

import Controller.Controller;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.TicketFactory;
import Observers.ObserverTicket;
import Controller.DatabaseController;
import Tickets.Ticket;
import Person.Person;
import org.junit.Before;
import org.junit.Test;

import static Tickets.TicketTypes.RestaurantTicket;
import static Tickets.TicketTypes.TaxiTicket;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonObserver_ITest {
    PersonDatabase dbp = PersonDatabase.getInstance();
    TicketDatabase dbt = TicketDatabase.getInstance();
    Person p1 = new Person("Jan");
    Person p2 = new Person("An");
    Person p3 = new Person("Bob");
    TicketFactory f = new TicketFactory();
    Ticket t1 = f.getTicket(p1,120, TaxiTicket,"Taxi");
    Ticket t2 = f.getTicket(p2, 300, RestaurantTicket, "Restaurant");
    ObserverTicket observerTicket = new ObserverTicket();
    Controller controller = new DatabaseController();

    public PersonObserver_ITest() {}

    @Before
    public void Initialize()
    {
        dbt.addObserver(observerTicket);
        controller.addPerson(p1);
        controller.addPerson(p2);
        controller.addPerson(p3);
        t1.addPayer(p1);
        t1.addPayer(p2);
        t1.addPayer(p3);
        controller.addEntry(t1);
        t2.addPayer(p1);
        t2.addPayer(p2);
        t2.addPayer(p3,200);
        controller.addEntry(t2);
    }

    @Test
    public void present()
    {
        assertThat("Correct amountPaid",30 == p1.getAmountPaid());
        assertThat("Correct amountPaid",210 == p2.getAmountPaid());
        assertThat("Correct amountPaid",-240 == p3.getAmountPaid());
    }
}