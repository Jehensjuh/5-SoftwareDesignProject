package GUI.CreateTicket;

import Database.PersonDatabase;
import Database.TicketDatabase;
import Person.Person;
import Tickets.TicketTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketFrame extends JFrame {


    PersonDatabase pDatabase;
    TicketDatabase tDatabase;
    public TicketFrame(){
        this.setTitle("Create Ticket");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//get rid of the frame but don't stop the program
        this.setResizable(false);//you cannot manually resize the program
        this.setSize(854,480);
        this.setVisible(true);
        this.add(new InitPanel(this));

    }
}