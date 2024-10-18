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
        return arr;
    }

    public String findCustomSeparator(String inputText) {
        return inputText.substring(CUSTOM_SEPARATOR_START_INDEX, CUSTOM_SEPARATOR_END_INDEX);
    }

    public String removeCustomReserveWord(String inputText) {
        return inputText.substring(5);
    }


    public void test(String[] arr) {
        int sum = 0;
        for (String str : arr) {
            try {
                sum += validateNumber(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                if (inputBlack(arr)) {
                    System.out.println("결과 : " + sum);
                }
                if (!inputBlack(arr)) {
                    throw new IllegalArgumentException();
                }
            }
        }
        System.out.println("결과 : " + sum);
    }

    private Boolean inputBlack(String[] arr) {
        if (arr.length != 1) {
            return false;
        }
        return true;
    }

    public static int validateNumber(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException();
        }
        return positiveNumber;
    }
}
