package store.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import store.constants.ErrorMessage;
import store.utils.FileRead;
import store.utils.Parser;
import store.utils.Split;

public class Products {

    private static final String fileName = "src/main/resources/products.md";
    private Map<String, Product> regularProducts;
    private Map<String, Product> promotionProducts;
    private List<String> productNames;

    public Products(Promotions promotions) {
        try {
            List<String> productFile = FileRead.fileReader(fileName);
            this.productNames = createProductNames(productFile);
            this.promotionProducts = createPromotionProducts(productFile, promotions);
            this.regularProducts = createRegularProducts(productFile, promotions);
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorMessage.ECT_INPUT_ERROR.getMessage());
        }
    }

    public Map<String, Product> getRegularProducts() {
        return Collections.unmodifiableMap(regularProducts);
    }

    public Map<String, Product> getPromotionProducts() {
        return Collections.unmodifiableMap(promotionProducts);
    }

    public List<String> getProductNames() {
        return List.copyOf(productNames);
    }

    private List<String> createProductNames(List<String> productFile) {
        List<String> names = new ArrayList<>();
        for (String content : productFile) {
            String name = Split.commaSplit(content).get(0);
            if (!names.contains(name)) {
                names.add(name);
            }
        }
        return names;
    }

    private Map<String, Product> createPromotionProducts(List<String> productFile, Promotions promotions) {
        Map<String, Product> promotionProduct = new LinkedHashMap<>();

        for (String content : productFile) {
            Product product = newProduct(promotions, content);
            if (product.getPromotion() != null) {
                promotionProduct.put(product.getName(), product);
            }
        }
        return promotionProduct;
    }

    private Map<String, Product> createRegularProducts(List<String> productFile, Promotions promotions) {
        Map<String, Product> regularProduct = new LinkedHashMap<>();

        for (String content : productFile) {
            Product product = newProduct(promotions, content);
            if (product.getPromotion() == null) {
                regularProduct.put(product.getName(), product);
            }
        }
        addExtraRegularProducts(regularProduct);
        return regularProduct;
    }

    private void addExtraRegularProducts(Map<String, Product> regularProduct) {
        for (String name : productNames) {
            if (regularProduct.get(name) == null) {
                int price = promotionProducts.get(name).getPrice();
                regularProduct.put(name, new Product(name, price, 0, null));
            }
        }
    }

    private static Product newProduct(Promotions promotions, String content) {
        List<String> splitContent = Split.commaSplit(content);
        String name = splitContent.get(0);
        int price = Parser.stringToInteger(splitContent.get(1));
        int quantity = Parser.stringToInteger(splitContent.get(2));
        Promotion promotion = promotions.getPromotions().getOrDefault(splitContent.get(3), null);

        return new Product(name, price, quantity, promotion);
    }
}
