package calculator.controller;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String CUSTOM_DELIMITER = "^//(.*)\\\\n(.*)";
    private static final String DEFAULT_DELIMITER = "[:,]";
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void calculate() {
        outputHandler.showEntryMessage();
        String userInput = inputHandler.getUserInput();

        Matcher customPatternMatcher = Pattern.compile(CUSTOM_DELIMITER).matcher(userInput);
        boolean isCustomPatternMatch = customPatternMatcher.matches();
        if (isCustomPatternMatch) {
            String delimiter = customPatternMatcher.group(1);
            String quotedDelimiter = Pattern.quote(delimiter);
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 필요합니다.");
            }
            if (Character.isDigit(delimiter.charAt(0))) {
                throw new IllegalArgumentException("커스텀 구분자는 문자여야 합니다.");
            }
            String strippedTokens = customPatternMatcher.group(2);
            String[] tokens = strippedTokens.split(quotedDelimiter);
            int sum = Arrays.stream(tokens)
                    .filter(string -> !string.isEmpty())
                    .mapToInt(this::parsePositiveInt)
                    .sum();

            outputHandler.showCalculatedValue(sum);
            return;
        }

        String[] tokens = userInput.split(DEFAULT_DELIMITER);
        int sum = Arrays.stream(tokens)
                .filter(string -> !string.isEmpty())
                .mapToInt(this::parsePositiveInt)
                .sum();

        outputHandler.showCalculatedValue(sum);
    }

    private int parsePositiveInt(String str) {
        try {
            int integer = Integer.parseInt(str);
            if (integer < 0) {
                throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
            }
            return integer;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 사용할 수 있습니다.");
        }
    }
}