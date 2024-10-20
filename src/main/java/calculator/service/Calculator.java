package calculator.service;

import calculator.utils.CalculatorRegex;
import calculator.validator.CalculatorValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static void calculate() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = getExpression();
        CalculatorValidator.validateExpression(expression);
        String[] numList = parseNumbersFromExpression(expression);
        System.out.println("결과 : " + getResult(numList));
    }

    private static int getResult(String[] list) {

        int result = 0;
        for (String num : list) {
            int number = checkPositiveNumber(num);
            result += number;
        }
        return result;
    }

    private static int checkPositiveNumber(String number) {

        if (number.contains("-")) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        if (!number.matches(CalculatorRegex.POSITIVE_NUMBER_REGX)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
        return Integer.parseInt(number);
    }

    private static String[] parseNumbersFromExpression(String expression) {

        Matcher matcher = Pattern.compile(CalculatorRegex.CUSTOM_SEPERATOR_REGEX).matcher(expression);
        if (matcher.find()) {
            String customSeperator = matcher.group(1);
            String numberExpression = matcher.group(2);
            return numberExpression.split(customSeperator);
        }
        return expression.split(CalculatorRegex.DEFAULT_SEPERATOR_REGEX);
    }

    private static String getExpression() {

        // 사용자 입력 후 자원 해제 및 반환
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
