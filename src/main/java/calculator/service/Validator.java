package calculator.service;

import calculator.view.Constant;

public class Validator {

    private static boolean isCustomDelimiter(String s) {
        if (s.startsWith("//")) {
            return s.charAt(3) == '\n';
        }
        return false;
    }

    private static boolean isRightDelimiter(String s) {
        String[] numbers = s.split("[:|,]");
        for (String number : numbers) {
            if (!number.matches("^[0-9]*")) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncludeZero(String s) {
        String[] numbers = s.split("[:|,]");
        for (String number : numbers) {
            if (Integer.parseInt(number) <= 0) {
                return false;
            }
        }
        return true;
    }

    private static String getCustomDelimiter(String s) {
        return String.valueOf(s.charAt(2));
    }

    private static void isRightInput(String s) {
        if (!isCustomDelimiter(s)) {
            if (!isRightDelimiter(s)) {
                throw new IllegalArgumentException(Constant.NOT_ALLOWED_DELIMITER);
            }
            if (isIncludeZero(s)) {
                throw new IllegalArgumentException(Constant.INCLUDE_ZERO);
            }
        }
    }

    public void validateInput(String s) {
        try {
            isRightInput(s);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
