package calculator;

public class StringCalculator {
    public int calculate(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("입력 값이 null 일 수 없습니다");
        }

        if (numbers.length == 0) {
            return 0;  // 빈 배열일 경우 0 반환
        }

        int sum = 0;
        for (int num : numbers) {
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다");
            }
            sum += num;
        }
        return sum;
    }
}
