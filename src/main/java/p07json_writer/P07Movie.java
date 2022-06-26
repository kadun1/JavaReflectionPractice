package p07json_writer;

public class P07Movie {
    private final String name;
    private final float rating;
    private final String[] categories;
    private final P07Actor [] actors;

    public P07Movie(String name, float rating, String[] categories, P07Actor[] actors) {
        this.name = name;
        this.rating = rating;
        this.categories = categories;
        this.actors = actors;
    }
}
