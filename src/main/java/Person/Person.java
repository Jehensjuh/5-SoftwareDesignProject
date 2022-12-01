package Person;

public class Person {
    private String name;
    private double amountPaid;
    public Person(String name) {
        this.name = name;
        this.amountPaid = 0.0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}

/*
import Controller.PersonController;
import Controller.Controller;
import Database.PersonDatabase;
import Database.Database;
import Person.Person;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main()
    {

    }

    public void run()
    {
        PersonDatabase dbp = new PersonDatabase();
        Controller register= new PersonController(dbp);

        Person Alexander = new Person("Alexander");
        Person Jens = new Person("Jens");

        register.addPerson(Alexander);
        register.addPerson(Jens);

        Alexander.setAmountPaid(50);

        register.printPersonDatabase();

        register.removePerson(Alexander);

        register.printPersonDatabase();

        register.addPerson(Alexander);

        register.printPersonDatabase();
    }
}
 */
