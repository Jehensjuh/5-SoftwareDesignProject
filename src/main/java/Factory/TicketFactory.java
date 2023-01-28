package Factory;

import Person.Person;
import Tickets.EvenTicket;
import Tickets.Ticket;
import Tickets.TicketTypes;
import Tickets.UnevenTicket;

public class TicketFactory {

    //checks whether the tickettype is even
    public boolean isEven(TicketTypes type){
        switch(type){
            case TaxiTicket: return true;
            case RestaurantTicket: return false;
            case AirplaneTicket: return true;
            case ConcertTicket: return true;
            case ChooseTicket: return false;
        }
        return false;
    }
    public Ticket getTicket(Person creator, double amountUpfront, TicketTypes type, String name){
        switch(type){
            case TaxiTicket: return new EvenTicket(creator, amountUpfront, type, name);
            case RestaurantTicket: return new UnevenTicket(creator,amountUpfront,type, name);
            case AirplaneTicket: return new EvenTicket(creator,amountUpfront,type, name);
            case ConcertTicket: return new EvenTicket(creator,amountUpfront,type, name);
            case ChooseTicket: return new UnevenTicket(creator,amountUpfront,type, name);
        }
        return new UnevenTicket(creator,amountUpfront,type, "error");
    }
}
