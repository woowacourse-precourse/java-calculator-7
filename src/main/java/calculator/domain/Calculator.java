package calculator.domain;

import calculator.domain.parser.InputParser.ParsedInput;
import java.math.BigInteger;

public class Calculator {

    public static String calculate(ParsedInput parsedInput) {
        String sum = "0";
        for (String numStr : parsedInput.numbers()) {
            sum = addStrings(sum, numStr);
        }

        return sum;
    }

    private static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            int x = (p1 >= 0) ? num1.charAt(p1--) - '0' : 0;
            int y = (p2 >= 0) ? num2.charAt(p2--) - '0' : 0;
            int sum = x + y + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }

}
