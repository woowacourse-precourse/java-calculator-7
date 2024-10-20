package calculator.front.input;

import java.util.List;

public record CustomDelimiterParsedInput(List<Character> delimiters, String inputWithDelimiter) {

    public CustomDelimiterParsedInput(String inputWithDelimiter) {
        this(List.of(), inputWithDelimiter);
    }

    public CustomDelimiterParsedInput(Character delimiter, String inputWithDelimiter) {
        this(List.of(delimiter), inputWithDelimiter);
    }
}
