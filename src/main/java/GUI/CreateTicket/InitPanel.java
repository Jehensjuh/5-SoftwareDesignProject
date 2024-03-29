package GUI.CreateTicket;

import Database.PersonDatabase;
import Person.Person;
import Tickets.Ticket;
import Tickets.TicketTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static java.lang.Double.valueOf;


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
    JComboBox creatorOptions;
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
        TicketTypes[] ticketTypes = {TicketTypes.AirplaneTicket, TicketTypes.RestaurantTicket, TicketTypes.TaxiTicket, TicketTypes.ConcertTicket,TicketTypes.ChooseTicket};//create selection of options
        this.ticketOptions = new JComboBox(ticketTypes);//create combobox with selection
        this.ticketOptions.setSelectedIndex(4);//we want chooseticket to be the first option to stimulate the user to select a ticket type (else there won't be any and we'll have an error)
        this.ticketOptions.addActionListener(this);
        //dropdown with possible creators
        ArrayList<String> possibleCreators = new ArrayList<>();
        possibleCreators.add("Choose creator");
        for(Person p:frame.pDatabase.getDbp()){
            possibleCreators.add(p.getName());
        }
        this.creatorOptions = new JComboBox(possibleCreators.toArray(new String[0]));
        this.creatorOptions.addActionListener(this);

        //buttons
        //addCreator
//        this.addCreator = new Button("add creator");
//        this.addCreator.setPreferredSize(new Dimension(100,50));
//        this.addCreator.addActionListener(this);
        //addAmountUpFront
        this.addAmountUpFront = new Button("add amountupfront");
        this.addAmountUpFront.setPreferredSize(new Dimension(125,50));
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
        northPanel.add(ticketOptions);//combobox with all type options
        //northPanel.add(addCreator);//button to add creator of the ticket
        northPanel.add(creatorOptions);//combobox listing possible creators
        northPanel.add(addAmountUpFront);//button to add how much the creator has paid
        southPanel.add(submit);//submit button to create ticket
        this.createPayersList(centerPanel);
        this.add(northPanel,BorderLayout.NORTH);
        this.add(southPanel,BorderLayout.SOUTH);
    }

    private void createPayersList(JPanel panel){
        if(!this.frame.pDatabase.getDbp().isEmpty()){//if the database is empty we shouldn't run this
            JPanel listPanel = new JPanel();
            for(Person i:this.frame.pDatabase.getDbp()){
                this.list.put(new JCheckBox(i.getName()),new TextField("0"));//for eacht person that was added we create a checkbox and textfield
            }
            double amountOfElements = this.list.size();
            listPanel.setLayout(new GridLayout((int)amountOfElements,2));//set the layout based on the amount of elements
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
            if(!(ticketOptions.getSelectedItem() ==TicketTypes.ChooseTicket)){
                this.type = (TicketTypes) ticketOptions.getSelectedItem();//sets the ticket type
            }
            else{
                JOptionPane.showMessageDialog(null,"This is not a valid ticket type, please select another one","Wrong type selection",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource()==creatorOptions){
            if(!(creatorOptions.getSelectedItem()=="Choose creator")){
                for(Person p:frame.pDatabase.getDbp()){
                    if(p.getName() == creatorOptions.getSelectedItem()){
                        this.creator = p;
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"This is not a valid creator option, please select another one","Wrong creator selection",JOptionPane.WARNING_MESSAGE);
            }

        }
//        else if(e.getSource()==addCreator){
//            this.creator = new Person(JOptionPane.showInputDialog("Who created this ticket?:"));//sets the creator
//        }
        else if(e.getSource()==addAmountUpFront){
            double amount = 0;
            while(true){
                try{
                    String input = JOptionPane.showInputDialog(null, "How much did the creator pay up front?", "amountUpfront", JOptionPane.QUESTION_MESSAGE);
                    if (input != null)
                    {
                        amount = Double.parseDouble(input);
                    }
                    break;
                }
                catch(NumberFormatException ignore){
                    JOptionPane.showMessageDialog(null,"This is not a value!!","Input error",JOptionPane.ERROR_MESSAGE);
                }
            }
            if (amount == 0)
            {
                JOptionPane.showMessageDialog(null,"The amount is 0!","Amount is 0",JOptionPane.ERROR_MESSAGE);
            }
            this.amountUpFront=amount;
        }
        else if(e.getSource()==submit){//ticket gets submitted
            //errors
            //TicketTypeError
            if (this.type == null)
            {
                JOptionPane.showMessageDialog(null,"No valid ticket type selected, please select one","Wrong type selection",JOptionPane.WARNING_MESSAGE);
            }
            //CreatorError
            else if (this.creator == null)
            {
                JOptionPane.showMessageDialog(null,"No valid creator selected, please select one","Wrong type selection",JOptionPane.WARNING_MESSAGE);
            }
            //create ticket
            //first we take a look at who is selected as payer and how much they paid (so all people affected by this ticket)
            else
            {
                for(JCheckBox c:list.keySet()){
                    if(c.isSelected()){//if the checkbox is selected
                        double value = 0;
                        boolean test = false;
                        while(true){
                            try{
                                if(!test){
                                    value = Double.parseDouble(list.get(c).getText());
                                }else{
                                    value = Double.parseDouble(JOptionPane.showInputDialog(null, "How much did "+c.getText()+" pay?"));
                                }
                                break;

                            }catch(NumberFormatException ignore){
                                JOptionPane.showMessageDialog(null,"The value next to "+c.getText()+" is not a value.","Input error",JOptionPane.ERROR_MESSAGE);
                                test = true;
                            }
                        }
                        payers.put(frame.pDatabase.getPerson(c.getText()),value);//add the person and their amount paid to the payers hashmap
                    }
                }
                Ticket t = frame.f.getTicket(creator,amountUpFront,type,ticketName);//create ticket;
                for(Person p:payers.keySet()){
                    t.addPayer(p,payers.get(p));//add all payers to the ticket
                }
                frame.tDatabase.addEntry(t);//add ticket to the database
                frame.dispose();//ticket frame will close once ticket is submitted
            }
        }
    }
}
