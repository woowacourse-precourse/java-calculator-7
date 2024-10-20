package calculator;

import java.util.HashSet;

public class CalculaterSeparator {

    public static String process(String input, HashSet<String> delimiters) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        delimiters.add(",");
        delimiters.add(":");

        String remainingString = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");

            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("\\n이 없습니다.");
            }

            String customDelimiterPart = input.substring(2, delimiterEndIndex);

            if (delimiters.contains(customDelimiterPart)) {
                throw new IllegalArgumentException("커스텀 구분자와 기본 구분자는 동일할 수 없습니다.");
            }

            if (customDelimiterPart.length() > 1) {
                throw new IllegalArgumentException("커스텀 구분자는 하나만 입력할 수 있습니다.");
            }

            delimiters.add(customDelimiterPart);
            remainingString = input.substring(delimiterEndIndex + 2);

            if (remainingString.contains("//")) {
                throw new IllegalArgumentException("커스텀 구분자는 하나만 입력할 수 있습니다.");
            }
        }

        return remainingString;
    }
}
