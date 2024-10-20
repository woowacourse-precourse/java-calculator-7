package calculator.util;

import calculator.domain.Expression;
import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    public static Expression convertToExpression(String input) {
        String delimiter = "[,:]";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring(2, delimiterIndex);
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException();
            }
            input = input.substring(delimiterIndex + 2);
        }
        if (input.isEmpty()) {
            input = "0";
        }

        Validator.validateExpression(input);
        return new Expression(input, delimiter);
    }

    public static String readInput() {
        String input = Console.readLine();
        Validator.validateNullInput(input);
        Validator.validateWhitespaceInput(input);
        return input;
    }
}