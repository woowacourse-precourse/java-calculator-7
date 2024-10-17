package calculator;

import calculator.calc.Calculator;
import calculator.factory.CalculatorFactory;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorFactory().calculator();
        String input = getInput();

        long result = calculator.sumOfString(input);
        System.out.println("결과 : " + result);

        Console.close();
    }

    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        System.out.println("input = " + input);
        return input;
    }
}
