package calculator.service;

public class StringParser {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String[] parseString(String input) {
        if (input.startsWith("//")) {
            String customDelimiter = findCustomDelimiter(input);
            String delimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
            return splitString(input.substring(input.indexOf("\\n") + 2), delimiters);
        }

        return splitString(input, DEFAULT_DELIMITERS);
    }

    private String findCustomDelimiter(String input) {
        int endIndex = input.indexOf("\\n");
        String customDelimiter = input.substring(2, endIndex);

        try {
            Integer.parseInt(customDelimiter);
            throw new IllegalArgumentException("구분자는 숫자일 수 없습니다.");
        } catch (NumberFormatException ignored) {
        }

        return customDelimiter;
    }

    private String[] splitString(String input, String delimiters) {
        return input.split(delimiters);
    }
}
