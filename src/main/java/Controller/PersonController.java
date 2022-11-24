package Controller;

import Database.Database;
import Person.Person;
import Database.PersonDatabase;

<<<<<<< Updated upstream
public class PersonController{
=======
public class PersonController extends Controller{
>>>>>>> Stashed changes

    private PersonDatabase dbp;

    public PersonController(PersonDatabase dbp) {this.dbp = dbp;}

    public PersonController() {}

<<<<<<< Updated upstream

    public void printPersonDatabase() {

=======
    @Override
    public void printPersonDatabase()
    {
        this.dbp.printDatabase();
    }

    @Override
    public void addPerson(Person p) {
        dbp.addPerson(p);
    }

    @Override
    public void removePerson(Person p) {
        dbp.removePerson(p);
>>>>>>> Stashed changes
    }


//    public void printPersonDatabase() {
//        for (Person person : dbp)
//        {
//            System.out.println(person.getName() + person.getAmountPaid());
//        }
//    }
}
