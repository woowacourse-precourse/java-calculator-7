package calculator;

import calculator.model.Calculator;
import calculator.model.Expression;
import calculator.view.CalculateView;

// controller
class CalculatorController {
    private final Calculator model;
    private final CalculateView view;

    public CalculatorController(Calculator model, CalculateView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        String expression = view.getUserInput();

        // 데이터 처리
        Expression expressionModel = new Expression(expression);
        int result = model.calculate(expressionModel);

        // 출력
        view.displayResult(result);
    }
}

public class Application {
    public static void main(String[] args) {
        Calculator model = new Calculator();
        CalculateView view = new CalculateView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}

