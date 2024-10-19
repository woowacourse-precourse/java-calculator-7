package calculator;

public class Calculator {
    private final InputParser parser;

    public Calculator(InputParser parser) {
        this.parser = parser;
    }

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열 입력 처리
        }

        int sum = 0;
        String[] numbers = parser.splitString(input); // InputParser를 이용해 문자열을 숫자 배열로 분리

        for (String number : numbers) {
            int parsedNumber;
            try {
                parsedNumber = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }

            if (parsedNumber < 1) {
                throw new IllegalArgumentException("양수만 입력할 수 있습니다: " + number); // 1 미만 값 예외 처리
            }

            sum += parsedNumber;
        }
        return sum;
    }
}
