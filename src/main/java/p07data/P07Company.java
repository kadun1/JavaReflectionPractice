package p07data;

public class P07Company {
    private final String name;
    private final String city;
    private final P07Address address;

    public P07Company(String name, String city, P07Address address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
