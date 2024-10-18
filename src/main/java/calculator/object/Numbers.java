package calculator.object;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Numbers {

    //    private static final List<Character> DEFAULT_SEPARATORS = List.of(',', ':');
    private static final char DECIMAL_POINT = '.';

    private final List<BigDecimal> numbers;

    public Numbers(String inputFormula, Separators separators) {
        String formulaPart = getFormulaPart(inputFormula, separators);
        if (formulaPart.isEmpty()) {
            this.numbers = List.of(BigDecimal.ZERO);
            return;
        }

//        List<Character> separators = getSeparators(customSeparator);
        throwIfFormulaPartIsNotSeparatorOrNumber(formulaPart, separators);
        this.numbers = getNumbers(formulaPart, separators);
    }

    public Stream<BigDecimal> stream() {
        return numbers.stream();
    }

    public String addAll() {
        BigDecimal reduce = numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        if (reduce.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
            return dropDecimalPart(reduce);
        }
        return reduce.toString();
    }

    private static String getFormulaPart(String inputFormula, Separators separators) {
        String numberPartOfFormula = inputFormula;
        if (!separators.isCustomSeparatorEmpty()) {
            int separatorIndex = inputFormula.indexOf(Separators.getSeparatorFooter());
            int numbersStartIndex = separatorIndex + Separators.getSeparatorFooter().length();
            numberPartOfFormula = inputFormula.substring(numbersStartIndex);
        }
        return numberPartOfFormula;
    }

    private static void throwIfFormulaPartIsNotSeparatorOrNumber(String numberPartOfFormula,
                                                                 Separators separators) {
        for (char c : numberPartOfFormula.toCharArray()) {
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
