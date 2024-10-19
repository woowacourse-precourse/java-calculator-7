package calculator.model;

import calculator.model.dto.DelimiterInputData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberParser {
    private final Character customDelimiter;
    private final String input;

    public NumberParser(DelimiterInputData delimiterInputData) {
        this.customDelimiter = delimiterInputData.getcustomedDelimiter();
        this.input = delimiterInputData.getInput();
    }


    public List<Long> extractNumbers() {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }

        String regularExpression = makeRegularExpression(customDelimiter);
        List<String> extractedStrings = Arrays.stream(input.split(regularExpression))
                .filter(s -> !s.isEmpty())
                .toList();

        List<Long> numbers = new ArrayList<>();

        for (String str : extractedStrings) {
            numbers.add(convertToLong(str));
        }

        return numbers;

    }


    private String makeRegularExpression(Character customDelimiter) {
        return "[" + DelimiterInputData.COMMA + DelimiterInputData.COLON + changeExceptionWord(
                String.valueOf(customDelimiter)) + "]";
    }

    private String changeExceptionWord(String str) {

        return str.replace("\\", "\\\\")
                .replace("[", "\\[")
                .replace("]", "\\]");


    }

    private Long convertToLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("계산기가 계산 할 수 있는 범위를 초과했습니다.");
        }
    }

}
