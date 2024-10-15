package calculator;

import calculator.extractor.NumberExtractor;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.number.Numbers;

public class Application {

    public static void main(String[] args) {
        String userInput = new InputHandler().getUserInput();

        NumberExtractor numberExtractor = new NumberExtractor();
        Numbers numbers = numberExtractor.extract(userInput);

        int totalValue = numbers.calculateTotalValue();

        new OutputHandler().showCalculateResult(totalValue);
    }
}
