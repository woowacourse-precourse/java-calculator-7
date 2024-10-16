package calculator;

import calculator.service.CalculatorService;
import calculator.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        CalculatorService service = new CalculatorService();
        String input = view.requestInput();
        service.calculate(input);
    }
}
