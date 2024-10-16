package calculator.controller;

import calculator.model.Calculator;
import calculator.service.StringArrToIntegerArr;
import calculator.service.StringParsing;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }
    public void calculateRun() {
        outputView.printInputPromptMessage();
        String input = InputView.userInputStr();
        String[] inputs = StringParsing.userInputStrToArr(input);
        int[] numbers = StringArrToIntegerArr.toNumbers(inputs);
        int result = Calculator.sum(numbers);
        outputView.printResult(result);
    }

}
