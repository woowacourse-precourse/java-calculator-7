package calculator;

import java.util.List;

public class StringCalculator {
    private final InputParser inputParser;
    private final NumberValidator numberValidator;

    public StringCalculator() {
        this.inputParser = new InputParser();
        this.numberValidator = new NumberValidator();
    }

    public int add(String input) {
        if(input.isEmpty()){
            return 0;
        }

        ParsedInput parsedInput = inputParser.parse(input);
        List<Integer> numbers = parsedInput.numbers();

        numberValidator.validate(numbers);

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
