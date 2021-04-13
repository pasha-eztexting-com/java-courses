package Task1_1;

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

        List<Product> list = new LinkedList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.sort(new ProductComparator());
        System.out.println(list);

        HashSet<Product> hashSet = new HashSet<>();
        hashSet.addAll(list);
        list.clear();
        list.addAll(hashSet);
        list.sort(new ProductComparator());
        System.out.println(list);
    }
}
