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
        outputView.printReadLettersMessage();
        String letters = inputView.readLetters();
        letterMannager = new LetterMannager(letters);
        letterMannager.splitCustomSeparator();
        letterMannager.splitNumber();
        calculator = new Calculator(letterMannager.getNumbers());
        outputView.printResult(calculator.getSum());
    }


}