package Factory;

import Person.Person;
import Tickets.EvenTicket;
import Tickets.Ticket;
import Tickets.TicketTypes;
import Tickets.UnevenTicket;

public class TicketFactory {

    public boolean isEven(TicketTypes type){
        switch(type){
            case TaxiTicket:
            case AirplaneTicket:
            case ConcertTicket:
                return true;
            case RestaurantTicket:
            case OtherTicket:
                return false;
        }
        return false;
    }
    public Ticket getTicket(Person creator, double amountUpfront, TicketTypes type, String name){
        switch(type){
            case TaxiTicket:
            case AirplaneTicket:
            case ConcertTicket:
                return new EvenTicket(creator, amountUpfront, type, name);
            case RestaurantTicket:
            case OtherTicket:
                return new UnevenTicket(creator,amountUpfront,type, name);
        }
        return new UnevenTicket(creator,amountUpfront,type, "error");
    }
}
