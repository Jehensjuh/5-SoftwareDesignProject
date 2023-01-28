package GUI.OpeningFrame;

import Controller.Controller;
import Controller.DatabaseController;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.TicketFactory;
import GUI.Bill.BillFrame;
import GUI.CreateTicket.TicketFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTicketPanel extends JPanel implements ActionListener {
    PersonDatabase personDatabase;
    TicketDatabase ticketDatabase;
    Button addTicket;
    Button calculateBill;
    Controller c;
    public CreateTicketPanel(Controller c){
        this.c = c;
        this.personDatabase=c.getDatabasePerson();
        this.ticketDatabase=c.getDatabaseTicket();


        this.setBounds(250,0,250,720/2);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(2,1));
        this.calculateBill = new Button("calculate Bill");
        this.calculateBill.setPreferredSize(new Dimension(100,50));
        this.calculateBill.addActionListener(this);
        this.addTicket = new Button("add Ticket");
        this.addTicket.setPreferredSize(new Dimension(100,50));
        this.addTicket.addActionListener(this);
        this.add(addTicket);
        this.add(calculateBill);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addTicket){
            //open create ticket frame
            TicketFrame ticketFrame = new TicketFrame(c);//opens create ticket window
        }
        else if(e.getSource()==calculateBill){
            //open window with calculated bill
            BillFrame billFrame = new BillFrame(c);//opens bill window
        }
    }
}
