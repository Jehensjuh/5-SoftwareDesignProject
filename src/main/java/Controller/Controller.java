package Controller;

import Database.Database;
import Database.TicketDatabase;
import Factory.TicketFactory;
import Person.Person;
import Database.PersonDatabase;
import Tickets.Ticket;
import Tickets.TicketTypes;

public class Controller
{
    private TicketDatabase tdb;
    private PersonDatabase pdb;
    private TicketFactory f;

    public Controller(){
        this.tdb = TicketDatabase.getInstance();
        this.pdb = PersonDatabase.getInstance();
        this.f = new TicketFactory();
        this.run();
    }
    //Functie om de database af te drukken
//    void printPersonDatabase() {
//
//    }
    public void run(){
        //temporary untill gui is created
        //create people
        Person p1 = new Person("Alexander");
        Person p2 = new Person("Jens");
        Person p3 = new Person("Tom");
        //add people to the people database
        pdb.addPerson(p1);
        pdb.addPerson(p2);
        pdb.addPerson(p3);
        //create tickets
        Ticket evenTicket = f.getTicket(p1,100, TicketTypes.TaxiTicket,"ticket1");
        Ticket unevenTicket = f.getTicket(p2,100, TicketTypes.RestaurantTicket, "ticket2");
        //add payers
        evenTicket.addPayer(p2,0);
        evenTicket.addPayer(p3,0);
        unevenTicket.addPayer(p1,30);
        unevenTicket.addPayer(p3,0);
        //add tickets to database
        tdb.addEntry(evenTicket);
        tdb.addEntry(unevenTicket);
    }
}
