package murach.data;

import murach.business.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("p1", "86 (the band) - True Life Songs and Pictures", 14.95));
        products.add(new Product("p2", "Paddlefoot - The first CD", 12.95));
        products.add(new Product("p3", "Paddlefoot - The second CD", 14.95));
        products.add(new Product("p4", "Joe Rut - Genuine Wood Grained Finish", 14.95));
    }

    public static List<Product> getProducts() { return products; }

    public static Product getProduct(String productCode) {
        for (Product p : products) {
            if (p.getCode().equals(productCode)) {
                return p;
            }
        }
        return null;
    }
}