package calculator.domain;

public class Calculator {
    private long sum;

    public Calculator() {
        this.sum = 0L;
    }

    public void add(long num) {
        this.sum += num;
    }

    public String getResult() {
        String result = Long.toString(this.sum);
        this.sum = 0;
        return result;
    }
}
