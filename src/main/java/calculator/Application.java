package calculator;

import calculator.domain.CalculatorService;
import calculator.infrastructure.InputParser;
import calculator.infrastructure.SplitStrValidator;
import calculator.infrastructure.SumCalculator;
import calculator.interfaces.conroller.CalculatorController;
import calculator.interfaces.view.InputView;
import calculator.interfaces.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        SumCalculator sumCalculator = new SumCalculator();
        SplitStrValidator splitStrValidator = new SplitStrValidator();

        CalculatorService calculatorService = new CalculatorService(inputParser, splitStrValidator,
                sumCalculator);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController calculatorController = new CalculatorController(calculatorService, inputView, outputView);

        calculatorController.startCalculator();
    }
}
