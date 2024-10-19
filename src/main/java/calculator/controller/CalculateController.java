package calculator.controller;

import calculator.model.NumberFinder;
import calculator.model.Mathematician;
import calculator.model.Calculator;
import calculator.model.DelimiterManager;
import calculator.view.InputView;
import calculator.view.OutputView;

import static calculator.view.enumerate.Phrase.RESULT_PRINT_SENTENCE;
import static calculator.view.enumerate.Phrase.START_PRINT_SENTENCE;

public class CalculateController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculateController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = new Calculator(new Mathematician(), new NumberFinder(new DelimiterManager()));
    }

    public void run() {
        outputView.print(START_PRINT_SENTENCE);
        String input = inputView.startInputValue();
        int result = calculator.sumOfNumInAlphaNum(input);
        outputView.print(RESULT_PRINT_SENTENCE,result);
    }
}
