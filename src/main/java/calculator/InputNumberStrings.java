package calculator;

import java.util.Arrays;

public class InputNumberStrings {
    private final String stringNumbers;

    public InputNumberStrings(String stringNumbers, DelimiterResult regex) {
        ValidateContainsDelimiter(stringNumbers, regex);
        this.stringNumbers = stringNumbers;
    }

    private static void ValidateContainsDelimiter(String stringNumbers, DelimiterResult regex) {
        String[] validDelimiters = generateValidateRegex(regex);

        for (char c : stringNumbers.toCharArray()) {
            if (!Arrays.asList(validDelimiters).contains(String.valueOf(c)) && !Character.isDigit(c)
                    && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("입력된 구분자 중 잘못된 구분자가 있습니다");
            }
        }
    }

    private static String[] generateValidateRegex(DelimiterResult regex) {
        String delimiterResult = regex.getDelimiterResult();
        String delimiters = delimiterResult.substring(1, delimiterResult.length() - 1);
        String[] validDelimiters = delimiters.split("");
        return validDelimiters;
    }


    public String[] split(String delimiterResult) {
        return stringNumbers.split(delimiterResult);
    }
}
