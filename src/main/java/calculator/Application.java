package calculator;

import calculator.service.CalculatorService;
import calculator.service.Service;
import calculator.view.View;

public class Application {
    public static void main(String[] args) {
        Service service = new CalculatorService(View.input());
        service.run();
    }
}