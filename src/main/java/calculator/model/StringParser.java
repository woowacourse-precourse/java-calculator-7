package calculator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringParser {

    private static final String BLANK = "";

    public List<Integer> extractNumbers(String input) {
        if (isBlank(input)) {
            return Collections.singletonList(0);
        }

        Separator separator = new Separator();
        String[] numberStrings = separator.splitByAllSeparators(input);

        return convertToNumbers(numberStrings);
    }

    private List<Integer> convertToNumbers(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .map(this::parseNumber)
                .toList();
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
        }
    }

    public boolean isBlank(String input) {
        return input.equals(BLANK);

    }
}
