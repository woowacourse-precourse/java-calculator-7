package calculator.object;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Numbers {

    private static final char DECIMAL_POINT = '.';

    private final List<BigDecimal> numbers;

    public Numbers(String formulaPart, Separators separators) {
        throwIfFormulaPartIsNull(formulaPart);
        throwIfSeparatorsIsNull(separators);

        if (formulaPart.isEmpty()) {
            this.numbers = List.of(BigDecimal.ZERO);
            return;
        }

        throwIfFormulaPartIsNotSeparatorOrNumber(formulaPart, separators);
        this.numbers = getNumbers(formulaPart, separators);
    }

    public String addAll() {
        BigDecimal reduce = numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        if (reduce.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
            return dropDecimalPart(reduce);
        }
        return reduce.toString();
    }

    private static void throwIfSeparatorsIsNull(Separators separators) {
        if (null == separators) {
            throw new IllegalArgumentException("구분자는 null일 수 없습니다.");
        }
    }

    private static void throwIfFormulaPartIsNull(String formulaPart) {
        if (null == formulaPart) {
            throw new IllegalArgumentException("수식부는 null일 수 없습니다.");
        }
    }

    private static void throwIfFormulaPartIsNotSeparatorOrNumber(String numberPartOfFormula, Separators separators) {
        char[] charArray = numberPartOfFormula.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (separators.contains(c) &&
                    Character.isDigit(c) &&
                    (i + 1) < charArray.length &&
                    charArray[i + 1] == DECIMAL_POINT) {
                throw new IllegalArgumentException("정수부 없는 실수를 입력할 수 없습니다.");
            }
            if (!separators.contains(c) &&
                    c == DECIMAL_POINT &&
                    (i == 0 || !Character.isDigit(charArray[i - 1]))) {
                throw new IllegalArgumentException("정수부 없는 실수를 입력할 수 없습니다.");
            }
            if (!separators.contains(c) &&
                    c == DECIMAL_POINT &&
                    ((i + 1 < charArray.length && separators.contains(charArray[i + 1]))
                            || i + 1 == charArray.length)) {
                throw new IllegalArgumentException("소수부 없는 실수를 입력할 수 없습니다.");
            }
            if (separators.contains(c)) {
                continue;
            }
            if (Character.isDigit(c)) {
                continue;
            }
            if (!separators.contains(c) && c == DECIMAL_POINT) {
                continue;
            }
            throw new IllegalArgumentException("구분자와 숫자가 아닌 문자는 입력할 수 없습니다.");
        }
    }

    private static List<BigDecimal> getNumbers(String numberPartOfFormula, Separators separators) {
        StringBuilder decimalAccumulator = new StringBuilder();
        List<BigDecimal> numbers = new ArrayList<>();
        for (char c : numberPartOfFormula.toCharArray()) {
            if (separators.contains(c)) {
                BigDecimal nowDecimal = convertNumberFrom(decimalAccumulator);
                numbers.add(nowDecimal);
                decimalAccumulator.setLength(0);
                continue;
            }

            decimalAccumulator.append(c);
        }

        if (!decimalAccumulator.isEmpty()) {
            numbers.add(convertNumberFrom(decimalAccumulator));
        }

        return List.copyOf(numbers);
    }

    private static BigDecimal convertNumberFrom(StringBuilder numberAccumulator) {
        if (numberAccumulator.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal converted = new BigDecimal(numberAccumulator.toString());
        if (BigDecimal.ZERO.compareTo(converted) == 0) {
            throw new IllegalArgumentException("숫자는 양수만 입력할 수 있습니다.");
        }
        return converted;
    }

    private static String dropDecimalPart(BigDecimal reduce) {
        return reduce.toBigInteger().toString();
    }

}
