package calculator.entity;

import java.util.List;
import java.util.Objects;

public class Num {

    private final int number;

    public Num(String numString) {
        if (numString.isEmpty()) {
            this.number = 0;
            return;
        }

        if (!numString.matches("\\d+")) {
            throw new IllegalArgumentException("must be a number");
        }

        this.number = Integer.parseInt(numString);
    }

    public Num(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("number must be positive");
        }
        this.number = number;
    }


    public static int total(List<Num> numList) {
        int sum = 0;

        for (Num num : numList) {
            sum += num.number;
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Num num = (Num) o;
        return number == num.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
