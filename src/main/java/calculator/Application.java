package calculator;

import calculator.extractor.UserInputConverter;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.number.Numbers;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String userInput = new InputHandler().getUserInput();

        UserInputConverter userInputConverter = new UserInputConverter();
        List<String> split = userInputConverter.split(userInput);

        Numbers numbers = Numbers.of(split);

        int totalValue = numbers.calculateTotalValue();

        new OutputHandler().showCalculateResult(totalValue);
    }
}
