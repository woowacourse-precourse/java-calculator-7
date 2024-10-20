package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private boolean isDefaultDelimiter(String userInput) {

        String[] stringArray = userInput.split("[,:]");
        for (String s : stringArray) {
            if (!s.matches("[+]?\\d*(\\.\\d+)?")) {
                return false;
            }
        }
        return true;
    }

    private boolean isCustomDelimiter(String userInput) {

        String regex = "^//(.*?)\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);

        if (!matcher.find()) return false;

        String delimiter = matcher.group(1);
        int prefixLength = matcher.group().length();
        String[] stringArray = userInput.substring(prefixLength).split(delimiter);

        for (String s : stringArray) {
            if (!s.matches("[+]?\\d*(\\.\\d+)?")) {
                return false;
            }
        }
        return true;

    }

    public DelimiterType isValidInput(String userInput) {
        if (userInput.isEmpty()) return DelimiterType.EMPTY;
        if (isDefaultDelimiter(userInput)) return DelimiterType.DEFAULT;
        if (isCustomDelimiter(userInput)) return DelimiterType.CUSTOM;
        throw new IllegalArgumentException();
    }
}
