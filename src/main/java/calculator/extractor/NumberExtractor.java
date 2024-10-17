package calculator.extractor;

public class NumberExtractor {

    public String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            return input.substring(delimiterEndIndex + 2);
        }
        return input.trim();
    }

}
