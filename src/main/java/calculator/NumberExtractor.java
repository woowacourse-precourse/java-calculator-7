package calculator;

import java.util.List;

public class NumberExtractor {

    public static Long sumParsedNumbers(String input, List<Character> delimiters) {

        StringBuilder delimitedString = new StringBuilder();
        Long sum = 0L;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (delimiters.contains(currentChar)) {
                if (!delimitedString.isEmpty()) {
                    sum += parseNumber(delimitedString);
                }
                continue;
            }

            if (Character.isDigit(currentChar)) {
                appendDigit(currentChar, delimitedString);
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (!delimitedString.isEmpty()) {
            sum += parseNumber(delimitedString);
        }

        return sum;
    }

    private static Long parseNumber(StringBuilder delimitedString) {
        Long parsedNum = Long.parseLong(delimitedString.toString());
        delimitedString.setLength(0);
        return parsedNum;
    }

    private static void appendDigit(char currentChar, StringBuilder stringBuilder) {
        long num = Long.parseLong(String.valueOf(currentChar));

        if (num <= 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야 합니다.");
        }

        stringBuilder.append(currentChar);
    }
}
