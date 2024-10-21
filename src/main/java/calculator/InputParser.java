package calculator;

public class InputParser {

    private String delimiters;
    private String numbersSection;

    public InputParser(String input) {
        delimiters = ":,";
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
        return input.startsWith("//") && (input.indexOf("\\n") == input.indexOf("//") + 3);
    }

    private String extractCustomDelimiter(String input) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n");

        String delimiter = input.substring(startIndex, endIndex);

        return escapeSpecialCharacters(delimiter);
    }

    private String extractNumbersSection(String input) {
        return input.substring(input.indexOf("\\n") + 2);
    }

    private String escapeSpecialCharacters(String delimiter) {
        StringBuilder escapedDelimiter = new StringBuilder();

        for (char ch : delimiter.toCharArray()) {
            if ("|*+()[]{}.^$\\&".indexOf(ch) != -1) {
                escapedDelimiter.append("\\"); // 이스케이프 문자 추가
            }
            escapedDelimiter.append(ch);
        }

        return escapedDelimiter.toString();
    }
}
