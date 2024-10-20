package calculator.controller;

import calculator.domain.Calculator;
import calculator.utils.Utils;
import calculator.validators.Validators;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final Validators validators;
    private final Utils utils;

    public Controller(InputView inputView, OutputView outputView, Calculator calculator, Validators validators,
                      Utils utils) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
        this.validators = validators;
        this.utils = utils;
    }

    public void calculate() {
        startWithDelimiterInitialization();
        int result = processUserInputAndCalculate();
        displayCalculationResult(result);
    }

    public void startWithDelimiterInitialization() {
        calculator.init();
    }

    public int processUserInputAndCalculate() {
        String inputString = inputView.startCalculatorWithInput();
        if (validators.validateDelimiterDeclaration(inputString)) {
            utils.addCustomDelimiters(calculator, inputString);
            inputString = utils.extractCalculationString(inputString);
        }

        validators.validateAllowedCharacters(calculator.delimiters, inputString);

        validators.validateDelimiterSurroundings(calculator, inputString);

        int[] numbers = utils.convertStringToIntList(calculator, inputString);

        return utils.sumIntList(numbers);
    }

    public void displayCalculationResult(int result) {
        outputView.printCalculatorResult(result);
        outputView.printCalculatorEndMessage();
    }
}
