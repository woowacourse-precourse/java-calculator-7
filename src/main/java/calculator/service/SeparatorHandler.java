package calculator.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorHandler {
    private final InputHandler inputHandler = new InputHandler();
    private final ArrayList<Character> customSeparatorArray = new ArrayList<>();

    public String checkCustomSeparator(String input) {
        String separatorRegex = "^(//)(.)$";
        Pattern separatorPattern = Pattern.compile(separatorRegex);
        Matcher separatorMatcher = separatorPattern.matcher(input);

        while (separatorMatcher.matches()) {
            char c = separatorMatcher.group(2).charAt(0);
            customSeparatorArray.add(c);

            input = inputHandler.getUserInput();
            separatorMatcher = separatorPattern.matcher(input);
        }
        Console.close();

        String fullInputRegex = "^(//)(.)(\\\\n)(.*)";
        Pattern fullInputPattern = Pattern.compile(fullInputRegex);
        Matcher fullInputMatcher = fullInputPattern.matcher(input);

        while (fullInputMatcher.matches()) {
            char c = fullInputMatcher.group(2).charAt(0);
            customSeparatorArray.add(c);

            input = fullInputMatcher.group(4);
            fullInputMatcher = fullInputPattern.matcher(input);
        }

        return normalizeSeparators(input);
    }

    private String normalizeSeparators(String input) {
        input = input.replace(':', ',');

        for (char customSeparator : customSeparatorArray) {
            input = input.replace(customSeparator, ',');
        }

        return input;
    }
}
