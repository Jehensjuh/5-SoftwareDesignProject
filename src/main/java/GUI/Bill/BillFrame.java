package GUI.Bill;

import Bill.Bill;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Person.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class BillFrame extends JFrame implements ActionListener {
    PersonDatabase personDatabase;
    TicketDatabase ticketDatabase;

    JButton shutdown;
    public BillFrame(PersonDatabase personDatabase, TicketDatabase ticketDatabase){
        this.personDatabase=personDatabase;
        this.ticketDatabase=ticketDatabase;

        this.setTitle("Bill");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//make sure the progam closes when you press x
        this.setResizable(false);//you cannot manually resize the program
        this.setSize(500,397);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.shutdown = new JButton("Close App");
        this.shutdown.addActionListener(this);
        this.createBillPanel();
        this.add(shutdown, BorderLayout.SOUTH);
    }

    private void createBillPanel(){
        HashMap<Person, HashMap<Person,Double>> bill = Bill.getBill(personDatabase,ticketDatabase);
        ArrayList<JLabel> labelList = new ArrayList<JLabel>();
        JPanel billPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        JLabel indebted = new JLabel("indebted");
        indebted.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel creditor = new JLabel("creditor");
        creditor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel due = new JLabel("Amount");
        due.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titlePanel.add(indebted);
        titlePanel.add(creditor);
        titlePanel.add(due);
        billPanel.setLayout(new GridLayout(bill.size(),3));
        if(!bill.isEmpty()){
            for(Person i:bill.keySet()){
                for(Person j :bill.get(i).keySet()){
                    labelList.add(new JLabel(i.getName()));
                    labelList.add(new JLabel(j.getName()));
                    labelList.add(new JLabel(bill.get(i).get(j)+" euro's"));
                }
            }
            for(JLabel l:labelList){
                billPanel.add(l);
            }
        }
        this.add(titlePanel,BorderLayout.NORTH);
        this.add(billPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shutdown){
            System.exit(0);
        }
    }
}
