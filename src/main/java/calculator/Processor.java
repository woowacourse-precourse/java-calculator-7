package calculator;

public class Processor {

    public Processor() {
    }

    private static final String DELIMITER_DECLARATION_SECTION = "\\";
    private static final String DELIMITER_AND_NUMBERS_SEPARATOR = "\n";

    public String extractCustomDelimiter(String input) {
        if (input.startsWith(DELIMITER_DECLARATION_SECTION)) {
            int delimiterStart = DELIMITER_DECLARATION_SECTION.length();
            int delimiterEnd = input.indexOf(DELIMITER_AND_NUMBERS_SEPARATOR);
            return input.substring(delimiterStart, delimiterEnd);
        }
        return "";
    }
}
