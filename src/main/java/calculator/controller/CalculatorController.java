package calculator.controller;

import calculator.domain.Calculator;
import calculator.validator.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;

public class CalculatorController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();
    Calculator calculator = new Calculator();



    public void run() {
        String input = inputView.readSentence();
        ArrayList<String> separators = calculator.getSeparators();

        validator.validateInput(input, separators);

        int sum = calculator.sumNumber(input, separators);
        outputView.printResult(sum);
    }
}
