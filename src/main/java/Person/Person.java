package Person;

public class Person implements Comparable<Person>
{
    private String name;
    private double amountPaid;
    public Person(String name) {
        this.name = name;
        this.amountPaid = 0.0;
    }
    public Person(String name, double amountPaid) {
        this.name = name;
        this.amountPaid = amountPaid;
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
    public void addAmountPaid(double payment) {this.amountPaid += payment;}

    //Methode om personen te vergelijken adhv amountPaid
    @Override
    public int compareTo(Person p) {
        return (int)(this.getAmountPaid() - p.getAmountPaid());
    }
}