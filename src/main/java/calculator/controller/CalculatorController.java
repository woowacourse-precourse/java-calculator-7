package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.Number;
import calculator.model.Numbers;
import calculator.model.OriginalInput;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    public void executeCalculator() {
        InputView.printInsertMessage();
        String userInput = InputView.getUserInput();

        OriginalInput originalInput = new OriginalInput(userInput);
        Delimiter delimiter = new Delimiter(originalInput.separateDelimiter());

        List<String> originalNumbers = originalInput.separateNumbers(delimiter);
        List<Number> numberSet = originalNumbers.stream()
                .map(Number::new)
                .toList();

        Numbers numbers = new Numbers(numberSet);

        OutputView.printResultMessage();
        OutputView.printResult(numbers.getSum());
    }
}
