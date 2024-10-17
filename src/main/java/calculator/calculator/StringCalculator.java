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
        try {
            for (String number : numbers) {
                long num = stringNumberParser.parseNumber(number);
                sum = operation.operate(num, sum); // long 타입의 덧셈 사용
            }
        } catch (ArithmeticException e) { // 오버플로우 예외 처리
            throw new IllegalArgumentException("덧셈 중 오버플로우가 발생했습니다.", e);
        }
        return sum;
    }

}
