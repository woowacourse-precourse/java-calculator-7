package calculator.domain.number;

import java.math.BigInteger;
import java.util.Objects;

public class PositiveNumber {

    private static final int MAX_LENGTH_THRESHOLD = 15;
    private static final String DEFAULT_NUMBER = "0";
    private static final String MINUS = "-";
    private static final PositiveNumber DEFAULT_POSITIVE_NUMBER = new PositiveNumber();

    private final BigInteger value;

    private PositiveNumber() {
        this.value = BigInteger.ZERO;
    }

    private PositiveNumber(final String number) {
        this.value = new BigInteger(Objects.requireNonNull(number));
    }

    public static PositiveNumber zero() {
        return DEFAULT_POSITIVE_NUMBER;
    }

    public static PositiveNumber from(final String number) {
        validate(number);
        if (isDefault(number)) {
            return DEFAULT_POSITIVE_NUMBER;
        }
        return new PositiveNumber(number);
    }

    private static void validate(final String number) {
        validateNegative(number);
        validateOnlyDigits(number);
        validateLength(number);
    }

    private static void validateNegative(final String number) {
        if (number.startsWith(MINUS)) {
            throw new IllegalArgumentException("0(or 빈 문자)을 포함한 양수를 +없이 입력해 주세요.");
        }
    }

    private static void validateOnlyDigits(final String number) {
        if (!hasOnlyDigits(number)) {
            throw new IllegalArgumentException("구분자를 제외한 입력은 숫자만 입력해 주세요.");
        }
    }

    /**
     * Empty Stream 공진리(vacuous truth) 원리: 빈 스트림의 {@code allMatch()}는 {@code true} 반환
     *
     * @return {@code true} 빈 문자열이거나 모두 숫자인 경우, {@code false} 문자열에 숫자가 아닌 문자가 포함된 경우
     */
    private static boolean hasOnlyDigits(final String number) {
        return number.chars()
                .allMatch(Character::isDigit);
    }

    private static void validateLength(final String number) {
        if (isOutOfRange(number.length())) {
            throw new IllegalArgumentException(MAX_LENGTH_THRESHOLD + "자리를 초과한 양수는 계산할 수 없습니다.");
        }
    }

    private static boolean isDefault(final String number) {
        return DEFAULT_NUMBER.equals(number) || number.isEmpty();
    }

    private static boolean isOutOfRange(final int numberDigit) {
        return MAX_LENGTH_THRESHOLD < numberDigit;
    }

    public PositiveNumber add(final PositiveNumber otherOperand) {
        String total = value.add(otherOperand.value)
                .toString();
        return from(total);
    }

    public BigInteger value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PositiveNumber that)) {
            return false;
        }
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "PositiveNumber{" +
                "value=" + value +
                '}';
    }

}
