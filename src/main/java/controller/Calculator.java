package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Numbers;
import domain.Delimiter;
import validator.InputValidator;
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
        InputValidator.checkInput(inputValue);
        String delimiters = new Delimiter(inputValue).getDelimiters();
        List<Integer> numbers = new Numbers(inputValue, delimiters).getNumbers();
        int result = sum(numbers);
        OutputView.printResult(result);
    }

    private int sum(final List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }

    public void end() {
        Console.close();
    }
}
