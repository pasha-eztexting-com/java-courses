package Task04_27;

public class Shelf<T extends ProductA> {
    T product;

    public Shelf(T product) {
        this.product = product;
    }

    public void printProduct() {
        System.out.println(product);
    }
}
