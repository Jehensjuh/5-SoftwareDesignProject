package PersonTests;

import Database.Database;
import Database.PersonDatabase;
import Person.Person;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class PersonDatabase_ITest
{
    PersonDatabase dbp = PersonDatabase.getInstance();
    Person p1 = new Person("Jan");
    Person p2 = new Person("An");
    Person p3 = new Person("Bob", 500);
    Person p4 = new Person("Jens", 200);
    Person p5 = new Person("Alexander", 100);

    public PersonDatabase_ITest() {}

    @Before
    public void Initialize()
    {
        dbp.addPerson(p1);
        dbp.addPerson(p2);
        dbp.addPerson(p3);
        dbp.addPerson(p4);
        dbp.addPerson(p5);
        dbp.removePerson(p1);
        dbp.removePersonName("An");
        dbp.removePersonName("Test");
        dbp.printDatabase();
        dbp.sortDatabase();
        dbp.printDatabase();
    }

    @Test
    public void present()
    {
        assertThat("Present",false == dbp.inDatabase(p1));
        assertThat("Present",false == dbp.inDatabase(p2));
        assertThat("Present",true == dbp.inDatabase(p3));
        assertThat("Name Present", true == dbp.nameInDatabase("Bob"));
    }
}
