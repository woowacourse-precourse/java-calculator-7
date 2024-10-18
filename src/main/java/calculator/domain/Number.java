package calculator.domain;

public class Number {

    private Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public Number() {
        this.value = 0;
    }

    public void addNumber(final Number number) {
        this.value += number.value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
