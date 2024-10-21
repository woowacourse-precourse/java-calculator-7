package calculator;

import calculator.domain.CalculatorService;
import calculator.infrastructure.InputParser;
import calculator.infrastructure.NumberValidator;
import calculator.infrastructure.SumCalculator;
import calculator.interfaces.conroller.CalculatorController;
import calculator.interfaces.view.InputView;
import calculator.interfaces.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        SumCalculator sumCalculator = new SumCalculator();
        NumberValidator numberValidator = new NumberValidator();

        CalculatorService calculatorService = new CalculatorService(inputParser, numberValidator,
                sumCalculator);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController calculatorController = new CalculatorController(calculatorService, inputView, outputView);

        calculatorController.startCalculator();
    }
}
