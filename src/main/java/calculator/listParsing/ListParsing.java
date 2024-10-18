package calculator.listParsing;

import java.util.ArrayList;
import java.util.List;

public class ListParsing {
    private ListParsing() {

    }

    public static List<Integer> parseList(String input, List<String> delimiter) {

        String delimiterRegex = String.join("|", delimiter);

        String[] parsedNumbers = input.split(delimiterRegex);

        List<Integer> numbersList = new ArrayList<>();

        for (String numStr : parsedNumbers) {
            try {
                int number = Integer.parseInt(numStr);
                if (number < 0) {
                    throw new IllegalArgumentException("양의 정수를 입력해야 합니다.");
                }
                numbersList.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바르지 않은 형식입니다.");
            }
        }

        return numbersList;
    }
}