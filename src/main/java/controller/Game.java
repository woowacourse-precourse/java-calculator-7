package controller;

import camp.nextstep.edu.missionutils.Console;
import view.InputView;
import view.OutputView;

public class Game {

    private String getInputValue() {
        OutputView.printGuide();
        return InputView.inputValue();
    }

    public void start() {
        String inputValue = getInputValue();
        System.out.println(inputValue);
    }

    public void end() {
        Console.close();
    }
}
