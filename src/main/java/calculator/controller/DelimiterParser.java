package calculator.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    public String extractExpression(String userInput) {
        if (hasCustomDelimiterIn(userInput)) {
            return userInput.replaceAll("//.\\\\n", "");
        }
        return userInput;
    }

    public String extractDelimiter(String userInput) {
        if (hasCustomDelimiterIn(userInput)) {
            Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(userInput);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "[,;]";
    }

    public boolean hasCustomDelimiterIn(String userInput) {
        return userInput.matches("//.\\\\n.*");
    }
}
