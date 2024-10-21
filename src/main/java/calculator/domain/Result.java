package calculator.domain;

public class Result {
    private final int value;

    public Result(NumericSequence sequence) {
        this.value = sequence.getTotalSum();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
