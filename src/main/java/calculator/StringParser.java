package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final String CUSTOM_DELIMITERS_END = "\\n";
    private static final String NUMBER_REGEX = "\\d+";

    public static List<BigInteger> extractNumbers(String input) {
        List<BigInteger> numberList = new ArrayList<>();
        String inputWithoutCustomDelimiter = removeCustomDelimiter(input);
        List<Character> delimiters = DelimeterHandler.extractDelimiters(input);

        int numberStartIdx = 0;
        int numberEndIdx = 0;
        for (int i = 0; i < inputWithoutCustomDelimiter.length(); i++) {
            boolean isLastCharacter = (i == inputWithoutCustomDelimiter.length() - 1);
            boolean isDelimiter = delimiters.contains(inputWithoutCustomDelimiter.charAt(i));

            if (isDelimiter == true || isLastCharacter == true) {
                numberEndIdx = isLastCharacter ? i : i - 1;
                String number = inputWithoutCustomDelimiter.substring(numberStartIdx, numberEndIdx + 1);

                if (number.matches(NUMBER_REGEX) == false) {
                    throw new IllegalArgumentException("Invalid number: " + number);
                }

                BigInteger bigint = new BigInteger(number);
                numberList.add(bigint);
                numberStartIdx = i + 1;
            }
        }
        return numberList;
    }

    private static String removeCustomDelimiter(String input) {
        if (DelimeterHandler.hasCustomDelimiter(input) == true) {
            int customDelimiterEndIndex = input.indexOf(CUSTOM_DELIMITERS_END);
            return input.substring(customDelimiterEndIndex + CUSTOM_DELIMITERS_END.length());
        } else {
            return input;
        }
    }
}
