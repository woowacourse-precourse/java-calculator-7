package calculator;

public class Calculator {

    private final Factor fac;

    public Calculator(Factor fac) {
        this.fac = fac;
    }

    public int calculate(String input) {
        // null 또는 빈 문자열 체크
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = fac.parseNumbers(input);
        int sum = 0;

        for (String number : numbers) {
            try {
                int parsedNumber = Integer.parseInt(number.trim());
                //음수 처리 (필요한 경우)
                if (parsedNumber < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
                }
                sum += parsedNumber;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자: '" + number + "'");
            }
        }
        return sum;
    }
}
