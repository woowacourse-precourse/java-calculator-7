package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 의존성 주입
        CalculatorService calculatorService = new CalculatorService();
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorService, calculatorView);

        // 프로그램 실행
        calculatorController.run();
    }
}
