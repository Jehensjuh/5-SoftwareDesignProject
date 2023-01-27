package Factory;

import Person.Person;

public class PersonFactory
{
    public Person getPerson(String name)
    {
        return new Person(name);
    }
    public Person getPerson(String name, double amountPaid)
    {
        return new Person(name, amountPaid);
    }
}
