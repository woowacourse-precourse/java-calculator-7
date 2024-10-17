package calculator;

import java.util.Arrays;

public class InputNumberStrings {
    private final String stringNumbers;

    public InputNumberStrings(String stringNumbers, DelimiterResult regex) {
        validate(stringNumbers, regex);
        this.stringNumbers = stringNumbers;
    }

    private void validate(String stringNumbers, DelimiterResult regex) {
        if (stringNumbers.equals("\"\"")) {
            return;
        }
        validateContainsDelimiter(stringNumbers, regex);
    }

    private void validateContainsDelimiter(String stringNumbers, DelimiterResult regex) {
        String[] validDelimiters = makeValidateRegex(regex);

        for (char c : stringNumbers.toCharArray()) {
            if (!Arrays.asList(validDelimiters).contains(String.valueOf(c)) && !Character.isDigit(c)
                    && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("입력된 구분자 중 잘못된 구분자가 있습니다");
            }
        }
    }

    private String[] makeValidateRegex(DelimiterResult regex) {
        String delimiterResult = regex.getDelimiterResult();
        String delimiters = regex.getDelimiterResult().substring(1, delimiterResult.length() - 1);
        return delimiters.split("");
    }


    public String[] split(String delimiterResult) {
        return stringNumbers.split(delimiterResult);
    }

}