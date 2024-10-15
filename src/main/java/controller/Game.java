package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Separators;
import view.InputView;
import view.OutputView;

public class Game {

    private String getInputValue() {
        OutputView.printGuide();
        return InputView.inputValue();
    }

    public void start() {
        String inputValue = getInputValue();
        String separators = new Separators(inputValue).getSeparators();
        System.out.println(separators);
    }

    public void end() {
        Console.close();
    }
}
