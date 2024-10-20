package calculator;

import calculator.exception.ErrorMessage;
import calculator.exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorModel {
    public static final String[] DEFAULT_DIVIDERS = {",", ":"};
    private List<String> dividers = new ArrayList<>(Arrays.asList(DEFAULT_DIVIDERS));

    public List<Integer> splitString(String input) {
        if (input == null || input.isBlank()) {
            return List.of(0);
        }

        // 커스텀 구분자 추출 및 삭제
        input = extractCustomDividerFromInput(input, dividers);
        validateInput(input, dividers);

        return splitStringWithDividers(input, dividers).stream()
                .map(this::parseToInt)
                .toList();
    }

    private String extractCustomDividerFromInput(String input, List<String> dividers) {
        if (input.startsWith("/")) {
            validateCustomDividerInput(input);
            dividers.add(input.substring(2, 3));
            input = input.substring(5);
        }
        return input;
    }

    private void validateCustomDividerInput(String customDividerInput) {
        if (!customDividerInput.startsWith("//") || !customDividerInput.startsWith("\\n", 3)) {
            throw new InvalidInputException(customDividerInput, ErrorMessage.CUSTOM_INPUT_ERROR);
        }
    }

    private void validateInput(String defaultDividerInput, List<String> dividers) {
        String dividersString = String.join("", dividers);
        String regex = "^(\\d+[,:" + dividersString + "])*\\d+$";
        if (!Pattern.matches(regex, defaultDividerInput)) {
            throw new InvalidInputException(defaultDividerInput, ErrorMessage.INVALID_INPUT);
        }
    }

    private List<String> splitStringWithDividers(String input, List<String> dividers) {
        return List.of(input.split(String.join("|", dividers)));
    }

    private int parseToInt(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException(value, ErrorMessage.NOT_A_NUMBER_INPUT);
        }
    }

    public int calculateSum(List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
