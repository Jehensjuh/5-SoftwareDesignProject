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
        this.frame = new MainFrame(personDatabase,ticketDatabase,f,c);
    }
    public static void main(String[] arg){
        new DebugRunner();
    }
}
