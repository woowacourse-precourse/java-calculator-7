package calculator;

import calculator.domain.calc.Calculator;
import calculator.common.validator.ValidationUtils;
import calculator.domain.factory.CalculatorFactory;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorFactory().calculator();

        String input = getInput();
        validation(input);
        logic(calculator, input);

        Console.close();
    }

    private static void logic(Calculator calculator, String input) {
        long result = calculator.sumOfString(input);
        System.out.println("결과 : " + result);
    }

    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        System.out.println("input = " + input);
        return input;
    }

    private static void validation(String input) {
        if (ValidationUtils.isNotValid(input)) {
            throw new IllegalArgumentException();
        }
    }
}
