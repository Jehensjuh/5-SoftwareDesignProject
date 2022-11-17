package Tickets;

public class EvenTicket extends Ticket {

    public EvenTicket(String payer, double amountUpfront, String type) {
        super(payer, amountUpfront, type);
    }

    @Override
    public void divideBill() {

    }
}
