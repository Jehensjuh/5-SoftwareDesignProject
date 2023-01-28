package GUI;

import Controller.DatabaseController;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.PersonFactory;
import Factory.TicketFactory;
import GUI.OpeningFrame.CreateTicketPanel;
import GUI.OpeningFrame.NameListPanel;
import Observers.ObserverTicket;
import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //Initialising MainFrame
    Controller c;
    public MainFrame(Controller c){
        this.c = c;
        this.setTitle("Project Software Design");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//make sure the progam closes when you press x
        this.setResizable(false);//you cannot manually resize the program
        this.setSize(500,397);//panels nemen blijkbaar 37 extra pixels in in beide dimensies dan ingevuld?
        this.setLayout(null);
        this.add(new NameListPanel(c));
        this.add(new CreateTicketPanel(c));
        this.setVisible(true);
    }
}
