package calculator;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        List<String> validNumber = calculatorService.findValidNumber("1,2:3");

        for (String s : validNumber) {
            System.out.println(s);
        }

    }
}
