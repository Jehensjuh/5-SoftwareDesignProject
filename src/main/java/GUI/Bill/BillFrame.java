package GUI.Bill;

import Bill.Bill;
import Controller.DatabaseController;
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
    DatabaseController c;

    JButton shutdown;
    public BillFrame(PersonDatabase personDatabase, TicketDatabase ticketDatabase, DatabaseController c){
        this.personDatabase=personDatabase;
        this.ticketDatabase=ticketDatabase;
        this.c =c;

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
        //debug
        HashMap<Person,Double> debt = new HashMap<Person, Double>();
        debt.put(new Person("Alexander"),20.0);
        debt.put(new Person("Jan"),30.0);
        HashMap<Person, HashMap<Person, Double>> bill = new HashMap<Person, HashMap<Person, Double>>();
        bill.put(new Person("Jens"),debt);

        System.out.println("person database: "+personDatabase.getDbp()+" ticket database: "+ticketDatabase.getDatabase());
        //HashMap<Person, HashMap<Person,Double>> bill = c.getBill();//get bill
        System.out.println("bill: "+bill+" inside hasmap bill: "+bill.values());

        ArrayList<JLabel> labelList = new ArrayList<JLabel>();//make list for all labels (we don't know how many labels we'll have in advance

        JPanel billPanel = new JPanel();//panel to show bill
        JPanel titlePanel = new JPanel();//panel to show the titles specifying the categories in bill

        JLabel indebted = new JLabel("indebted");
        indebted.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel creditor = new JLabel("creditor");
        creditor.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel due = new JLabel("Amount");
        due.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        titlePanel.add(indebted);
        titlePanel.add(creditor);
        titlePanel.add(due);
        int amountCreditors = 0;
        for(Person p:bill.keySet()){
            amountCreditors += bill.get(p).size();//for each person check the amount of creditors, total will be the sum of those
        }
        billPanel.setLayout(new GridLayout(amountCreditors,3));//rows : #elements, columns: 3

        if(!bill.isEmpty()){
            for(Person i:bill.keySet()){
                for(Person j :bill.get(i).keySet()){
                    labelList.add(new JLabel(i.getName()));//name of the indebted
                    labelList.add(new JLabel(j.getName()));//name of the creditor
                    labelList.add(new JLabel(bill.get(i).get(j)+" euro's"));//amount due
                }
            }
            for(JLabel l:labelList){
                billPanel.add(l);
            }
        }
        this.add(titlePanel,BorderLayout.NORTH);
        this.add(billPanel,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shutdown){
            System.exit(0);//close program (bill has been calculated so we have no more use for it
        }
    }
}
