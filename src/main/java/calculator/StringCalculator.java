package calculator;

import calculator.ex.Output;

public class StringCalculator {
    private final Validator validator;
    private final InputParser parser;
    //    private final NumberExtractor extractor;
    private final Calculator calculator;
    private String inputValue;

    public StringCalculator() {
        parser = new InputParser();
        validator = new Validator();
        calculator = new Calculator();
    }

    public void run() {
        inputValue = Input.readInput();
        if (inputValue.isEmpty()) {
            Output.printResult(0);
            return;
        }
        String cleanedInput = parser.parseCustomDelimiter(inputValue);

        // TODO 파싱을 먼저 하고 유효성 검사?
        validator.validateInput(cleanedInput);

        int[] numbers = parser.parseInteger(cleanedInput);

        int result = calculator.addNumbers(numbers);
        Output.printResult(result);
    }
}
