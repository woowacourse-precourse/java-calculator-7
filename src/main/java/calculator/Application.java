package calculator;

import calculator.service.CalculatorService;
import calculator.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        String input = view.requestInput();
        CalculatorService service = new CalculatorService(input);
        double result = service.calculate();
    }
}
