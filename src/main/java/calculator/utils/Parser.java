package calculator.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final String userInput;
    private final List<String> numbers = new ArrayList<>();

    public Parser(String userInput) {
        this.userInput = userInput;
    }

    private List<String> parseWithDefaultDelimiter() {
        String defaultDelimiter = "[,:]";
        String[] tokens = userInput.split(defaultDelimiter);

        for (String token : tokens) {
            numbers.add(token);
        }

        return numbers;
    }

    private boolean isCustomDelimiter() {
        return userInput.startsWith("//") && userInput.startsWith("\\n", 3);
    }
}
