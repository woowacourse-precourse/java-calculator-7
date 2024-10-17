package calculator.object;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public record CalculateFormula(
        String customSeparator,
        List<BigDecimal> numbers
) {

    private static final List<Character> DEFAULT_SEPARATORS = List.of(',', ':');
    private static final char DECIMAL_POINT = '.';
    private static final String CUSTOM_SEPARATOR_HEADER = "//";
    private static final String CUSTOM_SEPARATOR_FOOTER = "\\n";

    public static CalculateFormula from(String inputFormula) {
        String customSeparator = findCustomSeparator(inputFormula);
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

    private static String findCustomSeparator(String inputFormula) {
        if (!inputFormula.contains(CUSTOM_SEPARATOR_HEADER) || inputFormula.indexOf(CUSTOM_SEPARATOR_FOOTER) <= 0) {
            return "";
        }

        String customSeparator = inputFormula.substring(CUSTOM_SEPARATOR_HEADER.length(), inputFormula.indexOf(CUSTOM_SEPARATOR_FOOTER));
        if (customSeparator.length() != 1) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자가 입력되었습니다.");
        }

        return customSeparator;
    }

    private static List<BigDecimal> findNumbers(String customSeparator, String inputFormula) {
        String targetFormula = inputFormula;
        if (!customSeparator.isEmpty()) {
            targetFormula = inputFormula.substring(
                    inputFormula.indexOf(CUSTOM_SEPARATOR_FOOTER) + CUSTOM_SEPARATOR_FOOTER.length());
        }

        List<Character> separators = DEFAULT_SEPARATORS;
        if (!customSeparator.isEmpty()) {
            separators = Stream.concat(separators.stream(), Stream.of(customSeparator.charAt(0)))
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
