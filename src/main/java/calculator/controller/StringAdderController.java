package calculator.controller;

import calculator.service.AdderService;
import calculator.validation.NumberValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class StringAdderController {

    public void run() {
        String additionInput = InputView.getAdditionInput();
        String delimiters = InputView.getDefaultDelimiters();
        if (InputView.containsCustomDelimiter(additionInput)) {
            delimiters = InputView.getCustomDelimiter(additionInput);
            additionInput = InputView.deleteCustomDelimiter(additionInput);
        }

        List<String> tokens = InputView.separateStringToList(additionInput, delimiters);
        NumberValidator.validateContainsOnlyPositiveDigits(tokens);

        List<Integer> operands = InputView.getOperands(tokens);

        int sum = AdderService.sumAll(operands);
        OutputView.printSumResult(sum);
    }
}
