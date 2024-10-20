package calculator;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        try {
            String input = Console.readLine();
            Integer result = calculatorService.calculate(input);
            System.out.println("결과 : " + result);
        } finally {
            Console.close();
        }
    }
}
