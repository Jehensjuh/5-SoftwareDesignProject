package TicketTests;

import Person.Person;
import Tickets.EvenTicket;
import Tickets.Ticket;
import Tickets.TicketTypes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class EvenTicket_UTest {

    public EvenTicket_UTest(){

    }

    @Before
    public void initialize(){

    }

    @Test
    public void t_EvenTicket(){
        Person p = new Person("Jan");
        Ticket even = new EvenTicket(p,100, TicketTypes.AirplaneTicket,"airplane");
        assertEquals("Testing ticket type",TicketTypes.AirplaneTicket, even.getType());
        assertEquals("Testing ticket creator",p,even.getCreator());
        assertThat("testing amountupfront",100 == even.getAmountUpfront());
        assertEquals("testing ticket name", "airplane",even.getTicketName());
    }


}
