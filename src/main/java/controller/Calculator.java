package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Numbers;
import domain.Separators;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Calculator {

    private String getInputValue() {
        OutputView.printGuide();
        return InputView.inputValue();
    }

    public void start() {
        String inputValue = getInputValue();
        String separators = new Separators(inputValue).getSeparators();
        List<Integer> numbers = new Numbers(inputValue, separators).getNumbers();
        int result = sum(numbers);
    }

    private int sum(final List<Integer> numbers) {
        int result = 0;
        for(Integer number : numbers) {
            result += number;
        }

        return result;
    }

    public void end() {
        Console.close();
    }
}
