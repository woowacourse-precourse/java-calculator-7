package calculator.controller;

import calculator.view.View;

public class BasicInputValidator {


    public static boolean showIfInputIsEmptyResult(String input) {

        if (input == null || input.isBlank()) {
            View.showResult(0);
            return true;
        }
        return false;
    }


    public static boolean isOnlyNumberWithoutDelimiter(String input) {
        try {
            String inputStrip = input.strip();
            long onlyNumberWithoutDelimiter = Long.parseLong(inputStrip);
            View.showResult(onlyNumberWithoutDelimiter);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }
}
