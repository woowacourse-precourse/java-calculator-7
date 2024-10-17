package calculator.service;

import java.util.Objects;

class Number {

    private final String number;

    public Number(final String number) {
        this.number = parse(number);
    }

    private static String parse(final String number) {
        if (number.isBlank()) {
            return "0";
        }
        if (number.startsWith("-")) {
            throw new IllegalArgumentException("입력으로 음수는 들어올 수 없습니다.");
        }
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException("등록되지 않은 구분자 존재" + number);
            }
        }
        return number;
    }

    public Number add(final Number number) {
        return new Number(addLargeNumbers(number.number, this.number));
    }

    public String addLargeNumbers(String num1, String num2) {
        final int maxLength = Math.max(num1.length(), num2.length());
        num1 = padWithZeros(num1, maxLength);
        num2 = padWithZeros(num2, maxLength);

        final StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            final int digit1 = num1.charAt(i) - '0';
            final int digit2 = num2.charAt(i) - '0';

            final int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            result.append(sum % 10);
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    private String padWithZeros(final String str, int length) {
        final StringBuilder padded = new StringBuilder(str);
        while (padded.length() < length) {
            padded.insert(0, '0');
        }
        return padded.toString();
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
