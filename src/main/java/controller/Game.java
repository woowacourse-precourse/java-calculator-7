package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Numbers;
import domain.Separators;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Game {

    private String getInputValue() {
        OutputView.printGuide();
        return InputView.inputValue();
    }

    public void start() {
        String inputValue = getInputValue();
        String separators = new Separators(inputValue).getSeparators();
        List<Integer> numbers = new Numbers(inputValue, separators).getNumbers();
        System.out.println(numbers);
    }

    public void end() {
        Console.close();
    }
}
