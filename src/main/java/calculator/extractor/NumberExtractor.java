package calculator.extractor;

public class NumberExtractor {

    public String extractNumbersPart(String input) {
        if (input.startsWith(DelimiterExtractor.CUSTOM_DELIMITER_PREFIX)) {
            return extractCustomNumbersPart(input);
        }
        return input.trim();
    }

    private String extractCustomNumbersPart(String input) {
        int delimiterEndIndex = input.indexOf(DelimiterExtractor.CUSTOM_DELIMITER_SUFFIX);
        return input.substring(delimiterEndIndex + 2);
    }

}
