package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private String userInput;
    private List<String> delimiters;

    public StringCalculator() {
        delimiters = new ArrayList<String>(Arrays.asList(",", ":"));
    }

    public void run() {
        userInput = getUserInput();
        String customDelimiter = getCustomDelimiter(userInput);
        addCustomDelimiter(customDelimiter);
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private void addCustomDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    public String getCustomDelimiter(String userInput) {
        String customDelimiterPattern = "^//(.)\\\\n";
        String checkNumberPattern = "[0-9]";

        Pattern pattern = Pattern.compile(customDelimiterPattern);
        Matcher matcher = pattern.matcher(userInput);

        if (!matcher.find())
            return null;

        String result = matcher.group(1);
        if (Pattern.matches(checkNumberPattern, result))
            throw new IllegalArgumentException("Cannot specify a number with a custom delimiter.");

        return result;
    }
}
