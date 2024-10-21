package calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {

    public List<String> splitByDelimiters(String input) {
        if (input.isEmpty()) {
            return List.of("0");
        }

        String delimiter = getDelimiter(input);
        String cleanedInput = cleanInputString(input);

        List<String> splitInput = Arrays.stream(cleanedInput.split(delimiter)).toList();
        validateNumbers(splitInput);
        return splitInput;
    }

    private String getDelimiter(String input) {
        String defaultDelimiter = ",|:";

        //커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("Invalid custom delimiter format.");
            }
            String customDelimiter = Pattern.quote(input.substring(2, delimiterIndex));
            return defaultDelimiter + "|" + customDelimiter;
        }

        return defaultDelimiter;  //기본 구분자 반환
    }

    private String cleanInputString(String input) {
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            input = input.substring(delimiterIndex + 2);
        }
        return input;
    }

    public long sum(List<String> splitInput) {
        return splitInput.stream()
                .mapToLong(Long::parseLong)
                .sum();
    }

    private void validateNumbers(List<String> splitInput) {
        splitInput.forEach(value -> {
            if (isNotNumeric(value)) {
                throw new IllegalArgumentException();
            }

            long number = Long.parseLong(value);
            if (number <= 0) {
                throw new IllegalArgumentException();
            }
        });
    }

    private boolean isNotNumeric(String value) {
        try {
            Long.parseLong(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
