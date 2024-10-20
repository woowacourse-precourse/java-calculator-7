package calculator.controller;

import calculator.domain.Calculator;
import calculator.utils.Utils;
import calculator.validators.Validators;
import calculator.view.InputView;
import calculator.view.OutPutView;

public class Controller {
    private final InputView inputView;
    private final OutPutView outputView;
    private final Calculator calculator;
    private final Validators validators;
    private final Utils utils;

    public Controller(InputView inputView, OutPutView outputView, Calculator calculator, Validators validators,
                      Utils utils) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
        this.validators = validators;
        this.utils = utils;
    }

    public void startWithDelimiterInitialization() {
        calculator.init();
    }

    public int processUserInputAndCalculate() {
        String s = inputView.startCalculatorWithInput();
        if (validators.validateDelimiterDeclaration(s)) {
            utils.addCustomDelimiters(calculator, s);
            s = utils.extractCalculationString(s);
        }

        validators.validateAllowedCharacters(calculator.delimiters, s);

        validators.validateDelimiterSurroundings(calculator, s);

        int[] lists = utils.convertStringToIntList(s, calculator);

        return utils.sumIntList(lists);
    }
}
