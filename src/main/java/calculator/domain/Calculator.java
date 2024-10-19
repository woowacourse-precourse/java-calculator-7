package calculator.domain;

public class Calculator {
    private long sum;

    public Calculator() {
        this.sum = 0L;
    }

    public void add(long num) {
        validateNum(num);
        this.sum += num;
    }

    private void validateNum(long num) {
        if (num < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    public String getResult() {
        String result = Long.toString(this.sum);
        this.sum = 0;
        return result;
    }
}
