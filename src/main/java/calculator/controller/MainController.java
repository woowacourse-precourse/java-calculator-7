package calculator.controller;

import calculator.Calculator;
import calculator.Filter;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class MainController {
    private final InputView inputView;
    private final Filter filter;
    private final Calculator calculator;
    private final OutputView outputView;

    public MainController() {
        this.inputView = new InputView();
        this.filter = new Filter();
        this.calculator = new Calculator();
        this.outputView = new OutputView();
    }

    public void run() {
            inputView.printInputView();
            String inputString = inputView.getInput();

            List<Integer> integers = filter.doFilter(inputString);

            String output = calculator.calculate(integers);

            outputView.printOutputView(output);
        }
}
