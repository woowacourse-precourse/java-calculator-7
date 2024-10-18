package calculator.util;

import java.util.regex.Pattern;

public class Parser {

    public static String[] parse(String input) {
        String delimiter = "[,:]";
        String numbers = input;

        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            int delimiterIndex = input.indexOf("\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 후 올바른 입력이 필요합니다.");
            }

            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            numbers = input.substring(delimiterIndex + 1);
        }

        return numbers.split(delimiter);
    }
}