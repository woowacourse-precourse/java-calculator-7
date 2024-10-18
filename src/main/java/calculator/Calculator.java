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
            if (number.contains("-")) {
                throw new IllegalArgumentException("음수 기능은 지원하지 않습니다.");
            }
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
