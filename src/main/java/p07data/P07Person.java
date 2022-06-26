package p07data;

public class P07Person {

    private final String name;
    private final boolean employed;
    private final int age;
    private final float salary;
    private final P07Address address;
    private final P07Company job;

    public P07Person(String name, boolean employed, int age, float salary, P07Address address, P07Company job) {
        this.name = name;
        this.employed = employed;
        this.age = age;
        this.salary = salary;
        this.address = address;
        this.job = job;
    }
}
