package Task1_1;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    public int compare(Product o1, Product o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
