package calculator.controller;

import calculator.view.InputView;

public class StringAdderController {
    private final InputView inputView;

    public StringAdderController() {
        this.inputView = new InputView();
    }

    public void run() {
        String additionInput = inputView.getAdditionInput();
        String delimiters;
        if(!inputView.containsCustomDelimiter(additionInput)) {
            delimiters = inputView.getDefaultDelimiters();
        }
        if(inputView.containsCustomDelimiter(additionInput)) {
            delimiters = inputView.getCustomDelimiter(additionInput);
            additionInput = inputView.deleteCustomDelimiter(additionInput);
        }

    }
}
