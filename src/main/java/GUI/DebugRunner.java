package GUI;

import Database.PersonDatabase;
import Database.TicketDatabase;
import GUI.CreateTicket.InitPanel;
import GUI.CreateTicket.TicketFrame;
import GUI.OpeningFrame.CreateTicketPanel;
import GUI.OpeningFrame.NameListPanel;
import Person.Person;

/*
Class that purely exists for debugging and running the GUI without running the project
 */
public class DebugRunner {
    MainFrame frame;
    TicketFrame tFrame;
    PersonDatabase personDatabase;
    TicketDatabase ticketDatabase;
    public DebugRunner(){
        this.personDatabase = PersonDatabase.getInstance();
        this.ticketDatabase = TicketDatabase.getInstance();
        personDatabase.addPerson(new Person("bob"));
        personDatabase.addPerson(new Person("Jens"));
        personDatabase.addPerson(new Person("Alexander"));
        personDatabase.addPerson(new Person("Jolyne"));
        this.frame = new MainFrame(personDatabase,ticketDatabase);




    }
    public static void main(String[] arg){
        new DebugRunner();
    }
}
