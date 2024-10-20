package calculator.parsing;

import java.util.ArrayList;
import java.util.List;

public class ListParser {
    private ListParser() {

    }

    public static List<Integer> parseList(String input, List<String> delimiter) {

        String delimiterRegex = getDelimiterRegex(delimiter);

        String[] parsedNumbers = getParsedNumbers(input, delimiterRegex);

        List<Integer> numbersList = new ArrayList<>();

        for (String numStr : parsedNumbers) {
            try {
                int number = parseNumbers(numStr);
                numbersList.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바르지 않은 형식입니다.");
            }
        }

        return numbersList;
    }

    private static String getDelimiterRegex(List<String> delimiter) {
        return String.join("|", delimiter);
    }

    private static String[] getParsedNumbers(String input, String delimiterRegex) {
        return input.split(delimiterRegex);
    }

    private static int parseNumbers(String numStr) {
        int number = Integer.parseInt(numStr);
        if (number < 1) {
            throw new IllegalArgumentException("양의 정수를 입력해야 합니다.");
        }
        return number;
    }
}