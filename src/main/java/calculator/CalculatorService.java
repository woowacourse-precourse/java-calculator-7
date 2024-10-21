package calculator;

import calculator.input.InputProcessor;
import calculator.output.OutputProcessor;
import calculator.parser.StringParser;
import java.util.Arrays;

public class CalculatorService {
    private final InputProcessor inputProcessor;
    private final OutputProcessor outputProcessor;
    private final StringParser parser;
    private static CalculatorService instance;

    private CalculatorService() {
        inputProcessor = InputProcessor.getInstance();
        outputProcessor = OutputProcessor.getInstance();
        parser = StringParser.getInstance();
    }

    public static CalculatorService getInstance() {
        if (instance == null) {
            instance = new CalculatorService();
        }

        return instance;
    }

    public void run() {
        String inputString = inputProcessor.read();

        int[] numbers = parser.parse(inputString);
        int result = sum(numbers);

        outputProcessor.write(result);

    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
