package calculator.model;

import calculator.model.Dto.DelimiterInputData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        return extractedStrings.stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
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

}
