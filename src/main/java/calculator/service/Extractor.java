package calculator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Extractor {

    private static final Pattern ARGUMENT_VALIDATION_REGEX = Pattern.compile("^\\d+|^/");

    public List<Integer> extractNumbers(final String input) {
        List<Integer> integers = new ArrayList<>();

        if (input.isEmpty()) {
            return null;
        }

        validateIllegalArgument(input);

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
                throw new IllegalArgumentException("[ERROR] 값이 0보다 작습니다 !!");
            }
        }
    }

    private void validateIllegalArgument(String input) {
        if (input.isEmpty()) {
            return;
        }

        if (ARGUMENT_VALIDATION_REGEX.matcher(input).find()) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 맞지 않습니다.");
        }

        if (!input.startsWith("/")) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 맞지 않습니다.");
        }
    }
}
