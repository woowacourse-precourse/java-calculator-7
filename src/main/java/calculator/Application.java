package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Calculator calculator;

        if (hasCustomSeparator(input)) {
            char customSeparator = input.charAt(2);
            String expression = input.substring(5);
            calculator = new Calculator(expression, customSeparator);
        } else {
            calculator = new Calculator(input);
        }

        int sum = calculator.calculate();
        System.out.println("결과 : " + sum);
    }

    private static boolean hasCustomSeparator(String exp) {
        return exp.length() >= 5
                && exp.startsWith("//")
                && exp.indexOf("\\n") == 3
                && !isNumeric(exp.charAt(2));
    }

    private static boolean isNumeric(char c) {
        try {
            Double.parseDouble(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
