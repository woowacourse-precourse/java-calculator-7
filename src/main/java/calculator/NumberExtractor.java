package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {

    public static List<Long> parseInput(DelimiterInputDTO delimiterInputDTO) {

        String input = delimiterInputDTO.getInput();
        List<Character> delimiter = delimiterInputDTO.getDelimiter();
        StringBuilder stringBuilder = new StringBuilder();

        List<Long> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);

            if (delimiter.contains(tmp)) {
                if (!stringBuilder.isEmpty()) {
                    Long parsedNum = parseAndReset(stringBuilder);
                    result.add(parsedNum);
                }
                continue;
            }

            if (Character.isDigit(tmp)) {
                appendDigit(tmp, stringBuilder);
            } else {
                throw new IllegalArgumentException();
            }
        }

        if (!stringBuilder.isEmpty()) {
            result.add(parseAndReset(stringBuilder));
        }

        return result;
    }

    private static Long parseAndReset(StringBuilder stringBuilder) {
        Long parsedNum = Long.parseLong(stringBuilder.toString());
        stringBuilder.setLength(0);

        return parsedNum;
    }

    private static void appendDigit(char tmp, StringBuilder stringBuilder) {
        Long num = Long.parseLong(String.valueOf(tmp));
        if (num <= 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야 합니다.");
        }
        stringBuilder.append(tmp);
    }
}
