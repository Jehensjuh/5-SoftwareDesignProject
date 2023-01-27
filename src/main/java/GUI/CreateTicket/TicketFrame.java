package GUI.CreateTicket;

import Controller.DatabaseController;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.TicketFactory;
import Person.Person;
import Tickets.TicketTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketFrame extends JFrame {


    PersonDatabase pDatabase;
    TicketDatabase tDatabase;
    TicketFactory f;
    public TicketFrame(PersonDatabase personDatabase, TicketDatabase ticketDatabase, TicketFactory f){
        this.pDatabase=personDatabase;
        this.tDatabase=ticketDatabase;
        this.f = f;
        this.setTitle("Create Ticket");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//get rid of the frame but don't stop the program
        this.setResizable(false);//you cannot manually resize the program
        this.setSize(854,480);
        this.add(new InitPanel(this));
        this.setVisible(true);

    }
}