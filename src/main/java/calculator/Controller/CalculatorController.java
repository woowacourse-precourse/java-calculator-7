package calculator.Controller;

import calculator.Model.Delimiter;
import calculator.Model.Number;
import calculator.Model.Numbers;
import calculator.Model.OriginalInput;
import calculator.View.InputView;
import calculator.View.OutputView;
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
