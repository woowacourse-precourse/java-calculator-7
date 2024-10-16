package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputView {

    private static final String COMMA = ",";
    private static final String COLON = ":";

    public List<Integer> getAdditionNumbers() {
        String input = Console.readLine();

        input = input.replace("\\n", "\n");

        if (input.isBlank()) {
            return Collections.emptyList();
        }

        String separators = getSeparators(input);
        String numbers = getNumbers(input);

        return splitAndParseNumbers(separators, numbers);
    }

    private List<Integer> splitAndParseNumbers(String separators, String numbers) {
        String[] inputTokens = numbers.split(separators);

        return Arrays.stream(inputTokens)
                .map(this::parseNumber)
                .toList();
    }

    private int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            validatePositiveNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }

    private String getSeparators(String input) {
        if (hasCustomSeparator(input)) {
            int separatorEndIndex = getSeparatorEndIndex(input);
            validateCustomSeparator(separatorEndIndex);

            String customSeparator = getCustomSeparator(input, separatorEndIndex);

            return COMMA + "|" + COLON + "|" + customSeparator;
        }

        return COMMA + "|" + COLON;
    }

    private String getNumbers(String input) {
        if (hasCustomSeparator(input)) {
            int separatorEndIndex = getSeparatorEndIndex(input);
            return input.substring(separatorEndIndex + 1);
        }

        return input;
    }

    private boolean hasCustomSeparator(String input) {
        return input.startsWith("//");
    }

    private void validateCustomSeparator(int customSeparatorEndIndex) {
        if (customSeparatorEndIndex == -1) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }

    private int getSeparatorEndIndex(String input) {
        return input.indexOf("\n");
    }

    private String getCustomSeparator(String input, int separatorEndIndex) {
        return input.substring(2, separatorEndIndex);
    }
}
