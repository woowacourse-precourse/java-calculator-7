package calculator.domain;

public class Calculator {
    private long sum;

    public Calculator() {
        this.sum = 0L;
    }

    public void add(String num) {
        validateIsLong(num);

        long n = Long.parseLong(num);

        validateSum(n);

        validateNum(n);
        this.sum += n;
    }

    private void validateSum(long num) {
        if (num > Long.MAX_VALUE - sum) {
            throw new NumberFormatException();
        }
    }

    private void validateNum(long num) {
        if (num <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

    private void validateIsLong(String num) {
        try {
            Long.parseLong(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public String getResult() {
        String result = Long.toString(this.sum);
        this.sum = 0;
        return result;
    }
}
