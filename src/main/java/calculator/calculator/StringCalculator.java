package calculator.calculator;

import calculator.calculator.model.InputString;
import calculator.calculator.model.Numbers;
import calculator.calculator.model.PositiveNumber;
import calculator.calculator.operator.Operation;
import calculator.parsing.UserInputParser;

public class StringCalculator {

    private final UserInputParser userInputParser;
    private final Operation operation;

    public StringCalculator(UserInputParser userInputParser, Operation operation) {
        this.userInputParser = userInputParser;
        this.operation = operation;
    }

    public PositiveNumber add(InputString inputString) {
        Numbers numbers = userInputParser.parseInput(inputString);
        PositiveNumber sum = new PositiveNumber(0);
        for (PositiveNumber number : numbers.numbers()) {
            sum = calculateOrThrow(sum, number);
        }
        return sum;
    }

    private PositiveNumber calculateOrThrow(PositiveNumber sum, PositiveNumber number) {
        try {
            long result = operation.operate(sum.value(), number.value());
            return new PositiveNumber(result);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("덧셈 중 오버플로우가 발생했습니다.", e);
        }
    }

}
