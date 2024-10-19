package calculator.front.input;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TotalDelimitedInput {
    private final List<Character> delimiters;
    private final String inputWithDelimiters;

    public TotalDelimitedInput(List<Character> delimiters, String inputWithDelimiters) {
        this.delimiters = delimiters;
        this.inputWithDelimiters = inputWithDelimiters;
    }

    public static TotalDelimitedInput fromCustomDelimiterParseInput(
            CustomDelimiterParsedInput customDelimiterParsedInput) {
        List<Character> allDefaultDelimiters = DefaultDelimiter.getAllDefaultDelimiters();
        allDefaultDelimiters.addAll(customDelimiterParsedInput.delimiters());
        return new TotalDelimitedInput(allDefaultDelimiters, customDelimiterParsedInput.inputWithDelimiter());
    }

    public List<Character> getDelimiters() {
        return delimiters;
    }

    public String getInputWithDelimiters() {
        return inputWithDelimiters;
    }

    enum DefaultDelimiter {
        COLUMN(':'), COMMA(',');

        private final Character delimiter;

        DefaultDelimiter(Character delimiter) {
            this.delimiter = delimiter;
        }

        private Character getDelimiter() {
            return this.delimiter;
        }

        private static List<Character> getAllDefaultDelimiters() {
            return Stream.of(DefaultDelimiter.values()).map(DefaultDelimiter::getDelimiter)
                    .collect(Collectors.toList());
        }
    }
}
