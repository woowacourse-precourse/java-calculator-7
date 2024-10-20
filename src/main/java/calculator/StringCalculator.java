package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String checkDelimiterPattern = "^//(.)\\\\n";


    private String userInput;
    private List<String> delimiters;

    public StringCalculator() {
        userInput = null;
        delimiters = new ArrayList<String>(Arrays.asList(",", ":"));
    }

    public void run() {
        userInput = getUserInput();
        String customDelimiter = getCustomDelimiter(userInput);
        addCustomDelimiter(customDelimiter);

        calculateSum(userInput, delimiters);
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private void addCustomDelimiter(String delimiter) {
        delimiters.add(delimiter);
    }

    public String getCustomDelimiter(String userInput) {
        String checkNumberPattern = "[0-9]";

        Pattern pattern = Pattern.compile(checkDelimiterPattern);
        Matcher matcher = pattern.matcher(userInput);

        if (!matcher.find())
            return null;

        String result = matcher.group(1);
        if (Pattern.matches(checkNumberPattern, result))
            throw new IllegalArgumentException("Cannot specify a number with a custom delimiter.");

        return result;
    }

    public void calculateSum(String userInput, List<String> delimiters) {
        String removed = removeHeaderFromInput(userInput);
    }

    public String removeHeaderFromInput(String userInput) {
        Pattern pattern = Pattern.compile(checkDelimiterPattern);
        Matcher matcher = pattern.matcher(userInput);

        if (!matcher.find())
            return userInput;

        return matcher.replaceAll("");
    }
}
