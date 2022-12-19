package GUI;

import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.TicketFactory;
import Controller.DatabaseController;
import GUI.CreateTicket.InitPanel;
import GUI.CreateTicket.TicketFrame;
import GUI.OpeningFrame.CreateTicketPanel;
import GUI.OpeningFrame.NameListPanel;
import Observers.ObserverTicket;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;

import javax.xml.crypto.Data;

/*
Class that purely exists for debugging and running the GUI without running the project
 */
public class DebugRunner {
    MainFrame frame;
    PersonDatabase personDatabase;
    TicketDatabase ticketDatabase;
    DatabaseController c;
    TicketFactory f;

    public DebugRunner(){
        this.c = new DatabaseController();
        this.f = new TicketFactory();
        this.personDatabase = c.getPersonDatabase();
        this.ticketDatabase = c.getTicketDatabase();
        c.clearDatabase();
        c.addObserver();
        //debug:
//        Person p1 = new Person("Jens");
//        Person p2 = new Person("Alexander");
//        Person p3 = new Person("Bob");
//        Person p4 = new Person("An");
//        personDatabase.addPerson(p1);
//        personDatabase.addPerson(p2);
//        personDatabase.addPerson(p3);
//        personDatabase.addPerson(p4);
//        Ticket t = f.getTicket(p1,200, TicketTypes.TaxiTicket,"ticket1");
//        t.addPayer(p2,0);
//        t.addPayer(p3,0);
//        t.addPayer(p4,0);
//        ticketDatabase.addEntry(t);
        this.frame = new MainFrame(personDatabase,ticketDatabase,f,c);
    }
    public static void main(String[] arg){
        new DebugRunner();
    }
}