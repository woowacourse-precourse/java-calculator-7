package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringParser {
    public int[] parseString(String input) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        DelimiterExtractionResult extractionResult = delimiterExtractor.extractDelimiter(input);

        Pattern pattern = createDelimiterRegex(extractionResult.delimiters);
        String[] tokens = extractionResult.input.split(pattern.toString());

        return Arrays.stream(tokens).map(InputValidator::validateToken)
                .filter(token -> !token.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private Pattern createDelimiterRegex(List<String> delimiters) {
        StringBuilder builder = new StringBuilder("[");
        for (String delimiter : delimiters) {
            builder.append(delimiter);
        }
        builder.append("]");

        return Pattern.compile(builder.toString());
    }
}
