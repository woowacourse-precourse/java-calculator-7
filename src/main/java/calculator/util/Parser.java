package calculator.util;

import static calculator.message.Delimiter.CUSTOM_DELIMITER;
import static calculator.message.Delimiter.DELIMITERS;
import static calculator.message.ErrorMessage.EMPTY_ELEMENT_MESSAGE;
import static calculator.message.ErrorMessage.INVALID_ELEMENT_MESSAGE;
import static calculator.message.ErrorMessage.INVALID_FLOAT_INPUT_MESSAGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {
    public static List<Integer> processString(String str) {
        List<String> stringList = splitByDelimiter(str);
        List<Integer> intList = convertToIntList(stringList);

        Validator.isNegativeNumber(intList);

        return intList;
    }

    public static List<String> splitByDelimiter(String str) {
        checkAndApplyCustomDelimiter();

        return Arrays.asList(str.split(DELIMITERS));
    }

    private static void checkAndApplyCustomDelimiter() {
        if (CUSTOM_DELIMITER != null && !CUSTOM_DELIMITER.isEmpty()) {
            DELIMITERS += "|" + Pattern.quote(CUSTOM_DELIMITER);
        }
    }

    private static List<Integer> convertToIntList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();

        for (String element : stringList) {
            if (isEmpty(element)) {
                throw new IllegalArgumentException(EMPTY_ELEMENT_MESSAGE);
            }

            if (isFloat(element)) {
                throw new IllegalArgumentException(INVALID_FLOAT_INPUT_MESSAGE);
            }

            if (!isInteger(element)) {
                throw new IllegalArgumentException(INVALID_ELEMENT_MESSAGE);
            }

            intList.add(Integer.parseInt(element));
        }

        return intList;
    }

    private static boolean isInteger(String element) {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String element) {
        try {
            Float.parseFloat(element);
            return element.contains(".");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isEmpty(String element) {
        return element.isEmpty();
    }
}