package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Matcher;

public class Calculator {
    private String userInput;
    private String customDelimiter;
    private BigInteger calculateResult;
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
        if (this.calculatorDelimiter.isNotHaveAnyDelimiterFormat(this.userInput)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        if (this.calculatorDelimiter.isCustomDelimiterFormat(this.userInput)) {
            processCustomDelimiter();
        }
        return true;
    }
    private Boolean isUserInputEmpty() {
        return this.userInput == null || this.userInput.isEmpty();
    }
    private void processCustomDelimiter() {
        String normalizedInput = this.calculatorDelimiter.changeToNormalizedInput(this.userInput);
        Matcher matcher = this.calculatorDelimiter.getMatcherByCheckPattern(normalizedInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        int singleCustomDelimiterGroupIndex = 1;
        int targetNumbersWithDelimitersGroupIndex = 2;
        this.customDelimiter = matcher.group(singleCustomDelimiterGroupIndex);
        String targetNumbersWithDelimiters = matcher.group(targetNumbersWithDelimitersGroupIndex);
        if (!this.calculatorDelimiter.isContainNumber(targetNumbersWithDelimiters)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
    public BigInteger getSumByCalculate() {
        String targetNumbersWithDelimiter = this.userInput;
        String delimiter = this.calculatorDelimiter.getCustomDelimiterIfPresent(targetNumbersWithDelimiter, this.customDelimiter);
        targetNumbersWithDelimiter = this.calculatorDelimiter.stripCustomDelimiterFromInput(targetNumbersWithDelimiter);
        this.calculateResult = Arrays.stream(targetNumbersWithDelimiter.split(delimiter))
                .filter(this.calculatorDelimiter::isContainNumber)
                .map(this::parsePositiveBigInteger)
                .reduce(BigInteger.ZERO, BigInteger::add);
        return this.calculateResult;
    }
    private BigInteger parsePositiveBigInteger(String str) {
        try {
            BigInteger num = new BigInteger(str);
            if (num.compareTo(BigInteger.ZERO) < 0) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR + "Negative numbers are not allowed");
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