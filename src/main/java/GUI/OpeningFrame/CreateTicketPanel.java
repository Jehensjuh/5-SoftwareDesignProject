package GUI.OpeningFrame;

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
    Button addTicket;
    Button calculateBill;
    TicketDatabase ticketDatabase;
    PersonDatabase personDatabase;
    TicketFactory f;
    public CreateTicketPanel(PersonDatabase personDatabase, TicketDatabase ticketDatabase, TicketFactory f){
        this.personDatabase=personDatabase;
        this.ticketDatabase=ticketDatabase;
        this.f = f;

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
            TicketFrame ticketFrame = new TicketFrame(personDatabase,ticketDatabase, f);//opens create ticket window
        }
        else if(e.getSource()==calculateBill){
            //open window with calculated bill
            BillFrame billFrame = new BillFrame(personDatabase, ticketDatabase);//opens bill window
        }
    }
}
