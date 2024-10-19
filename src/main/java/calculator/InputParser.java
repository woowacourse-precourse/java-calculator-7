package calculator;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String DEFAULT_DIVIDERS = ",|:";

    public List<Integer> parse(String input) {
        String[] parts = findCustomDivider(input);
        String dividers = parts[0];
        String numbers = parts[1];

        return Arrays.stream(numbers.split(dividers))
                .map(this::parseNumber)
                .toList();
    }

    private String[] findCustomDivider(String input) {
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            if (endIndex == -1) {
                throw new IllegalArgumentException("'\\n' 문자가 문자열에 존재하지 않습니다.");
            }

            String customDivider = input.substring(2, endIndex);
            if (customDivider.length() != 1 || Character.isDigit(customDivider.charAt(0))) {
                throw new IllegalArgumentException("커스텀 구분자는 한글자의 문자여야 합니다.");
            }

            String dividers = DEFAULT_DIVIDERS + "|" + customDivider;
            String remainingInput = input.substring(endIndex + 2);
            return new String[]{dividers, remainingInput};
        }
        return new String[]{DEFAULT_DIVIDERS, input};
    }

    private int parseNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("구분자 사이의 문자열이 비어있으면 안됩니다.");
        }
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("덧셈할 문자열이 양수로만 이루어져야 합니다.");
        }
        return Integer.parseInt(number);
    }
}
