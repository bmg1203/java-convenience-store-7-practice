package store.view;

import camp.nextstep.edu.missionutils.Console;
import store.constants.InputPrompts;
import store.domain.Cart;
import store.domain.Product;
import store.domain.Products;
import store.domain.Promotions;

public class InputView {

    public Cart purchaseProductInput(Promotions promotions, Products products) {
        while(true) {
            try {
                System.out.println(InputPrompts.PURCHASE_PRODUCTS_INPUT.getPrompt());
                String input = Console.readLine();
                return new Cart(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String promotionIncorrectCountInput(Promotions promotions, Product product) {
        while(true) {
            try {
                //해당 메시지 출력에 들어갈 숫자 추가하기
                System.out.printf(InputPrompts.PROMOTION_INCORRECT_COUNT_INPUT.getPrompt());
                String input = Console.readLine();
                //validateInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String promotionNotEnoughQuantityInput(Promotions promotions, Product product) {
        while(true) {
            try {
                //해당 메시지 출력에 들어갈 숫자 추가하기
                System.out.printf(InputPrompts.PROMOTION_NOT_ENOUGH_QUANTITY_INPUT.getPrompt());
                String input = Console.readLine();
                //validateInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String membershipSaleInput() {
        while(true) {
            try {
                System.out.printf(InputPrompts.MEMBERSHIP_SALE_INPUT.getPrompt());
                String input = Console.readLine();
                //validateInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String morePurchaseInput() {
        while(true) {
            try {
                System.out.printf(InputPrompts.MORE_PURCHASE_INPUT.getPrompt());
                String input = Console.readLine();
                //validateInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
