package GUI;

import GUI.CreateTicket.InitPanel;
import GUI.CreateTicket.TicketFrame;
import GUI.OpeningFrame.CreateTicketPanel;
import GUI.OpeningFrame.NameListPanel;

/*
Class that purely exists for debugging and running the GUI without running the project
 */
public class DebugRunner {
    MainFrame frame;
    TicketFrame tFrame;
    public DebugRunner(){
        this.frame = new MainFrame();



    }
    public static void main(String[] arg){
        new DebugRunner();
    }
}
