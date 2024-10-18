package calculator.object;

import java.math.BigDecimal;

public record CalculateFormula(
        Separators separators,
        Numbers numbers
) {

    public static CalculateFormula from(String inputFormula) {
        Separators separators = new Separators(inputFormula);
        Numbers numbers = new Numbers(inputFormula, separators);
        return new CalculateFormula(separators, numbers);
    }

    public String addAll() {
        BigDecimal reduce = numbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (reduce.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
            return reduce.toBigInteger().toString();
        }
        return reduce.toString();
    }

}
