package calculator.domain;

public class Number {
    private final Integer number;

    public Number(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number that = (Number) o;
        return this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
