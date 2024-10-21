package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private String[] splitInput(String input) {
        String delimiter = ",|:"; // 기본 구분자
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            input = input.substring(delimiterIndex + 1);
        }

        return input.split(delimiter);
    }
}