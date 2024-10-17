package calculator.calculate;

import calculator.io.InputSystem;
import calculator.io.OutputSystem;
import java.util.List;

public class CalculateSystem {

    private final InputSystem inputSystem;
    private final OutputSystem outputSystem;
    private final ValidationProcessor validationProcessor;
    private final Calculator calculator;

    public CalculateSystem() {
        this.inputSystem = new InputSystem();
        this.outputSystem = new OutputSystem();
        this.validationProcessor = new ValidationProcessor();
        this.calculator = new Calculator();
    }

    public void process() {
        String input = inputSystem.input();
        List<Integer> positiveNumbers = validationProcessor.extractNumbers(input);
        int result = calculator.multipleSum(positiveNumbers);
        outputSystem.outputMessage(result);
    }
}
