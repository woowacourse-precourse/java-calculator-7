package calculator.utils;

import calculator.constant.ErrorMessage;

import java.util.List;

public class ValidateUtils {
    public static void checkIsNumericAndPositive(List<String> splitInput) {
        for (String text : splitInput) {
            if (isNumeric(text)) {
                if (Integer.parseInt(text) < 0) {
                    throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_INPUT.getMessage());
                }
            } else {
                throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+");
    }
}
