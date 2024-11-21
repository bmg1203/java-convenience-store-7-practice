package store.domain;

import java.util.Map;

public class Promotions {

    private final Map<String, Promotion> promotions;

    public Promotions(Map<String, Promotion> promotions) {
        this.promotions = promotions;
    }
}
