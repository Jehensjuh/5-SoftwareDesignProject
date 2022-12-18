package TicketTests;

import Controller.Controller;
import Database.TicketDatabase;
import Database.PersonDatabase;
import Controller.DatabaseController;
import Factory.TicketFactory;
import Person.Person;
import Tickets.EvenTicket;
import Tickets.Ticket;
import Tickets.TicketTypes;
import Tickets.UnevenTicket;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TicketFactory_ITest {
    TicketFactory f = new TicketFactory();
    TicketDatabase tdb = TicketDatabase.getInstance();
    PersonDatabase pdb = PersonDatabase.getInstance();
    Person p1 = new Person("Jan");
    Person p2 = new Person("Karlijn");

    Controller controller = new DatabaseController(pdb, tdb);
    public TicketFactory_ITest(){

    }

    @Before
    public void Initialize(){

        Ticket restaurantTicket = f.getTicket(p1, 100, TicketTypes.RestaurantTicket, "Restaurant 1");
        Ticket taxiTicket = f.getTicket(p2, 10, TicketTypes.TaxiTicket, "Taxi 1");
        controller.addEntry(restaurantTicket);
        controller.addEntry(taxiTicket);
    }

    @Test
    public void t_isEven(){
        assertThat("testing restaurant ticket for being uneven", !f.isEven(controller.getTicket("Jan", "Restaurant 1").getType()));
        assertThat("testing taxi ticket for being even", f.isEven(controller.getTicket("Karlijn","Taxi 1").getType()));
    }
    @Test
    public void t_addTicket(){
        //isright type?
        assertEquals("Testing ticket type restaurant",TicketTypes.RestaurantTicket, controller.getTicket("Jan","Restaurant 1").getType());
        assertEquals("Testing ticket type taxi",TicketTypes.TaxiTicket, controller.getTicket("Karlijn","Taxi 1").getType());

        //is right creator?
        assertEquals("Testing creator restaurant",p1 , controller.getTicket("Jan","Restaurant 1").getCreator());
        assertEquals("Testing creator taxi", p2, controller.getTicket("Karlijn","Taxi 1").getCreator());

        //is right amountUpFront?
        assertThat("testing amountupfront",100 == controller.getTicket("Jan","Restaurant 1").getAmountUpfront());
        assertThat("testing amountupfront",10 == controller.getTicket("Karlijn","Taxi 1").getAmountUpfront());

        //Are the tickets from the correct subclass?
        assertThat(controller.getTicket("Jan","Restaurant 1"), instanceOf(UnevenTicket.class));
        assertThat(controller.getTicket("Karlijn","Taxi 1"), instanceOf(EvenTicket.class));
    }

}
