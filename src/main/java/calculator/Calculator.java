package calculator;

import calculator.view.InputView;

public class Calculator {
    private final InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {

        String inputNumbers = inputView.numbersInputView();

        if (isExistsCustomSeparator(inputNumbers)) {
            String customSeparatorArea = getCustomSeparatorArea(inputNumbers);
            System.out.println(customSeparatorArea);
        }

        String numbersArea = getNumbersArea(inputNumbers);
        System.out.println(numbersArea);

    }

    public String getCustomSeparatorArea(String input) {
        String[] splitNumbers = input.split("\\\\n");
        return splitNumbers[0];
    }

    public String getNumbersArea(String input) {
        if (isExistsCustomSeparator(input)) {
            String[] splitNumbers = input.split("\\\\n");
            return splitNumbers[1];
        }
        return input;
    }

    public boolean isExistsCustomSeparator(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }
}
