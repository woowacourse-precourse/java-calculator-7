package calculator;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        Console.close();
        CalculatorService calculatorService = new CalculatorServiceImpl();
        Integer result = calculatorService.calculate(input);
        System.out.println("결과 : " + result);

    }
}
