package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String userInput;
    private String customDelimiter;
    private Integer calculateResult;
    private final CalculatorDelimiter calculatorDelimiter;
    private static final String INVALID_INPUT_ERROR = "[ERROR] Invalid input format : ";
    private static final String RESULT_HEADER_MESSAGE = "결과 : ";


    public Calculator() {
        this.calculatorDelimiter = new CalculatorDelimiter();
    }

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
        return this.calculatorDelimiter.checkDelimiterHead(this.userInput);
    }

    private void processCustomDelimiter() {
        String normalizedInput = this.calculatorDelimiter.changeToNormalizedInput(this.userInput);
        Matcher matcher = this.calculatorDelimiter.getMatcherByCheckPattern(normalizedInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

        this.customDelimiter = matcher.group(1);
        String targetNumbersWithDelimiters = matcher.group(2);

        if (!containsNumbers(targetNumbersWithDelimiters)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    private Boolean containsNumbers(String givenInput) {
        return this.calculatorDelimiter.isContainNumber(givenInput);
    }

    private void validateDefaultDelimiterFormat() {
        if (this.calculatorDelimiter.isNotDefaultDelimiter(this.userInput)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public Integer getSumByCalculate() {
        String targetNumbersWithDelimiter = this.userInput;
        String delimiter = this.calculatorDelimiter.getCustomDelimiterIfPresent(targetNumbersWithDelimiter,this.customDelimiter);
        targetNumbersWithDelimiter = this.calculatorDelimiter.stripCustomDelimiterFromInput(targetNumbersWithDelimiter);
        this.calculateResult = Arrays.stream(targetNumbersWithDelimiter.split(delimiter))
                .filter(this.calculatorDelimiter::isContainNumber)
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