package calculator.calculator;

import calculator.calculator.operator.Operation;
import calculator.parsing.StringNumberParser;
import calculator.parsing.UserInputParser;

public class StringCalculator {

    private final StringNumberParser stringNumberParser;
    private final UserInputParser userInputParser;
    private final Operation operation;

    public StringCalculator(StringNumberParser stringNumberParser, UserInputParser userInputParser, Operation operation) {
        this.stringNumberParser = stringNumberParser;
        this.userInputParser = userInputParser;
        this.operation = operation;
    }

    public long add(String input) {
        if (input == null || input.isEmpty()) {
            return 0L;
        }

        String[] parts = userInputParser.parseInput(input);
        return sumNumbers(parts);
    }

    private long sumNumbers(String[] numbers) {
        long sum = 0L;  // long 타입으로 초기화
        for (String number : numbers) {
            long parsedNumber = stringNumberParser.parseNumber(number);
            sum = calculateOrThrow(sum, parsedNumber); // long 타입의 덧셈 사용
        }
        return sum;
    }

    private long calculateOrThrow(long sum, long number) {
        try {
            return operation.operate(sum, number);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("덧셈 중 오버플로우가 발생했습니다.", e);
        }
    }

}
