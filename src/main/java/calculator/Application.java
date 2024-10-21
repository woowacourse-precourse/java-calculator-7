package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.input();

        CalculatorController calculatorController = CalculatorController.getInstance();
        Long answer = calculatorController.calculate(input);

        OutputView outputView = new OutputView(answer);
        outputView.print();
    }
}
