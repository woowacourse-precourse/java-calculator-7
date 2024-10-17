package calculator.service;

import java.util.Objects;

class Number {

    private final String number;

    public Number(final String number) {
        this.number = parse(number);
    }

    private static String parse(final String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException("등록되지 않은 구분자 존재" + number);
            }
        }
        return number;
    }

    @Override
    public String toString() {
        return "number='" + number + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }
}
