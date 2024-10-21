package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator {
    private String userInput;
    private String customDelimiter;
    private Integer calculateResult;
    private static final String INVALID_INPUT_ERROR = "[ERROR] Invalid input format : ";
    private static final String RESULT_HEADER_MESSAGE = "결과 : ";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+?)\\n(.*)");
    private static final Pattern CONTAINS_NUMBERS_PATTERN = Pattern.compile(".*\\d+.*");
    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("^[0-9,:,\\s]*$");


    public Calculator() {}

    public Boolean checkInputByRule() {
        if (isUserInputEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR+"user Input is Empty");
        }

        if (isCustomDelimiterFormat()) {
            processCustomDelimiter();
        } else {
            validateDefaultDelimiterFormat();
        }
        return true;
    }

    private Boolean isUserInputEmpty() {
        return userInput == null || userInput.isEmpty();
    }

    private Boolean isCustomDelimiterFormat() {
        return userInput.startsWith("//");
    }

    private void processCustomDelimiter() {
        String normalizedInput = userInput.replace("\\n", "\n");
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(normalizedInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

        customDelimiter = matcher.group(1);
        String targetNumbersWithDelimiters = matcher.group(2);

        if (!containsNumbers(targetNumbersWithDelimiters)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private Boolean containsNumbers(String input) {
        return CONTAINS_NUMBERS_PATTERN.matcher(input).matches();
    }

    private void validateDefaultDelimiterFormat() {
        if (!DEFAULT_DELIMITER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }


    public Integer getSumByCalculate() {
        String defaultDelimiter = ",|:";
        String numbers = userInput;

        if (userInput.startsWith("//")) {
            defaultDelimiter = Pattern.quote(customDelimiter) + "|,|:";
            numbers = userInput.substring(userInput.indexOf("\n") + 1);
        }

        this.calculateResult = Arrays.stream(numbers.split(defaultDelimiter))
                .filter(s -> !s.trim().isEmpty())
                .filter(s -> CONTAINS_NUMBERS_PATTERN.matcher(s).matches())
                .mapToInt(this::parsePositiveInt)
                .sum();

        return this.calculateResult;
    }

    private int parsePositiveInt(String str) {
        str = str.trim();
        try {
            str = str.replaceAll("[^0-9]", "");
            int num = Integer.parseInt(str);
            if (num < 0) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR+"Negative numbers are not allowed");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
    public String setUserInputByCustomConsole() {
        try {
            this.userInput = Console.readLine();
            return this.userInput;
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR+"Out of memory", e);
        }
    }
    public void resultShowConsole() {
        System.out.println(RESULT_HEADER_MESSAGE + this.calculateResult);
    }

    public String resultShowConsole(String givenInput) {
        if(givenInput == null || givenInput.isEmpty()) {
            System.out.println(this.calculateResult);
            return RESULT_HEADER_MESSAGE +this.calculateResult;
        }
        String outMessage =  RESULT_HEADER_MESSAGE + givenInput;
        System.out.println(outMessage);
        return outMessage;
    }
}