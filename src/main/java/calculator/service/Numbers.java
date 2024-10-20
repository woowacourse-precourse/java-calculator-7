package calculator.service;

import java.util.List;
import java.util.Objects;

class Numbers {

    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    public String getSum() {
        Number number = new Number("0");
        for (final Number tempNumber : numbers) {
            number = number.add(tempNumber);
        }
        return number.getNumber();
    }
}
