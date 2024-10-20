package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringParser {
    public int[] parseString(String input) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        DelimiterExtractionResult extractionResult = delimiterExtractor.extractDelimiter(input);

        StringBuilder builder = new StringBuilder("[");
        for (String delimiter : extractionResult.delimiters) {
            builder.append(delimiter);
        }
        builder.append("]");

        Pattern pattern = Pattern.compile(builder.toString());
        String[] tokens = extractionResult.input.split(pattern.toString());

        return Arrays.stream(tokens).map(InputValidator::validateToken)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
