package calculator;

public class StringCalculator {
    public int calculate(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("입력 값이 null 일 수 없습니다");
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
