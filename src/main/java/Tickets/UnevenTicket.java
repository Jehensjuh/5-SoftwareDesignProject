package Tickets;

public class UnevenTicket extends Ticket{
    public UnevenTicket(String payer, double amountUpfront, String type) {
        super(payer, amountUpfront, type);
    }

    @Override
    public void divideBill() {

    }
}
