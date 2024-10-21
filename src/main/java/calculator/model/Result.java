package calculator.model;

public class Result {

    private long number;

    public Result(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void add(long number) {
        this.number += number;
    }
}
