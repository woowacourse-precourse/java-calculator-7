package calculator;

import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void operateCalculator() {
        InputView inputView = new InputView();
        InputReciver inputReciver = new InputReciver();
        InputValidator inputValidator = new InputValidator(inputReciver.getInput());
        FormulaGenerator formulaGenerator = new FormulaGenerator(inputReciver.getInput());
        Calculator calculator = new Calculator(formulaGenerator.getFormula());
        OutputView outputView = new OutputView(calculator.getResult());
    }

}
