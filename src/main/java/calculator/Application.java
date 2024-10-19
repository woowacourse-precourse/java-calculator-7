package calculator;

import calculator.controller.CalculatorController;
import calculator.util.refine.DelimiterExtractor;
import calculator.util.refine.SeparatePositiveNumber;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        SeparatePositiveNumber separatePositiveNumber = new SeparatePositiveNumber(delimiterExtractor);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController calculatorController = new CalculatorController(separatePositiveNumber, inputView, outputView);
        calculatorController.startCalculate();
    }
}
