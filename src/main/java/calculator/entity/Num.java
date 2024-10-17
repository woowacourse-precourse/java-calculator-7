package calculator.entity;

import java.util.List;
import java.util.Objects;

public class Num {

    private final int number;

    /**
     * String 생성자
     *
     * @param numString 구분자에 대해 처리된 String 양수
     */

    public Num(String numString) {
        int numLen = numString.length();

        if (numLen == 0) {
            this.number = 0;
            return;
        }

        if (numLen >= 2 && numString.startsWith("0")) {
            throw new IllegalArgumentException("must be a number");
        }

        if (!numString.matches("\\d+")) {
            throw new IllegalArgumentException("must be a number");
        }

        int number = Integer.parseInt(numString);
        this.number = number;
    }

    public Num(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("number must be positive");
        }
        this.number = number;
    }

    protected static int total(List<Num> numList) {
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
