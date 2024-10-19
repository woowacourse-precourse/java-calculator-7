package calculator.domain;

import calculator.ui.InputView;
import calculator.ui.OutputView;

public class CalculateMannager {
    InputView inputView;
    OutputView outputView;
    LetterMannager letterMannager;
    Calculator calculator;

    public CalculateMannager() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        printReadLettersMessage();
        String letters = readLetters();
        initializeLetterMannager(letters);
        initializeCalculator();
        printResult();
    }

    private void printResult() {
        outputView.printResult(calculator.getSum());
    }

    private void initializeCalculator() {
        calculator = new Calculator(letterMannager.getNumbers());
    }

    private void initializeLetterMannager(String letters) {
        letterMannager = new LetterMannager(letters);
    }

    private String readLetters() {
        return inputView.readLetters();
    }

    private void printReadLettersMessage() {
        outputView.printReadLettersMessage();
    }


}