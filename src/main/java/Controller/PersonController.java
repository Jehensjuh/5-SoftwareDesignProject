package Controller;

import Database.Database;
import Person.Person;
import Database.PersonDatabase;

public class PersonController{

    private PersonDatabase dbp;

    public PersonController(PersonDatabase dpb) {this.dbp = dbp;}

    public PersonController() {}


    public void printPersonDatabase() {

    }


//    public void printPersonDatabase() {
//        for (Person person : dbp)
//        {
//            System.out.println(person.getName() + person.getAmountPaid());
//        }
//    }
}
