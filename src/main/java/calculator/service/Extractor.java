package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class Extractor {

    public List<Integer> extractNumbers(final String input) {
        List<Integer> integers = new ArrayList<>();

        if (input.isEmpty()) {
            return null;
        }

        if (input.contains("//") && input.contains("\\n")) {
            String[] tokens = input.split("//|\\\\n");
            String delimeter = tokens[1];
            String[] numberTokens = tokens[2].split(delimeter);

            for (String numberToken : numberTokens) {
                integers.add(Integer.parseInt(numberToken));
            }
            validateNegativeNumber(integers);
            return integers;
        }

        String[] tokens = input.split("[,:]+");
        for (String token : tokens) {
            integers.add(Integer.parseInt(token));
        }
        validateNegativeNumber(integers);
        return integers;
    }

    private void validateNegativeNumber(List<Integer> integers) {
        if (integers.isEmpty()) {
            return;
        }

        for (Integer integer : integers) {
            if (integer < 0) {
                throw new IllegalArgumentException("값이 0보다 작습니다 !!");
            }
        }
    }
}
