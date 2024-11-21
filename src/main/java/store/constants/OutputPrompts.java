package store.constants;

public enum OutputPrompts {

    WELCOME_MESSAGE_OUTPUT("안녕하세요. W편의점입니다. \n현재 보유하고 있슷 상품입니다. \n"),
    NO_PROMOTION_PRODUCT_OUTPUT("- %s %s원 %s개\n"),
    PROMOTION_PRODUCT_OUTPUT("- %s %s원 %s개 %s\n"),
    RECEIPT_HEADER_OUTPUT("===========W 편의점=============\n상품명\t\t수량\t금액"),
    PURCHASE_PRODUCTS_OUTPUT("%s\t\t%d\t%s"),
    SALE_GIFT_PRODUCTS_HEADER_OUTPUT("===========증\t정============="),
    SALE_GIFT_PRODUCTS_OUTPUT("%s\t\t%d"),
    FINAL_PRICE_HEADER_OUTPUT("=============================="),
    TOTAL_PRICE_OUTPUT("총구매액\t\t%d\t%s"),
    PROMOTION_SALE_PRICE_OUTPUT("행사할인\t\t\t-%s"),
    MEMBERSHIP_SALE_PRICE_OUTPUT("멤버십할인\t\t\t-%s"),
    FINAL_PRICE_OUTPUT("내실돈\t\t\t%s");

    private final String prompt;

    OutputPrompts(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
