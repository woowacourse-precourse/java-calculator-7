package calculator;

public class Calculator {
    public int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += parsedNumber;
            }
        }
        return sum;
    }
}
