package Task04_27;

public class Main {

    public static void main(String[] args) {
        ProductA productA = new ProductA("p1", 3.55);
        ProductB productB = new ProductB("p2", 1.0, "red");
        ProductC productC = new ProductC("p3", 1.05, "blue", 10.0);

        Shelf<ProductA> shelfA = new Shelf<>(productA);
        Shelf<ProductB> shelfB = new Shelf<>(productB);
        Shelf<ProductC> shelfC = new Shelf<>(productC);

        shelfA.printProduct();
        shelfB.printProduct();
        shelfC.printProduct();
    }
}
