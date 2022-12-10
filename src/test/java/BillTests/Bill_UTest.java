package BillTests;

import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.TicketFactory;
import Observers.ObserverTicket;
import Person.Person;
import Tickets.Ticket;
import org.junit.Before;
import org.junit.Test;
import Bill.Bill;

import static Tickets.TicketTypes.RestaurantTicket;
import static Tickets.TicketTypes.TaxiTicket;
import static org.hamcrest.MatcherAssert.assertThat;

public class Bill_UTest {
    PersonDatabase dbp = PersonDatabase.getInstance();
    TicketDatabase dbt = TicketDatabase.getInstance();
    Person p1 = new Person("Jan");
    Person p2 = new Person("An");
    Person p3 = new Person("Bob");
    TicketFactory f = new TicketFactory();
    Ticket t1 = f.getTicket(p1,120, TaxiTicket,"Taxi");
    Ticket t2 = f.getTicket(p2, 300, RestaurantTicket, "Restaurant");
    ObserverTicket observerTicket = new ObserverTicket();

    Bill finalBill = new Bill(dbp,dbt);

    public Bill_UTest() {}

    @Before
    public void Initialize()
    {
        dbt.addObserver(observerTicket);
        dbp.addPerson(p1);
        dbp.addPerson(p2);
        dbp.addPerson(p3);
        t1.addPayer(p1);
        t1.addPayer(p2);
        t1.addPayer(p3);
        t1.divideBill();
        dbt.addEntry(t1);
        t2.addPayer(p1);
        t2.addPayer(p2);
        t2.addPayer(p3,200);
        t2.divideBill();
        dbt.addEntry(t2);
    }

    @Test
    public void present()
    {
        assertThat("Correct amountPaid",30 == p1.getAmountPaid());
        assertThat("Correct amountPaid",210 == p2.getAmountPaid());
        assertThat("Correct amountPaid",-240 == p3.getAmountPaid());
        System.out.println(finalBill.getBill());
    }
}