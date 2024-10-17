package calculator.controller;

import calculator.domain.Numbers;
import calculator.domain.Separator;
import calculator.util.NumberConvertor;
import calculator.validator.SeparatorValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public static void run() {
        String str = InputView.inputStringToAdd();

        if (SeparatorValidator.hasCustomSeparator(str)) {
            Separator.addCustomSeparator(str);
        }

        Numbers numbers = new Numbers(NumberConvertor.stringToInt(str));
        OutputView.printResult(numbers.sum());
    }
}
