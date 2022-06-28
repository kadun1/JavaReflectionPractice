package p10api;

public class P10ClothingProduct extends P10Product{

    private P10Size size;
    private String color;

    public P10Size getSize() {
        return size;
    }

    public void setSize(P10Size size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
