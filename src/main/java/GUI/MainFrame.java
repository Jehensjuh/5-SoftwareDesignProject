package GUI;

import Controller.DatabaseController;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.TicketFactory;
import GUI.OpeningFrame.CreateTicketPanel;
import GUI.OpeningFrame.NameListPanel;
import Observers.ObserverTicket;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //Initialising MainFrame
    TicketDatabase ticketDatabase;
    PersonDatabase personDatabase;
    TicketFactory f;
    DatabaseController c;
    public MainFrame(PersonDatabase personDatabase, TicketDatabase ticketDatabase, TicketFactory factory,DatabaseController c){
        this.personDatabase=personDatabase;
        this.ticketDatabase=ticketDatabase;
        this.f = factory;
        this.c = c;
        /*c.clearDatabase();
        c.addObserver();*/
        this.setTitle("Project Software Design");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//make sure the progam closes when you press x
        this.setResizable(false);//you cannot manually resize the program
        this.setSize(500,397);//panels nemen blijkbaar 37 extra pixels in in beide dimensies dan ingevuld?
        this.setLayout(null);
        this.add(new NameListPanel(personDatabase));
        this.add(new CreateTicketPanel(personDatabase,ticketDatabase, f, c));
        this.setVisible(true);
    }
}
