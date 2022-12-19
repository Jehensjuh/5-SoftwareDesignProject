package BillTests;

import Controller.Controller;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Controller.DatabaseController;
import Factory.TicketFactory;
import Observers.ObserverTicket;
import Person.Person;
import Tickets.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static Tickets.TicketTypes.RestaurantTicket;
import static Tickets.TicketTypes.TaxiTicket;
import static org.hamcrest.MatcherAssert.assertThat;

public class Bill_UTest {
    PersonDatabase dbp = PersonDatabase.getInstance();
    TicketDatabase dbt = TicketDatabase.getInstance();
    Person p1 = new Person("An");
    Person p2 = new Person("Bob");
    Person p3 = new Person("Charles");
    Person p4 = new Person("Dirk");
    TicketFactory f = new TicketFactory();
    Ticket t1 = f.getTicket(p1,120, TaxiTicket,"Taxi");
    Ticket t2 = f.getTicket(p2, 500, RestaurantTicket, "Restaurant");
    Ticket t3 = f.getTicket(p4, 700, RestaurantTicket, "Restaurant2");
    ObserverTicket observerTicket = new ObserverTicket();
    Controller controller = new DatabaseController();

    public Bill_UTest() {}

    @Before
    public void Initialize()
    {
        dbt.addObserver(observerTicket);
        controller.addPerson(p1);
        controller.addPerson(p2);
        controller.addPerson(p3);
        controller.addPerson(p4);
        //Ticket1
        t1.addPayer(p1);
        t1.addPayer(p2);
        t1.addPayer(p3);
        t1.addPayer(p4);
        controller.addEntry(t1);
        //Ticket2
        t2.addPayer(p1);
        t2.addPayer(p2);
        t2.addPayer(p3,200);
        t2.addPayer(p4);
        controller.addEntry(t2);
        //Ticket3
        t3.addPayer(p1);
        t3.addPayer(p2,180);
        t3.addPayer(p3);
        t3.addPayer(p4,100);
        controller.addEntry(t3);
    }

    @Test
    public void present()
    {
        assertThat("Correct amountPaid",-220 == p1.getAmountPaid());
        assertThat("Correct amountPaid",190 == p2.getAmountPaid());
        assertThat("Correct amountPaid",-440 == p3.getAmountPaid());
        assertThat("Correct amountPaid",470 == p4.getAmountPaid());
        HashMap<Person, HashMap<Person,Double>> bill = controller.getBill();
        assertThat("Bill correct", ((bill.get(p1).get(p4) == 30) && (bill.get(p1).get(p2) == 190)));
        assertThat("Bill correct", bill.get(p3).get(p4) == 440);
    }
}