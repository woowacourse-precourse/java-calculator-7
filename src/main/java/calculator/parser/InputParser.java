package calculator.parser;

import java.util.regex.Pattern;

public class InputParser {

    DelimiterExtractor extractor = new DelimiterExtractor();

    public String[] parseInput(String input) {
        if (input.isEmpty()) {
            return new String[]{};
        }
        if (input.startsWith("//")) {
            String customDelimiter = Pattern.quote(extractor.extractCustomDelimiter(input));
            return input.substring(extractor.getBeginIndex()).split(customDelimiter);
        }
        return input.split(extractor.getDefaultDelimiter());
    }
}
