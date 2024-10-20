package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class StringAddCalculator {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculate(input);
        System.out.println("결과 : " + result);
    }

    private int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        InputParser parser = InputParser.from(input);
        return Stream.of(parser.split())
                .peek(this::validateNumber)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private void validateNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다: " + number);
        }
    }
}
