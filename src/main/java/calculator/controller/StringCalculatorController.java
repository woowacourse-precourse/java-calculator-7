package calculator.controller;

import calculator.model.Calculator;
import calculator.model.NumberFilter;
import calculator.model.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class StringCalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final NumberFilter numberFilter;
    private final Separator separator;

    public StringCalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
        this.numberFilter = new NumberFilter();
        this.separator = new Separator();
    }

    public void run() {
        inputView.RequestInputString();
        List<Long> numbers = getFilteredNumbers(inputView.inputString());
        outputView.printResult(getResultNumber(numbers));
    }

    private List<Long> getFilteredNumbers(String inputString) {
        String sep = separator.getSeparator(inputString);
        return numberFilter.filter(inputString, sep);
    }

    private Long getResultNumber(List<Long> numbers) {
        return calculator.calculate(numbers);
    }


}
