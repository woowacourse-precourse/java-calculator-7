package calculator.service;

public class CalculateService {

    private String[] numbers; // 숫자들의 배열
    private long sum = 0L;

    public CalculateService(String[] numbers) {
        this.numbers = numbers;
    }

    public void calculate() {
        for (String number : numbers) {
            long value = Long.parseLong(number);
            sum += value;
        }
    }

    public long getSum() {
        return sum;
    }
}
