package GUI;

import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.TicketFactory;
import GUI.CreateTicket.InitPanel;
import GUI.CreateTicket.TicketFrame;
import GUI.OpeningFrame.CreateTicketPanel;
import GUI.OpeningFrame.NameListPanel;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;

/*
Class that purely exists for debugging and running the GUI without running the project
 */
public class DebugRunner {
    MainFrame frame;
    PersonDatabase personDatabase;
    TicketDatabase ticketDatabase;
    TicketFactory f;
    public DebugRunner(){
        this.f = new TicketFactory();
        this.personDatabase = PersonDatabase.getInstance();
        this.ticketDatabase = TicketDatabase.getInstance();
        Person p1 = new Person("Jens");
        Person p2 = new Person("Alexander");
        Person p3 = new Person("Bob");
        Person p4 = new Person("An");
        personDatabase.addPerson(p1);
        personDatabase.addPerson(p2);
        personDatabase.addPerson(p3);
        personDatabase.addPerson(p4);
        Ticket t = f.getTicket(p1,200, TicketTypes.TaxiTicket,"ticket1");
        t.addPayer(p2,0);
        t.addPayer(p3,0);
        t.addPayer(p4,0);
        ticketDatabase.addEntry(t);
        this.frame = new MainFrame(personDatabase,ticketDatabase,f);
    }
    public static void main(String[] arg){
        new DebugRunner();
    }
}
