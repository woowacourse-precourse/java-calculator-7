package calculator;

public class StringCalculator {
    public int calculate(String[] numbers) {

        int sum = 0;

        for (String stringNum : numbers) {
            int number = Integer.parseInt(stringNum);
            if (number < 0) {
                throw new IllegalArgumentException("계산할 값에 음수가 포함 되어있습니다.");
            }
            sum += number;
        }
        return sum;
    }
}
