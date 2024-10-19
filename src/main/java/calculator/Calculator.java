package calculator;

public class Calculator {

    // 정수로 변환된 숫자들의 합을 반환하는 메서드
    public int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
