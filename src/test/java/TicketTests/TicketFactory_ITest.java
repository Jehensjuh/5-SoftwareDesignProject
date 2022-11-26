package TicketTests;

import Database.TicketDatabase;
import Factory.TicketFactory;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TicketFactory_ITest {
    TicketDatabase db = TicketDatabase.getInstance();
    public TicketFactory_ITest(){

    }

    @Before
    public void Initialize(){
        Person p1 = new Person("Jan");
        Person p2 = new Person("Karlijn");
        Person p3 = new Person("Bob");
        TicketFactory f = new TicketFactory();
        Ticket restaurantTicket = f.getTicket(p1, 100, TicketTypes.RestaurantTicket, "Restaurant 1");
        Ticket taxiTicket = f.getTicket(p2, 10, TicketTypes.TaxiTicket, "Taxi 1");
        db.addEntry(p1, restaurantTicket);
        db.addEntry(p2, taxiTicket);
        restaurantTicket.addPayer(p2,30);
        restaurantTicket.addPayer(p3, 0);
        taxiTicket.addPayer(p1,0);
        taxiTicket.addPayer(p2,0);
    }

    @Test
    public void t_isEven(){
        assertThat("testing restaurant ticket for being uneven", ;);
        assertThat("testing taxi ticket for being even", f.isEven(taxiTicket.getType()));
    }

}
