package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.utils.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Parser parser = new Parser();
        Calculator calculator = new Calculator();
        OutputView outputView = new OutputView();
        CalculatorController calculatorController = new CalculatorController(inputView, calculator, parser, outputView);
        calculatorController.run();
    }
}
