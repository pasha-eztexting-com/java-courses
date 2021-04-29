package Task04_27;

public class ProductB extends ProductA {
    protected String color;

    public ProductB(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    @Override
    public String toString() {
        return "{color='" + color + "', name='" + name + "', price=" + price + '}';
    }
}
