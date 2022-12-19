package GUI.OpeningFrame;

import Database.PersonDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Person.Person;

public class NameListPanel extends JPanel implements ActionListener {
    Button addName;
    Button removeButton;
    JPanel namePanel;
    JPanel removePanel;
    PersonDatabase pdb;
    private DefaultListModel<String> nameList;
    private JList<String> names;
    public NameListPanel(PersonDatabase pdb){
        this.pdb = pdb;
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
            String name = JOptionPane.showInputDialog("Input name: ");
            pdb.addPerson(new Person(name));//add person to the database
            this.nameList.addElement(name);//displays person in the list
        }
        else if(e.getSource()==removeButton){
            String name = JOptionPane.showInputDialog("What name to remove?: ");
            pdb.removePersonName(name);//removes person from the database
            this.nameList.removeElement(name);//removes person from the displayed list
        }
    }
}