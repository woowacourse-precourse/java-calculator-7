package calculator;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 입력에 대한 처리
        }

        // 구분자 파싱
        String delimiter = DelimiterParser.parse(input);
        String numbers = DelimiterParser.extractNumbers(input);

        // 숫자 파싱 및 검증
        int[] parsedNumbers = NumberParser.parse(numbers, delimiter);
        Validator.validate(parsedNumbers);

        // 숫자 합산
        return sum(parsedNumbers);
    }

    // 숫자 배열의 합계를 구하는 메서드
    private static int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
