package store.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import store.constants.ErrorMessage;

public class Parser {

    private static final String dateFormat = "yyyy-MM-dd";

    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ECT_INPUT_ERROR.getMessage());
        }
    }

    public static LocalDateTime stringToLocalDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDateTime.parse(input, formatter);
    }
}
