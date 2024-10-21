package calculator.domain;

import java.util.regex.Pattern;

public class UserInput {

    private String input;
    private final Delimiter delimiter;

    private final static Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//.\\n");

    public UserInput(String input) {
        validateInput(input);

        this.input = input;
        delimiter = new Delimiter();
    }

    public String parseInput() {
        if (isContainCustomDelimiter()) {
            delimiter.addCustomDelimiter(removeCustomDelimiterRegex());
        }

        return delimiter.removeDelimiter(getInput());
    }

    private String removeCustomDelimiterRegex() {
        String[] parser = input.split("\n");

        this.input = parser[1];
        return parser[0].replace("//", "");
    }

    private void validateInput(String input) {
        if (Pattern.matches("[a-zA-Z]+", input)) {
            throw new IllegalArgumentException("허용되지 않은 문자가 입력되었습니다.");
        }
    }

    private boolean isContainCustomDelimiter() {
        return input.startsWith("//") && CUSTOM_DELIMITER_REGEX.matcher(input).find();
    }

    private String getInput() {
        return input;
    }
}
