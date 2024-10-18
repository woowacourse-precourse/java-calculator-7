package calculator.controller;

import calculator.service.AdderService;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class StringAdderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final AdderService adderService;

    public StringAdderController() {
        this.inputView = new InputView();
        this.adderService = new AdderService();
        this.outputView = new OutputView();
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
        outputView.printSumResult(sum);
    }
}
