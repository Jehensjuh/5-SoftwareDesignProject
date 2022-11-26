package TicketTests;

import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;
import Tickets.UnevenTicket;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class UnevenTicket_UTest {
    public UnevenTicket_UTest(){

    }

    @Before
    public void initialize(){

    }

    @Test
    public void t_UnevenTicket(){
        Person p = new Person("Jan");
        Ticket even = new UnevenTicket(p,100, TicketTypes.RestaurantTicket,"restaurant");
        assertEquals("Testing ticket type",TicketTypes.RestaurantTicket, even.getType());
        assertEquals("Testing ticket creator",p,even.getCreator());
        assertThat("testing amountupfront",100 == even.getAmountUpfront());
        assertEquals("testing ticket name", "restaurant",even.getTicketName());
    }
}
