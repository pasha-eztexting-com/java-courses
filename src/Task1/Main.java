package Task1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product p1 = new Product("p1", 3);
        Product p2 = new Product("p2", 1);
        Product p3 = new Product("p1", 3);
        Product p4 = new Product("p4", 2);
        Product p5 = new Product("p5", 9);
        Product p6 = new Product("p6", 3);

        List<Product> l = new LinkedList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);
        l.add(p5);
        l.add(p6);
        l.sort(new ProductComparator());
        System.out.println(l);

        HashSet<Product> hashSet = new HashSet<>();
        hashSet.addAll(l);
        l.clear();
        l.addAll(hashSet);
        l.sort(new ProductComparator());
        System.out.println(l);
    }
}
