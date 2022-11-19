package Factory;

import Person.Person;
import Tickets.EvenTicket;
import Tickets.Ticket;
import Tickets.TicketTypes;
import Tickets.UnevenTicket;

public class TicketFactory {

    public boolean isEven(TicketTypes type){
        switch(type){
            case TaxiTicket: return true;
            case RestaurantTicket: return true;
            case AirplaneTicket: return true;
            case ConcertTicket: return true;
            case OtherTicket: return true;
        }
        return false;
    }
    public Ticket getTicket(Person creator, double amountUpfront, TicketTypes type){
        switch(type){
            case TaxiTicket: return new EvenTicket(creator, amountUpfront, type);
            case RestaurantTicket: return new EvenTicket(creator,amountUpfront,type);
            case AirplaneTicket: return new EvenTicket(creator,amountUpfront,type);
            case ConcertTicket: return new EvenTicket(creator,amountUpfront,type);
            case OtherTicket: return new EvenTicket(creator,amountUpfront,type);
        }
        return new UnevenTicket(creator,amountUpfront,type);
    }
}
