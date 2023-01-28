package BillTests;

import Controller.Controller;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Controller.DatabaseController;
import Factory.TicketFactory;
import Person.Person;
import Tickets.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static Tickets.TicketTypes.RestaurantTicket;
import static Tickets.TicketTypes.TaxiTicket;
import static org.hamcrest.MatcherAssert.assertThat;

public class Bill_ITest {
    PersonDatabase dbp = PersonDatabase.getInstance();
    TicketDatabase dbt = TicketDatabase.getInstance();
    Person p1 = new Person("An");
    Person p2 = new Person("Bob");
    Person p3 = new Person("Charles");
    Person p4 = new Person("Dirk");
    TicketFactory f = new TicketFactory();
    Ticket t1 = f.getTicket(p1,120, TaxiTicket,"Taxi");
    Ticket t2 = f.getTicket(p2, 500, RestaurantTicket, "Restaurant");
    Ticket t3 = f.getTicket(p3, 700, RestaurantTicket, "Restaurant2");
    Ticket t4 = f.getTicket(p4, 500, RestaurantTicket, "Restaurant3");
    Controller controller = new DatabaseController();

    public Bill_ITest() {}

    @Before
    public void Initialize()
    {
        controller.clearDatabase();
        controller.addObserver();
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
        t3.addPayer(p2,200);
        t3.addPayer(p4,100);
        controller.addEntry(t3);
        //Ticket4
        t4.addPayer(p1);
        t4.addPayer(p2);
        t4.addPayer(p3);
        t4.addPayer(p4,400);
        controller.addEntry(t4);
    }

    @Test
    public void present()
    {
        assertThat("Correct amountPaid",-443.33 == p1.getAmountPaid());
        assertThat("Correct amountPaid",136.67 == p2.getAmountPaid());
        assertThat("Correct amountPaid",436.67 == p3.getAmountPaid());
        assertThat("Correct amountPaid",-130 == p4.getAmountPaid());
        HashMap<Person, HashMap<Person,Double>> bill = controller.getBill();
        assertThat("Bill correct", (bill.get(p1).get(p3) == 436.67 && bill.get(p1).get(p2) == 6.66));
        assertThat("Bill correct", (bill.get(p4).get(p2) == 130));
        /*assertThat("Correct amountPaid",-33.33 == p1.getAmountPaid());
        assertThat("Correct amountPaid",-33.33 == p2.getAmountPaid());
        assertThat("Correct amountPaid",-33.33 == p3.getAmountPaid());
        assertThat("Correct amountPaid",100 == p4.getAmountPaid());
        HashMap<Person, HashMap<Person,Double>> bill = controller.getBill();
        assertThat("Bill correct", (bill.get(p1).get(p4) == 33.33));
        assertThat("Bill correct", (bill.get(p2).get(p4) == 33.33));
        assertThat("Bill correct", (bill.get(p3).get(p4) == 33.33));*/
    }
}