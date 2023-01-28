package GUI;

import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.PersonFactory;
import Factory.TicketFactory;
import Controller.DatabaseController;
import Controller.Controller;
import GUI.CreateTicket.InitPanel;
import GUI.CreateTicket.TicketFrame;
import GUI.OpeningFrame.CreateTicketPanel;
import GUI.OpeningFrame.NameListPanel;
import Observers.ObserverTicket;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;

import javax.xml.crypto.Data;

import static Tickets.TicketTypes.RestaurantTicket;
import static Tickets.TicketTypes.TaxiTicket;

/*
Class that purely exists for debugging and running the GUI without running the project
 */
public class DebugRunner {
    MainFrame frame;
    PersonDatabase personDatabase;
    TicketDatabase ticketDatabase;
    Controller c;
    TicketFactory tf;
    PersonFactory pf;

    public DebugRunner(Controller c){
        this.c = c;
        this.tf = c.getTicketFactory();
        this.pf = c.getPersonFactory();
        this.personDatabase = c.getDatabasePerson();
        this.ticketDatabase = c.getDatabaseTicket();
        Person p1 = pf.getPerson("Jens");
        Person p2 = pf.getPerson("Alexander");
        Person p3 = pf.getPerson("Ali");
        Person p4 = pf.getPerson("Charlemagne");
        c.addPerson(p1);
        c.addPerson(p2);
        c.addPerson(p3);
        c.addPerson(p4);
//        Ticket t1 = tf.getTicket(p1,120, TaxiTicket,"Taxi");
//        Ticket t2 = tf.getTicket(p2, 500, RestaurantTicket, "Restaurant");
//        Ticket t3 = tf.getTicket(p3, 700, RestaurantTicket, "Restaurant2");
//        Ticket t4 = tf.getTicket(p4, 500, RestaurantTicket, "Restaurant3");
//        t1.addPayer(p1);
//        t1.addPayer(p2);
//        t1.addPayer(p3);
//        t1.addPayer(p4);
//        c.addEntry(t1);
//        t2.addPayer(p1);
//        t2.addPayer(p2);
//        t2.addPayer(p3,200);
//        t2.addPayer(p4);
//        c.addEntry(t2);
//        t3.addPayer(p1);
//        t3.addPayer(p2,200);
//        t3.addPayer(p4,100);
//        c.addEntry(t3);
//        t4.addPayer(p1);
//        t4.addPayer(p2);
//        t4.addPayer(p3);
//        t4.addPayer(p4,400);
//        c.addEntry(t4);
        this.frame = new MainFrame(c);
    }
}
