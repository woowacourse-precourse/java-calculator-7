package calculator.extractor;

public class NumberExtractor {

    public String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            return extractCustomNumbersPart(input);
        }
        return input.trim();
    }

    private String extractCustomNumbersPart(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        return input.substring(delimiterEndIndex + 2);
    }

}
