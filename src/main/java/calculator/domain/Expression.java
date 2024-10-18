package calculator.domain;

import calculator.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {
    private final List<String> delimiters;;
    private final String[] tokens;

    public Expression(String input) {
        Validator.validateInput(input);
        this.delimiters = new ArrayList<>(Arrays.asList(",", ":"));

        extractAndAddCustomDelimiter(input);
        String processedInput = removeDelimiterDefinition(input);

        this.tokens = splitNumbers(processedInput);
    }

    private void extractAndAddCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            Validator.validateDelimiter(customDelimiter);
            delimiters.add(escapeIfSpecialCharacter( customDelimiter));
        }
    }

    private String escapeIfSpecialCharacter(String delimiter) {
        if (delimiter.matches("[\\W]")) {  // 특수문자 여부 확인
            return "\\" + delimiter;
        }
        return delimiter;
    }

    private String[] splitNumbers(String input) {
        String delimiterRegex = String.join("|", delimiters);
        String[] tokens = input.split(delimiterRegex);
        Validator.validateTokens(tokens);
        return tokens;
    }


    private String removeDelimiterDefinition(String input) {
        if (delimiters.size() == 3) {
            return input.substring(input.indexOf("\\n") + 2);
        }
        return input;
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
}