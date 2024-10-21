package calculator;

public class StringCalculator {
    public static int calculate(String input) {
        // 1. 빈 문자열 또는 null 입력 처리
        // InputValidator의 역할은 검증이다. 입력값에 대한 검증만 한다.
        // StringCalculator의 역할은 계산이다. 따라서 빈 입력값이 들어오면 0으로 계산하는 로직은 이곳에 구현한다.
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 2. InputValidator로 검증
        InputValidator.validate(input);

        // 3. DelimeterParser로 문자열을 구분한 배열 생성 -> 추후 구현 예정
        String[] numbers = DelimiterParser.split(input);

        return sum(numbers);
    }

    // numbers 배열의 숫자 합을 계산하는 메서드
    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
        return total;
    }
}
