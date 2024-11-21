package store.domain;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import store.constants.ErrorMessage;
import store.utils.FileRead;
import store.utils.Parser;
import store.utils.Split;

public class Promotions {

    private static final String fileName = "src/main/resources/promotions.md";
    private final Map<String, Promotion> promotions;

    public Promotions() {
        try {
            List<String> promotionFile = FileRead.fileReader(fileName);
            this.promotions = fileToPromotions(promotionFile);
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorMessage.ECT_INPUT_ERROR.getMessage());
        }
    }

    public Map<String, Promotion> getPromotions() {
        return Collections.unmodifiableMap(promotions);
    }

    private Map<String, Promotion> fileToPromotions(List<String> promotionFile) {
        Map<String, Promotion> savePromotion = new LinkedHashMap<>();

        for (String content : promotionFile) {
            List<String> splitContent = Split.commaSplit(content);
            createPromotion(splitContent, savePromotion);
        }
        return savePromotion;
    }

    private static void createPromotion(List<String> splitContent, Map<String, Promotion> savePromotion) {
        String name = splitContent.get(0);
        int buy = Parser.stringToInteger(splitContent.get(1));
        int get = Parser.stringToInteger(splitContent.get(2));
        LocalDateTime start_date = Parser.stringToLocalDateTime(splitContent.get(3));
        LocalDateTime end_date = Parser.stringToLocalDateTime(splitContent.get(4));
        savePromotion.put(name, new Promotion(name, buy, get, start_date, end_date));
    }
}
