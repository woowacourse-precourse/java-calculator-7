package calculator.controller;

import java.util.List;

public class StringCalculator {
    private List<Integer> numbers;
    private int result = 0;

    public void run(String input) {
        InputProcessor processor = new InputProcessor(input);

        processor.processInput();
        numbers = processor.getNumbers();
        addNumbers();
    }

    private void addNumbers() {
        for (int number : numbers) {
            result += number;
        }
    }
}
