package Controller;

import Person.Person;
import Database.Database;
import Database.TicketDatabase;
import Database.PersonDatabase;
import Tickets.Ticket;

public class PersonController extends Controller {

    private PersonDatabase dbp;

    private TicketDatabase dbt;

    public PersonController(PersonDatabase dbp, TicketDatabase dbt) {
        this.dbp = dbp;
        this.dbt = dbt;
    }

    public PersonController() {}

    @Override
    public void printPersonDatabase() {
        this.dbp.printDatabase();
    }

    @Override
    public void addPerson(Person p) {
        dbp.addPerson(p);
    }

    @Override
    public void removePerson(Person p) {
        dbp.removePerson(p);
    }

    //Functie die al de tickets van de persoon geeft
    @Override
    public void getInvolvedTickets(Person p, TicketDatabase dbt)
    {
        dbp.getInvolvedTickets(p, dbt);
    }

}