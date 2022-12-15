package GUI.CreateTicket;

import Factory.TicketFactory;
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
    HashMap<JCheckBox,TextField> list;



    JComboBox ticketOptions;
    public InitPanel(TicketFrame frame){

        //panel init
        this.setLayout(new BorderLayout());
        //data init
        this.frame = frame;
        this.payers = new HashMap<Person, Double>();
        if(!this.frame.tDatabase.getDatabase().isEmpty()){
            this.ticketName = "Ticket"+(frame.tDatabase.getAmountOfTickets()+1);//name of the ticket will be "ticket"+new amount of ticket. So second ticket will be called "ticket2"
        }
        this.list = new HashMap<JCheckBox,TextField>();
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
        this.createPanels();
    }

    private void createPanels(){
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        northPanel.add(ticketOptions);
        northPanel.add(addCreator);
        northPanel.add(addAmountUpFront);
        southPanel.add(submit);
        this.createPayersList(centerPanel);
        this.add(northPanel,BorderLayout.NORTH);
        this.add(southPanel,BorderLayout.SOUTH);
    }

    private void createPayersList(JPanel panel){
        if(!this.frame.pDatabase.getDbp().isEmpty()){//if the database is empty we shouldn't run this
            JPanel listPanel = new JPanel();
            for(Person i:this.frame.pDatabase.getDbp()){
                this.list.put(new JCheckBox(i.getName()),new TextField("Enter amount paid"));
            }
            double amountOfElements = this.list.size();
            listPanel.setLayout(new GridLayout((int)amountOfElements,2));
            for(JCheckBox j:this.list.keySet()){
                listPanel.add(j);//add checkbox
                listPanel.add(list.get(j));//add textfield
            }
            panel.add(listPanel);
            this.add(panel,BorderLayout.CENTER);
        }
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
