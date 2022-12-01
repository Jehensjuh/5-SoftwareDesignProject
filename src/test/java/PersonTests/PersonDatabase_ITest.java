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
    Person p3 = new Person("Bob");

    public PersonDatabase_ITest() {}

    @Before
    public void Initialize()
    {
        dbp.addPerson(p1);
        dbp.addPerson(p1);
        dbp.addPerson(p2);
        dbp.addPerson(p3);
        dbp.removePerson(p1);
    }

    @Test
    public void present()
    {
        assertThat("Present",true == dbp.inDatabase(p1));
        assertThat("Present",true == dbp.inDatabase(p2));
        assertThat("Present",true == dbp.inDatabase(p3));
    }
}
