package calculator.separator;

import java.math.BigInteger;

public class NumericString {

    public static final NumericString ZERO = new NumericString(BigInteger.ZERO);

    private final BigInteger number;

    private NumericString(BigInteger number) {
        this.number = number;
    }

    public static NumericString of(String str, int min) {
        validateIsBlank(str);

        BigInteger number;
        try {
            number = new BigInteger(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(str + "은 숫자 형식으로 변환할 수 없는 값입니다.");
        }

        validateMinNumber(number, min);

        return new NumericString(number);
    }

    public static NumericString positive(String str) {
        return NumericString.of(str, 1);
    }

    private static void validateIsBlank(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException("빈 문자열 값입니다.");
        }
    }

    private static void validateMinNumber(BigInteger number, int min) {
        if (number.compareTo(BigInteger.valueOf(min)) < 0) {
            throw new IllegalArgumentException("숫자는 " + min + "보다 크거나 같아야 합니다.");
        }
    }

    public NumericString add(NumericString other) {
        return new NumericString(number.add(other.number));
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
