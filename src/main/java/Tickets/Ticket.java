package Tickets;

import java.util.ArrayList;
import java.util.List;

public abstract class Ticket {
    protected String payer;
    protected double amountUpfront;
    protected String type;
    protected List<String> payers;

    public Ticket(String payer, double amountUpfront,String type){
        this.amountUpfront= amountUpfront;
        this.payer = payer;
        this.type = type;
        this.payers = new ArrayList<String>();
    }

    public abstract void divideBill();

    public String getPayer() {
        return payer;
    }

    public double getAmountUpfront() {
        return amountUpfront;
    }

    public String getType() {
        return type;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public void setAmountUpfront(double amountUpfront) {
        this.amountUpfront = amountUpfront;
    }

    public void setType(String type) {
        this.type = type;
    }
}
