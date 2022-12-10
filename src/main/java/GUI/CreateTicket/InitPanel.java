package GUI.CreateTicket;

import Person.Person;
import Tickets.TicketTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class InitPanel extends JPanel implements ActionListener {
    //databases moet meegegeven worden bij init;

    //data ticket creation
    Person creator;
    double amountUpFront;
    TicketTypes type;
    TicketFrame frame;
    String ticketName;
    protected HashMap<Person, Double> payers;
    //iet om de payers in te steken
    Button addCreator;
    Button addAmountUpFront;
    Button submit;

    ArrayList<Checkbox> checkboxes;
    ArrayList<TextField> textFields;


    JComboBox ticketOptions;
    public InitPanel(TicketFrame frame){

        this.frame = frame;
        this.payers = new HashMap<Person, Double>();
        this.ticketName = "Ticket"+(frame.tDatabase.getAmountOfTickets()+1);//name of the ticket will be "ticket"+new amount of ticket. So second ticket will be called "ticket2"
        //dropdown menu ticket types
        TicketTypes[] ticketTypes = {TicketTypes.AirplaneTicket, TicketTypes.RestaurantTicket, TicketTypes.TaxiTicket, TicketTypes.ConcertTicket,TicketTypes.OtherTicket};
        this.ticketOptions = new JComboBox(ticketTypes);
        this.ticketOptions.addActionListener(this);

        //buttons
        //addCreator
        this.addCreator = new Button("add creator");
        this.addCreator.setPreferredSize(new Dimension(100,50));
        this.addCreator.addActionListener(this);
        //addAmountUpFront
        this.addAmountUpFront = new Button("add amountupfront");
        this.addAmountUpFront.setPreferredSize(new Dimension(100,50));
        this.addAmountUpFront.addActionListener(this);
        //submit
        this.submit = new Button("submit");
        this.submit.setPreferredSize(new Dimension(100,50));
        this.submit.addActionListener(this);

        //add components to panel
        this.add(ticketOptions);
        this.add(addCreator);
        this.add(addAmountUpFront);
        this.add(submit);
    }

    private void createPayersList(){
        for(Person i:this.frame.pDatabase)
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ticketOptions){
            this.type = (TicketTypes) ticketOptions.getSelectedItem();//should give back a ticket type
        }
        else if(e.getSource()==addCreator){
            this.creator = new Person(JOptionPane.showInputDialog("Who created this ticket?:"));
        }
        else if(e.getSource()==addAmountUpFront){
            this.amountUpFront=Double.parseDouble(JOptionPane.showInputDialog("How much did the creator pay up front?"));
        }
        else if(e.getSource()==submit){
            //create ticket
            frame.dispose();//ticket frame will close once ticket is submitted
        }

    }
}
