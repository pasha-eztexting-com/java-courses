package Task04_27;

public class ProductA {
    protected String name;
    protected double price;

    public ProductA(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{name='" + name + "', price=" + price + '}';
    }
}
