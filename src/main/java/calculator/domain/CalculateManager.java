package calculator.domain;

import calculator.ui.InputView;
import calculator.ui.OutputView;

public class CalculateManager {
    InputView inputView;
    OutputView outputView;
    LetterManager letterManager;
    Calculator calculator;

    public CalculateManager() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        printReadLettersMessage();
        String letters = readLetters();
        initializeLetterManager(letters);
        initializeCalculator();
        printResult();
    }

    private void printResult() {
        outputView.printResult(calculator.getSum());
    }

    private void initializeCalculator() {
        calculator = new Calculator(letterManager.getNumbers());
    }

    private void initializeLetterManager(String letters) {
        letterManager = new LetterManager(letters);
    }

    private String readLetters() {
        return inputView.readLetters();
    }

    private void printReadLettersMessage() {
        outputView.printReadLettersMessage();
    }


}