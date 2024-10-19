package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StringParser {
    private static final String DEFAULTDELEMETERS = ",:";

    public static List<BigInteger> extractNumbers(String input) {
        List<BigInteger> numberList = new ArrayList<>();
        String inputWithoutCustomDelimiter;
        List<Character> delimiters = DelimeterHandler.extractDelimiters(input);

        if (DelimeterHandler.hasCustomDelimiter(input) == true) {
            int newlineIdx = input.indexOf("\\n");
            inputWithoutCustomDelimiter = input.substring(newlineIdx + 2);
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

                if (number.matches("\\d+") == false) {
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
