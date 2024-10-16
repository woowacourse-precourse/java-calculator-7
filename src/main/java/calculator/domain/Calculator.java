package calculator.domain;

import java.util.Arrays;
import java.util.Iterator;

public class Calculator {

    private static Integer CUSTOM_SEPARATOR_END_INDEX = 3;
    private static Integer CUSTOM_SEPARATOR_START_INDEX = 2;


    public String[] extractNumber(String text) {
        String arr[] = text.split("[,|:]");
        return arr;
    }

    public String[] extractNumber(String customSeparator, String text) {
        String arr[] = text.split(customSeparator);
        return arr;
    }

    public String findCustomSeparator(String inputText) {
        return inputText.substring(CUSTOM_SEPARATOR_START_INDEX, CUSTOM_SEPARATOR_END_INDEX);
    }

    public String removeCustomReserveWord(String inputText) {
        return inputText.substring(6);
    }

    public void sum(String[] arr) {
        int sum = 0;
        for (Iterator<String> it = Arrays.stream(arr).iterator(); it.hasNext(); ) {
            sum += validateNumber(Integer.parseInt(it.next()));
//            try {
//
//            } catch (Exception e) {
//                throw new IllegalArgumentException();
//            }
        }
        System.out.println("결과 : " + sum);
    }

    public static int validateNumber(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException();
        }
        return positiveNumber;
    }
}
