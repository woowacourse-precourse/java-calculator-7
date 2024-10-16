package calculator.utils;

public class Parser {
    private final String userInput;

    public Parser(String userInput) {
        this.userInput = userInput;
    }

    private boolean isCustomDelimiter() {
        return userInput.startsWith("//") && userInput.startsWith("\\n", 3);
    }
}
