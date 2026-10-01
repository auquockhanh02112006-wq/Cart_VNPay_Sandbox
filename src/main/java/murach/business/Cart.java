package murach.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

    private List<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<LineItem> getItems() { return items; }

    public void addItem(Product product) {
        for (LineItem item : items) {
            if (item.getProduct().getCode().equals(product.getCode())) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        items.add(new LineItem(product, 1));
    }

    public void updateItem(String productCode, int quantity) {
        for (LineItem item : items) {
            if (item.getProduct().getCode().equals(productCode)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    public void removeItem(String productCode) {
        items.removeIf(item -> item.getProduct().getCode().equals(productCode));
    }

    public int getCount() { return items.size(); }
}