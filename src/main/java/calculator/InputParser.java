package calculator;

public class InputParser {

    private static final String CUSTOM_DEF_START = "//";
    private static final String CUSTOM_DEF_END = "\\n";
    private static final String ESCAPE_STRING = "\\";
    private static final String DEFAULT_DELIMITERS = ":,";
    private static final String SPECIAL_CHARS_IN_REG = "|*+()[]{}.^$\\&";

    private String delimiters;
    private String numbersSection;

    public InputParser(String input) {
        delimiters = DEFAULT_DELIMITERS;
        numbersSection = input;
        parseDelimiterAndNumbersSection(input);
    }

    private void parseDelimiterAndNumbersSection(String input) {
        if (hasCustomDelimiter(input)) {
            this.delimiters = extractCustomDelimiter(input);
            this.numbersSection = extractNumbersSection(input);
        }
    }

    public String[] extractNums() {
        String regDelimiters = "[" + this.delimiters + "]";
        return this.numbersSection.split(regDelimiters);
    }

    public String getDelimiters() {
        return delimiters;
    }

    public String getNumbersSection() {
        return numbersSection;
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DEF_START) && (input.indexOf(CUSTOM_DEF_END)
                == input.indexOf(CUSTOM_DEF_START) + 3);
    }

    private String extractCustomDelimiter(String input) {
        int startIndex = input.indexOf(CUSTOM_DEF_START) + 2;
        int endIndex = input.indexOf(CUSTOM_DEF_END);

        String delimiter = input.substring(startIndex, endIndex);

        return escapeSpecialCharacters(delimiter);
    }

    private String extractNumbersSection(String input) {
        return input.substring(input.indexOf(CUSTOM_DEF_END) + 2);
    }

    private String escapeSpecialCharacters(String delimiter) {
        StringBuilder escapedDelimiter = new StringBuilder();

        for (char ch : delimiter.toCharArray()) {
            if (SPECIAL_CHARS_IN_REG.indexOf(ch) != -1) {
                escapedDelimiter.append(ESCAPE_STRING); // 이스케이프 문자 추가
            }
            escapedDelimiter.append(ch);
        }

        return escapedDelimiter.toString();
    }
}
