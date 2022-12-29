package Iterator;

import Database.TicketDatabase;
import Person.Person;
import Tickets.Ticket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class TicketDbIterator extends Iterator{

    private TicketDatabase database;
    private ArrayList<Person> keys;
    //private ArrayList<Ticket> values;

    public TicketDbIterator(TicketDatabase database){
        this.database=database;
        Set<Person> keySet = database.getDatabase().keySet();
        this.keys = new ArrayList<Person>(keySet);
    }

    @Override
    boolean end() {
        return this.index == database.getDatabase().size();
    }

    @Override
    void next() {
        if(!this.end()){//if we are not at the last element
            index++;//go to the next element
        }else{
            this.index = 0;//if we are currently at the end, start at the beginning again.
        }
    }

    @Override
    void prev() {
        if(!(this.index == 0)){//if we are not at the start
            index--;//go back an element
        }else{
            this.index = database.getDatabase().size();//else go to the last element
        }
    }

    @Override
    Object first() {
        return database.getDatabase().get(keys.get(0));//return hasmap that belongs to person first in hashmap
    }

    @Override
    Object current() {
        return database.getDatabase().get(keys.get(index));//return hasmap that belongs to person on current index
    }
}
