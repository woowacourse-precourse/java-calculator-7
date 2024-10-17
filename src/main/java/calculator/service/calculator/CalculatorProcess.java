package calculator.service;

import calculator.number.domain.Number;
import calculator.separator.domain.Separator;
import calculator.util.Convertor;

import java.util.Arrays;

public class CalculatorProcess {
    public int sum(Number number, Separator customSeparator) {
        return Arrays.stream(number.getNumber()
                        .split(customSeparator.getSeparator()))
                .mapToInt(Convertor::stringToIntBlankIsZero)
                .sum();
    }
}
