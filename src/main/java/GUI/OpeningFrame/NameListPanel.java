package GUI.OpeningFrame;

import Controller.Controller;
import Controller.DatabaseController;
import Database.PersonDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import Factory.PersonFactory;
import Factory.TicketFactory;
import Iterator.Iterator;
import Iterator.PersonDbIterator;
import Person.Person;

public class NameListPanel extends JPanel implements ActionListener {
    Button addName;
    Button removeButton;
    JPanel namePanel;
    JPanel removePanel;
    Controller c;
    PersonFactory pf;
    TicketFactory tf;
    private DefaultListModel<String> nameList;
    private JList<String> names;
    public NameListPanel(Controller c){
        this.c = c;
        this.tf = c.getTicketFactory();
        this.pf = c.getPersonFactory();
        this.setBounds(0,0,250,720/2);
        this.setLayout(new BorderLayout(10,0));

        this.names = new JList<String>();

        this.addName = new Button("add name");
        this.addName.setPreferredSize(new Dimension(100, 50));
        this.addName.addActionListener(this);

        this.removeButton = new Button("Remove name");
        this.removeButton.setPreferredSize(new Dimension(100,50));
        this.removeButton.addActionListener(this);

        this.nameList = new DefaultListModel();

        this.names = new JList(this.nameList);
        this.names.setAutoscrolls(true);
        if(!c.getDatabasePerson().getDbp().isEmpty()){
            Iterator i = new PersonDbIterator(c.getDatabasePerson());
            while(!i.end()){
                this.nameList.addElement(i.current().toString());
                i.next();
            }
        }
        JPanel buttonPanel = new JPanel();//panel to show add name button
        buttonPanel.setBounds(5,5,240,50);
        buttonPanel.setBackground(Color.DARK_GRAY);//debug
        buttonPanel.add(addName);

        namePanel = new JPanel();//panel to show list of names
        namePanel.setBounds(5,300,240,300);
        namePanel.setBackground(Color.GRAY);//debug

        removePanel = new JPanel();//panel to show remove name button
        removePanel.setBackground(Color.LIGHT_GRAY);

        //add panels to main panel
        this.add(buttonPanel,BorderLayout.NORTH);//north of the panel
        this.add(namePanel,BorderLayout.CENTER);//center of the panel
        this.add(removePanel,BorderLayout.SOUTH);//south of the panel

        //add buttons to panels
        this.namePanel.add(names);
        this.removePanel.add(removeButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addName){
            String name = JOptionPane.showInputDialog(null, "Input name: ", "Add a person", JOptionPane.QUESTION_MESSAGE);
            while(c.nameInDatabase(name)){
                name = JOptionPane.showInputDialog("Name is already in the list, try again: ");
            }
            if (name != null)
            {
                c.addPerson(pf.getPerson(name));//add person to the database
                this.nameList.addElement(name);//displays person in the list*/
            }
        }
        else if(e.getSource()==removeButton){
            String name = JOptionPane.showInputDialog(null, "What name to remove?: ", "Remove a person", JOptionPane.QUESTION_MESSAGE);
            while(!c.nameInDatabase(name) && name != null){
                name = JOptionPane.showInputDialog("Name is not in list, try again: ");
            }
            if (name != null) {
                int i = 0;
                for (Person p : c.getDatabasePerson().getDbp()) {
                    if (Objects.equals(p.getName(), name)) {
                        if (p.getAmountPaid() != 0) {
                            i = JOptionPane.showConfirmDialog(null, "The person still has to pay! Do you still want to remove the person?", "Remove Person?", JOptionPane.YES_NO_OPTION);
                        }
                        break;
                    }
                }
                if (i == 0)
                {
                    c.removePersonName(name);//removes person from the database
                    this.nameList.removeElement(name);//removes person from the displayed list*
                }
            }
        }
    }
}
