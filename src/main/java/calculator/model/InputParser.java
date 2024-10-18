package calculator.model;

public class InputParser {

    private static String delimiter = "[,:]";
    private int beginIndex;

    public String[] parseInput(String input) {
        if (input.isEmpty()) {
            return new String[]{};
        }
        if (input.startsWith("//")) {
            addCustomDelimiter(input);
            return input.substring(beginIndex).split(delimiter);
        }
        return input.split(delimiter);
    }

    private void addCustomDelimiter(String input) {
        String customDelimiter = extractCustomDelimiter(input);
        delimiter += "|" + customDelimiter;
    }

    public String extractCustomDelimiter(String input) {
        int startIndex = input.indexOf("//") + 2;
        int delimiterEnd = input.indexOf("\\n");
        setBeginIndex(delimiterEnd);
        return input.substring(startIndex, delimiterEnd);
    }

    private void setBeginIndex(int delimiterEnd) {
        beginIndex = delimiterEnd + 2;
    }
}
