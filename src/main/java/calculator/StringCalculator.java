package calculator;

public class StringCalculator {
    private final Validator validator;
    private final InputParser parser;
    private final Calculator calculator;
    private String inputValue;

    public StringCalculator() {
        parser = new InputParser();
        validator = new Validator();
        calculator = new Calculator();
    }

    public void run() {
        inputValue = Input.readInput();
        if (Validator.isEmptyString(inputValue)) {
            Output.printResult(0);
            return;
        }
        int[] numbers = parser.parse(inputValue, validator);
        int result = calculator.addNumbers(numbers);
        Output.printResult(result);
    }
}
