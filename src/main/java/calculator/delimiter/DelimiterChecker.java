package calculator.delimiter;

public class DelimiterChecker {

    public boolean isCustomDelimiter(String userInput) {
        return userInput.startsWith("//") && userInput.contains("\n");
    }

}