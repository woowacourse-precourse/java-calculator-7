package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.DigitParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
                new Calculator(),
                new DigitParser()
        );

        InputView inputView = new InputView();
        String input = inputView.inputString();

        Integer sum = calculatorController.sumFromString(input);

        OutputView outputView = new OutputView();
        outputView.printResult(sum.toString());
    }
}
