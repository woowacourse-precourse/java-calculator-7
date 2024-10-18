package calculator.controller;

import calculator.service.AdderService;
import calculator.view.InputView;

import java.util.List;

public class StringAdderController {
    private final InputView inputView;
    private final AdderService adderService;

    public StringAdderController() {
        this.inputView = new InputView();
        this.adderService = new AdderService();
    }

    public void run() {
        String additionInput = inputView.getAdditionInput();
        String delimiters = inputView.getDefaultDelimiters();
        if(inputView.containsCustomDelimiter(additionInput)) {
            delimiters = inputView.getCustomDelimiter(additionInput);
            additionInput = inputView.deleteCustomDelimiter(additionInput);
        }

        List<Integer> operands = inputView.getOperands(additionInput, delimiters);
        int sum = adderService.sumAll(operands);

    }
}
