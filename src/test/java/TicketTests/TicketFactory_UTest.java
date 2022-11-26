package TicketTests;

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

public class TicketFactory_UTest {
    Person p = new Person("Jan");
    TicketFactory f = new TicketFactory();
    Ticket restaurantTicket = f.getTicket(p, 100, TicketTypes.RestaurantTicket);
    Ticket taxiTicket = f.getTicket(p, 10, TicketTypes.TaxiTicket);
    public TicketFactory_UTest(){

    }

    @Before
    public void initialize(){

    }

    @Test
    public void t_addTicket(){
        //isright type?
        assertEquals("Testing ticket type restaurant",TicketTypes.RestaurantTicket, restaurantTicket.getType());
        assertEquals("Testing ticket type taxi",TicketTypes.TaxiTicket, taxiTicket.getType());

        //is right creator?
        assertEquals("Testing creator restaurant", p, restaurantTicket.getCreator());
        assertEquals("Testing creator taxi", p, taxiTicket.getCreator());

        //is right amountUpFront?
        assertThat("testing amountupfront",100 == restaurantTicket.getAmountUpfront());
        assertThat("testing amountupfront",10 == taxiTicket.getAmountUpfront());

        //Are the tickets from the correct subclass?
        assertThat(restaurantTicket, instanceOf(UnevenTicket.class));
        assertThat(taxiTicket, instanceOf(EvenTicket.class));
    }

}
