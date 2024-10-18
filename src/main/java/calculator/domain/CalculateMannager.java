package calculator.domain;

import calculator.domain.letter.Separators;
import calculator.domain.number.Numbers;
import calculator.ui.InputView;
import calculator.ui.OutputView;

public class CalculateMannager {
    InputView inputView;
    OutputView outputView;
    Separators separators;
    Numbers numbers;

    public CalculateMannager() {
        inputView = new InputView();
        outputView = new OutputView();
        separators = new Separators();
        numbers = new Numbers();
    }

    public void start() {
        outputView.printReadLettersMessage();
    }

}