package store.constants;

public enum ErrorMessage {

    WRONG_INPUT_FORM_ERROR("올바르지 않은 형식으로 입력했습니다. "),
    NOT_POSITIVE_QUANTITY_ERROR("상품 개수는 1 이상이어야 합니다. "),
    DUPLICATE_PRODUCT_NAME_ERROR("같은 상품을 여러번 구매합니다. "),

    NOT_EXIST_PRODUCT_INPUT_ERROR("존재하지 않는 상품입니다. "),
    NOT_ENOUGH_PRODUCT_QUANTITY_ERROR("재고 수량을 초과하여 구매할 수 없습니다. "),
    ECT_INPUT_ERROR("잘못된 입력입니다. ");

    private final String logLevel = "[ERROR] ";
    private final String message;
    private final String retry = "다시 입력해 주세요. \n";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return logLevel + message + retry;
    }
}
