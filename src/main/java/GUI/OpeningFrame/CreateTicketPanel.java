package GUI.OpeningFrame;

import GUI.CreateTicket.TicketFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTicketPanel extends JPanel implements ActionListener {
    Button addTicket;
    Button calculateBill;
    public CreateTicketPanel(){
        this.setBounds(250,0,250,720/2);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout(0,0));
        this.calculateBill = new Button("calculate Bill");
        this.calculateBill.setPreferredSize(new Dimension(100,50));
        this.calculateBill.addActionListener(this);
        this.addTicket = new Button("add Ticket");
        this.addTicket.setPreferredSize(new Dimension(100,50));
        this.addTicket.addActionListener(this);
        this.add(addTicket);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addTicket){
            //open create ticket frame
            TicketFrame ticketFrame = new TicketFrame();
        }
        else if(e.getSource()==calculateBill){
            //open window with calculated bill
        }
    }
}
