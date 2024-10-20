package calculator;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void printResult(Integer result) {
        System.out.println("결과 : " + result);
    }

    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        try {
            String command = input();
            Integer result = calculatorService.calculate(command);
            printResult(result);
        } finally {
            Console.close();
        }
    }
}
