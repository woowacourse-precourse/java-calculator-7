package calculator.controller;

import calculator.domain.Numbers;
import calculator.domain.Separator;
import calculator.util.NumberConvertor;
import calculator.validator.SeparatorValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String str = inputView.inputStringToAdd();

        if (SeparatorValidator.hasCustomSeparator(str)) {
            Separator.addCustomSeparator(str);
        }

        Numbers numbers = new Numbers(NumberConvertor.stringToInt(str));
        outputView.printResult(numbers.sum());
    }
}
