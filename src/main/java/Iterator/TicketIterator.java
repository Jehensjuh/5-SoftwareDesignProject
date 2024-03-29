package Iterator;

import Tickets.Ticket;

import java.util.ArrayList;

public class TicketIterator extends Iterator{
    private ArrayList<Ticket> tickets;

    public TicketIterator(ArrayList<Ticket> tickets){
        this.tickets = tickets;
    }

    @Override
    public boolean end() {
        return this.index == tickets.size();
    }

    @Override
    public void next() {
        if(!this.end()){//if we are not at the last element
            index++;//go to the next element
        }else{
            this.index = 0;//if we are currently at the end, start at the beginning again.
        }
    }

    @Override
    public void prev() {
        if(!(this.index == 0)){//if we are not at the start
            index--;//go back an element
        }else{
            this.index = tickets.size();//else go to the last element
        }
    }

    @Override
    public Object first() {
        return tickets.get(0);
    }

    @Override
    public Object current() {
        return tickets.get(index);
    }
}
