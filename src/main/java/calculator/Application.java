package calculator;

import calculator.service.CalculatorService;
import calculator.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        CalculatorService service = new CalculatorService();
        String input = view.requestInput();
        double result = service.calculate(input);
        view.printResult(result);
    }
}
