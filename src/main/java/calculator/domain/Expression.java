package calculator.domain;

import calculator.validator.Validator;

public class Expression {
    private final String delimiter;
    private final String[] tokens;

    public Expression(String input) {
        Validator.validateInput(input);
        this.delimiter = extractDelimiter(input);
        this.tokens = splitNumbers(input, delimiter);
    }

    private String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String delimiter = input.substring(2, newlineIndex);
            Validator.validateDelimiter(delimiter);
            return delimiter;
        }
        return ",|:";
    }

    private String[] splitNumbers(String input, String delimiter) {
        String processedInput = input;
        if (input.startsWith("//")) {
            processedInput = input.substring(input.indexOf("\n") + 1);
        }
        String[] tokens = processedInput.split(delimiter);
        Validator.validateTokens(tokens);
        return tokens;
    }

    public int calculateSum() {
        int sum = 0;
        for (String number : tokens) {
            int num = parseNumber(number);
            sum += num;
        }
        return sum;
    }

    private int parseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String[] getTokens() {
        return tokens;
    }
}