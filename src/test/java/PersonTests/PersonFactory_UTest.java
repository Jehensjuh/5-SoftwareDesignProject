package PersonTests;

import Controller.Controller;
import Controller.DatabaseController;
import Database.PersonDatabase;
import Database.TicketDatabase;
import Factory.PersonFactory;
import Person.Person;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class PersonFactory_UTest
{
    PersonDatabase dbp = PersonDatabase.getInstance();
    TicketDatabase dbt = TicketDatabase.getInstance();
    PersonFactory pf = new PersonFactory();
    Person p1 = pf.getPerson("Jan");
    Person p2 = pf.getPerson("An");
    Person p3 = pf.getPerson("Bob", 500);
    Person p4 = pf.getPerson("Jens", -200);
    Person p5 = pf.getPerson("Alexander", 100);

    Controller controller = new DatabaseController();

    public PersonFactory_UTest() {}

    @Before
    public void Initialize()
    {
        controller.addPerson(p1);
        controller.addPerson(p1);
        controller.addPerson(p2);
        controller.addPerson(p3);
        controller.addPerson(p4);
        controller.addPerson(p5);
        controller.removePerson(p1);
        controller.removePersonName("An");
        controller.printPersonDatabase();
        controller.sortDatabase();
        controller.printPersonDatabase();
    }

    @Test
    public void present()
    {
        assertThat("Present", !controller.inDatabase(p1));
        assertThat("Present", !controller.inDatabase(p2));
        assertThat("Present", controller.inDatabase(p3));
        assertThat("Name Present", controller.nameInDatabase("Bob"));
    }
}
