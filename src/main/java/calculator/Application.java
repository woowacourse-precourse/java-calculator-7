package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleView consoleView = new ConsoleView();
        Calculator calculator = new Calculator();

        String input = consoleView.getInput();
        List<Integer> numbers = calculator.splitString(input);
        Integer sum = calculator.sumNumbers(numbers);
        consoleView.displayResult(sum);
    }
}
