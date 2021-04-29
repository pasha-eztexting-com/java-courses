package Task04_27;

public class ProductC extends ProductB {
    protected double weight;

    public ProductC(String name, double price, String color, double weight) {
        super(name, price, color);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{weight=" + weight + ", color='" + color + "', name='" + name + "', price=" + price + '}';
    }
}
