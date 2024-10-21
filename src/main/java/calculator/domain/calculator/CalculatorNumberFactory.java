package calculator.domain.calculator;

import java.util.List;

public class CalculatorNumberFactory {
    private CalculatorNumberFactory() {
    }

    public static CalculatorNumbers createCalculatorNumbersFrom(List<String> numberStrings) {
        List<CalculatorNumber> calculatorNumbers = parseCalculateNumbers(numberStrings);

        return CalculatorNumbers.from(calculatorNumbers);
    }

    private static List<CalculatorNumber> parseCalculateNumbers(List<String> numberStrings) {
        return numberStrings.stream()
                .map(CalculatorNumber::from)
                .toList();
    }
}
