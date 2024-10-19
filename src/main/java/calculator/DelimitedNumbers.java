package calculator;

import java.util.Arrays;

public class DelimitedNumbers {
    public static final String ZERO_STRING = "\"\"";
    public static final String ONLY_DIGITS = "\\d+";

    private final String stringNumbers;

    public DelimitedNumbers(String stringNumbers, DelimiterResult regex) {
        validate(stringNumbers, regex);
        this.stringNumbers = stringNumbers;
    }

    private void validate(String stringNumbers, DelimiterResult regex) {
        if (stringNumbers.equals(ZERO_STRING)) {
            return;
        }
        validateContainsDelimiter(stringNumbers, regex);
    }

    private void validateContainsDelimiter(String stringNumbers, DelimiterResult regex) {
        if (stringNumbers.contains(ZERO_STRING)) {
            return;
        }

        if (stringNumbers.matches(ONLY_DIGITS)) {
            return;
        }

        String[] validDelimiters = makeValidateRegex(regex);
        for (char delimiter : stringNumbers.toCharArray()) {
            if (!Arrays.asList(validDelimiters).contains(String.valueOf(delimiter)) && !Character.isDigit(delimiter)
                    && !Character.isWhitespace(delimiter)) {
                throw new IllegalArgumentException("입력된 구분자 중 잘못된 구분자가 있습니다");
            }
        }

    }

    private String[] makeValidateRegex(DelimiterResult regex) {
        String delimiterResult = regex.getDelimiterResult();
        String delimiters = regex.getDelimiterResult().substring(1, delimiterResult.length() - 1);
        return delimiters.split("");
    }

    public String getStringNumbers() {
        return stringNumbers;
    }
}