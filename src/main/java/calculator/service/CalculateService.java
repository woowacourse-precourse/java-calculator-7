package calculator.service;

public class CalculateService {

    private String[] numbers; // 숫자들의 배열
    private long sum = 0L;

    public CalculateService(String[] numbers) {
        this.numbers = numbers;
    }

    // 기능 4-3 : 숫자들의 합이 Long 타입의 범위를 넘어서는 경우를 확인한다.
    public void calculate() {
        for (String number : numbers) {
            long value = Long.parseLong(number);
            if (value > Long.MAX_VALUE - sum)
                throw new IllegalArgumentException("숫자들의 합이 제한 범위를 넘었습니다. 잘못된 입력입니다.");
            sum += value;
        }
    }

    public long getSum() {
        return sum;
    }
}
