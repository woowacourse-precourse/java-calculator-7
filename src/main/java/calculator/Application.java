package calculator;

import calculator.Controller.CalculatorController;
import calculator.Model.AdditionCalculator;
import calculator.Model.InputProcessor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculatorController = createCalculatorController();
        calculatorController.run();
    }

    // Controller를 생성하는 팩토리 메서드
    private static CalculatorController createCalculatorController() {
        InputView inputView = new InputView();
        InputProcessor inputProcessor = new InputProcessor();
        AdditionCalculator additionCalculator = new AdditionCalculator();
        OutputView outputView = new OutputView();

        return new CalculatorController(inputView, inputProcessor, additionCalculator, outputView);
    }
}

