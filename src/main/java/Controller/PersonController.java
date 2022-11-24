package Controller;

import Database.Database;
import Person.Person;
import Database.PersonDatabase;

public class PersonController implements Controller{

    private PersonDatabase dbp;

    public PersonController(PersonDatabase dpb) {this.dbp = dbp;}

    public PersonController() {}

    @Override
    public void printPersonDatabase() {
        for (Person person : dbp)
        {
            System.out.println(person.getName() + person.getAmountPaid());
        }
    }
}
