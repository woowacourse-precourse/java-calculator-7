package calculator;

import calculator.config.Configuration;
import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final Configuration configuration = new Configuration();
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();
        CalculatorController calculatorController = configuration.getCalculatorController();
        calculatorController.input(s);
    }
}
