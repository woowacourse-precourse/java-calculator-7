package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {

    public static List<Long> parseInput(String input, List<Character> delimiters) {

        StringBuilder stringBuilder = new StringBuilder();
        List<Long> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (delimiters.contains(currentChar)) {
                if (!stringBuilder.isEmpty()) {
                    parseAndReset(result, stringBuilder);
                }
                continue;
            }

            if (Character.isDigit(currentChar)) {
                appendDigit(currentChar, stringBuilder);
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (!stringBuilder.isEmpty()) {
            parseAndReset(result, stringBuilder);
        }

        return result;
    }

    private static void parseAndReset(List<Long> result, StringBuilder stringBuilder) {
        Long parsedNum = Long.parseLong(stringBuilder.toString());
        stringBuilder.setLength(0);
        result.add(parsedNum);
    }

    private static void appendDigit(char currentChar, StringBuilder stringBuilder) {
        long num = Long.parseLong(String.valueOf(currentChar));

        if (num <= 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야 합니다.");
        }

        stringBuilder.append(currentChar);
    }
}
