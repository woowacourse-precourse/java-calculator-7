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
        return this.userInput == null || this.userInput.isEmpty();
    }

    private Boolean isCustomDelimiterFormat() {
        return this.userInput.startsWith(CalculatorDelimiter.DEFINE_CUSTOM_DELIMITER_HEAD);
    }

    private void processCustomDelimiter() {
        String normalizedInput = this.userInput.replace("\\n", CalculatorDelimiter.DEFINE_CUSTOM_DELIMITER_LAST);
        Matcher matcher = CalculatorDelimiter.CUSTOM_DELIMITER_PATTERN.matcher(normalizedInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

        this.customDelimiter = matcher.group(1);
        String targetNumbersWithDelimiters = matcher.group(2);

        if (!containsNumbers(targetNumbersWithDelimiters)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private Boolean containsNumbers(String input) {
        return CalculatorDelimiter.CONTAINS_NUMBERS_PATTERN.matcher(input).matches();
    }

    private void validateDefaultDelimiterFormat() {
        if (!CalculatorDelimiter.DEFAULT_DELIMITER_PATTERN.matcher(this.userInput).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }


    public Integer getSumByCalculate() {
        String delimiter = CalculatorDelimiter.DEFAULT_DELIMITER;
        String targetNumbersWithDelimiter = this.userInput;

        if (this.userInput.startsWith(CalculatorDelimiter.DEFINE_CUSTOM_DELIMITER_HEAD)) {
            delimiter = Pattern.quote(this.customDelimiter) + "|" + CalculatorDelimiter.DEFAULT_DELIMITER;
            targetNumbersWithDelimiter = this.userInput.substring(this.userInput.indexOf("\\n")
                    + CalculatorDelimiter.DEFINE_CUSTOM_DELIMITER_LAST_SIZE);
        }

        this.calculateResult = Arrays.stream(targetNumbersWithDelimiter.split(delimiter))
                .filter(slicedString -> !slicedString.trim().isEmpty())
                .filter(slicedString -> CalculatorDelimiter.CONTAINS_NUMBERS_PATTERN.matcher(slicedString).matches())
                .mapToInt(this::parsePositiveInt)
                .sum();

        return this.calculateResult;
    }

    private int parsePositiveInt(String str) {
        try {
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