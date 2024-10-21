package calculator;

import calculator.model.Calculator;
import calculator.model.Expression;
import camp.nextstep.edu.missionutils.Console;

// view
class CalculateView {
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void displayResult(int cnt) {
        System.out.println("결과 : " + cnt);
    }
}

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

