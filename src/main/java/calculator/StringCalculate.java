package calculator;

public class StringCalculate {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;  // 빈 문자열일 경우 0 반환
        }

        String[] numbers = input.split(",|:");  // (최초 설정)구분자로 숫자 분리

        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number.trim());

            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
            }
            total += parsedNumber;
        }
        return total;
    }
}
