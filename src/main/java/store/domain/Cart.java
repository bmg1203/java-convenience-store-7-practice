package store.domain;

import java.util.List;

public class Cart {

    private List<Product> purchaseProducts;

    public Cart(List<Product> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
    }

    public List<Product> getPurchaseProducts() {
        return purchaseProducts;
    }
}
