package calculator;

import java.util.ArrayList;
import java.util.List;

public class Processor {

    public Processor() {
    }

    private static final String DELIMITER_DECLARATION_SECTION = "\\";
    private static final String DELIMITER_AND_NUMBERS_SEPARATOR = "\n";
    private List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public void execute(String input) {
        if (input.startsWith(DELIMITER_DECLARATION_SECTION)) {
            String customDelimiter = extractCustomDelimiter(input);
            delimiters.add(customDelimiter);
        }

        String[] splittedStrings = splitByDelimiters(input);
    }

    public String extractCustomDelimiter(String input) {
        int delimiterStart = DELIMITER_DECLARATION_SECTION.length();
        int delimiterEnd = input.indexOf(DELIMITER_AND_NUMBERS_SEPARATOR);
        return input.substring(delimiterStart, delimiterEnd);

    }

    private String[] splitByDelimiters(String input) {
        String regex = String.join("|", delimiters.stream()
                .map(delimiter -> "\\" + delimiter)
                .toArray(String[]::new));
        return input.split(regex);
    }
}
