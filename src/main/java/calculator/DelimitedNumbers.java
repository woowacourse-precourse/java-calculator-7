package calculator;

import java.util.Arrays;

public class DelimitedNumbers {
    private final String stringNumbers;

    public DelimitedNumbers(String stringNumbers, DelimiterResult regex) {
        validate(stringNumbers, regex);
        this.stringNumbers = stringNumbers;
    }

    private void validate(String stringNumbers, DelimiterResult regex) {
        if (stringNumbers.equals(Constants.EMPTY_STRING)) {
            return;
        }
        validateContainsDelimiter(stringNumbers, regex);

    }

    private void validateContainsDelimiter(String stringNumbers, DelimiterResult regex) {
        if (stringNumbers.contains(Constants.EMPTY_STRING)) {
            return;
        }

        if (stringNumbers.matches(Constants.ONLY_DIGITS)) {
            return;
        }

        String[] validDelimiters = extractValidDelimiters(regex);

        for (char delimiter : stringNumbers.toCharArray()) {
            if (!Arrays.asList(validDelimiters).contains(String.valueOf(delimiter)) && !Character.isDigit(delimiter)
                    && !Character.isWhitespace(delimiter)) {
                throw new IllegalArgumentException("입력된 구분자 중 잘못된 구분자가 있습니다");
            }
        }

    }

    private String[] extractValidDelimiters(DelimiterResult regex) {
        String delimiterResult = regex.getDelimiterResult();
        String delimiters = regex.getDelimiterResult().substring(1, delimiterResult.length() - 1);

        return delimiters.split("");
    }

    public String getStringNumbers() {
        return stringNumbers;
    }

}