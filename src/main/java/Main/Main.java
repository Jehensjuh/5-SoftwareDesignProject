package Main;


import Controller.Controller;
import Controller.DatabaseController;
import GUI.DebugRunner;
import GUI.MainFrame;

public class Main {

    private static void run(){
        Controller c = new DatabaseController();
        new MainFrame(c);
    }

    private static void runpPrepared(){
        Controller c = new DatabaseController();
        new DebugRunner(c);
    }

    public static void main(String[] arg){
        //run();
        runpPrepared();//option with namelist already setup
    }
}
