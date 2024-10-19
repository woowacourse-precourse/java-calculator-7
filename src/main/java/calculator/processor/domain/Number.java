package calculator.processor.domain;

public class Number {

    public static final Number ZERO = new Number(0);

    private final Integer number;

    public Number(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public Number plus(Number other) {
        return new Number(this.number + other.number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Number)) {
            return false;
        }
        Number other = (Number) obj;
        return this.number.equals(other.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
