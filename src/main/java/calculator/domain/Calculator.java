package calculator.domain;

import java.util.regex.Pattern;

public class Calculator {

    private static Integer CUSTOM_SEPARATOR_START_INDEX = 2;
    private static Integer CUSTOM_SEPARATOR_END_INDEX = 3;


    public String[] extractNumber(String text) {
        String arr[] = text.split("[,|:]");
        return arr;
    }

    public String[] extractNumber(String customSeparator, String text) {
        String regex = Pattern.quote(customSeparator);
        String arr[] = text.split(regex);
        if (IsEqualRegexAndCustomSeparator(regex, text, customSeparator)) {
            throw new IllegalArgumentException();
        }
        return arr;
    }

    private Boolean IsEqualRegexAndCustomSeparator(String regex, String text, String customSeparator) {
        return text.matches(".*[^0-9" + regex + "].*");
    }

    public String findCustomSeparator(String inputText) {
        return inputText.substring(CUSTOM_SEPARATOR_START_INDEX, CUSTOM_SEPARATOR_END_INDEX);
    }

    public String removeCustomReserveWord(String inputText) {
        return inputText.substring(5);
    }


    public int sum(String[] extractNumberArr) {
        int sum = 0;
        for (String str : extractNumberArr) {
            try {
                sum += validateNumber(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                if (isInputBlank(extractNumberArr)) {
                    return sum;
                }
                if (!isInputBlank(extractNumberArr)) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return sum;
    }

    private Boolean isInputBlank(String[] arr) {
        if (arr.length == 1) {
            return true;
        }
        return false;
    }

    private int validateNumber(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException();
        }
        return positiveNumber;
    }
}
