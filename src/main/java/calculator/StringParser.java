package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final String CUSTOM_DELIMITERS_END = "\\n";
    private static final String NUMBER_REGEX = "\\d+";

    public static List<BigInteger> extractNumbers(String input) {
        List<BigInteger> numberList = new ArrayList<>();
        String inputWithoutCustomDelimiter;
        List<Character> delimiters = DelimeterHandler.extractDelimiters(input);

        if (DelimeterHandler.hasCustomDelimiter(input) == true) {
            int customDelimiterEndIndex = input.indexOf(CUSTOM_DELIMITERS_END);
            inputWithoutCustomDelimiter = input.substring(customDelimiterEndIndex + CUSTOM_DELIMITERS_END.length());
        } else {
            inputWithoutCustomDelimiter = input;
        }

        int numberStartIdx = 0;
        for (int i = 0; i < inputWithoutCustomDelimiter.length(); i++) {
            if (delimiters.contains(inputWithoutCustomDelimiter.charAt(i)) == true
                    || i == inputWithoutCustomDelimiter.length() - 1) {

                int ifend = 0;
                if (i == inputWithoutCustomDelimiter.length() - 1) {
                    ifend = 1;
                }
                String number = inputWithoutCustomDelimiter.substring(numberStartIdx, i + ifend);

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

}
