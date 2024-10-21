package calculator;

import java.util.regex.Pattern;

public class Distiniction {
    public static String[] splitInput(String input) {
        String delimiter = "[,:]";

        // 커스텀 구분자가 있는 경우 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                String customDelimiter = input.substring(2, delimiterEndIndex);
                delimiter = Pattern.quote(customDelimiter);
                input = input.substring(delimiterEndIndex + 2);
            }
        }

        return input.split(delimiter);
    }
}
