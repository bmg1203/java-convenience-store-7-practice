package store.domain;

import java.util.Map;

public class Products {

    private final Map<String, Product> regularProducts;
    private final Map<String, Product> promotionProducts;

    public Products(Map<String, Product> regularProducts, Map<String, Product> promotionProducts) {
        this.regularProducts = regularProducts;
        this.promotionProducts = promotionProducts;
    }
}
