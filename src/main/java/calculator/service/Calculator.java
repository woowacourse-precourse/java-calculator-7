package calculator.service;

import calculator.utils.CalculatorRegex;
import calculator.validator.CalculatorValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static Calculator calculator;
    private final CalculatorValidator calculatorValidator;

    private Calculator() {
        this.calculatorValidator = new CalculatorValidator();
    }

    public static Calculator getCalculator() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public void calculate() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = getExpression();
        calculatorValidator.validateExpression(expression);
        String[] numList = parseNumbersFromExpression(expression);
        System.out.println("결과 : " + getResult(numList));
    }

    private int getResult(String[] list) {

        int result = 0;
        for (String num : list) {
            calculatorValidator.validatePositiveNumber(num);
            int number = Integer.parseInt(num);
            result += number;
        }
        return result;
    }

    private String[] parseNumbersFromExpression(String expression) {

        Matcher matcher = Pattern.compile(CalculatorRegex.CUSTOM_SEPERATOR_REGEX).matcher(expression);
        if (matcher.find()) {
            String customSeperator = matcher.group(1);
            String numberExpression = matcher.group(2);
            return numberExpression.split(customSeperator);
        }
        return expression.split(CalculatorRegex.DEFAULT_SEPERATOR_REGEX);
    }

    private String getExpression() {

        // 사용자 입력 후 자원 해제 및 반환
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
