package GUI;

import GUI.OpeningFrame.CreateTicketPanel;
import GUI.OpeningFrame.NameListPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //Initialising MainFrame
    public MainFrame(){
        this.setTitle("Project Software Design");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//make sure the progam closes when you press x
        this.setResizable(false);//you cannot manually resize the program
        this.setSize(500,397);//panels nemen blijkbaar 37 extra pixels in in beide dimensies dan ingevuld?
        this.setLayout(null);
        this.setVisible(true);
        this.add(new NameListPanel());
        this.add(new CreateTicketPanel());
    }
}
