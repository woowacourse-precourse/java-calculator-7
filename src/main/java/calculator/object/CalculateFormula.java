package calculator.object;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public record CalculateFormula(
        CustomSeparator customSeparator,
        List<BigDecimal> numbers
) {

    private static final List<Character> DEFAULT_SEPARATORS = List.of(',', ':');
    private static final char DECIMAL_POINT = '.';

    public static CalculateFormula from(String inputFormula) {
        CustomSeparator customSeparator = new CustomSeparator(inputFormula);
        List<BigDecimal> numbers = findNumbers(customSeparator, inputFormula);
        return new CalculateFormula(customSeparator, numbers);
    }

    public String addAll() {
        BigDecimal reduce = numbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (reduce.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
            return reduce.toBigInteger().toString();
        }
        return reduce.toString();
    }

    private static List<BigDecimal> findNumbers(CustomSeparator customSeparator, String inputFormula) {
        String targetFormula = inputFormula;
        if (!customSeparator.isExists()) {
            targetFormula = inputFormula.substring(inputFormula.indexOf(CustomSeparator.getSeparatorFooter())
                    + CustomSeparator.getSeparatorFooter().length());
        }

        List<Character> separators = DEFAULT_SEPARATORS;
        if (!customSeparator.isExists()) {
            separators = Stream.concat(separators.stream(), Stream.of(customSeparator.toChar()))
                    .toList();
        }

        if (targetFormula.isEmpty()) {
            return List.of(BigDecimal.ZERO);
        }

        for (char c : targetFormula.toCharArray()) {
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

        StringBuilder decimalAccumulator = new StringBuilder();
        List<BigDecimal> numbers = new ArrayList<>();
        for (char c : targetFormula.toCharArray()) {
            if (separators.contains(c)) {
                BigDecimal nowDecimal = convertFrom(decimalAccumulator);
                numbers.add(nowDecimal);
                decimalAccumulator.setLength(0);
                continue;
            }

            decimalAccumulator.append(c);
        }

        if (!decimalAccumulator.isEmpty()) {
            numbers.add(convertFrom(decimalAccumulator));
        }

        return numbers;
    }

    private static BigDecimal convertFrom(StringBuilder numberAccumulator) {
        if (numberAccumulator.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal converted = new BigDecimal(numberAccumulator.toString());
        if (BigDecimal.ZERO.compareTo(converted) == 0) {
            throw new IllegalArgumentException("숫자는 양수만 입력할 수 있습니다.");
        }
        return converted;
    }

}
