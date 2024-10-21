package calculator;

public class Calculator {
    private final Input input;
    private final InputValidation validator;
    private final CustomDelimiter delimiter;
    private final Adder adder;
    private final Output output;

    public Calculator() {
        this.adder = new Adder();
        this.input = new Input();
        this.validator = new InputValidation();
        this.delimiter = new CustomDelimiter();
        this.output = new Output();
    }

    public void run() {
        String inputString = input.input();
        String[] numbers = delimiter.extractNumbers(inputString);
        int sum = adder.calculateSum(numbers);
        output.displayResult(sum);
    }

    private void validateInput(String input) {
        validator.validate(input);
    }
}
