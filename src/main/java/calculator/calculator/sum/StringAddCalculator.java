package calculator.calculator.sum;

import calculator.calculator.StringCalculator;
import calculator.util.SeparatedDecimal;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator implements StringCalculator<SeparatedDecimal> {
    @Override
    public SeparatedDecimal add(String str) {
        List<SeparatedDecimal> operand = this.parse(str);

        return operand.stream()
                .peek(i -> {
                    if (i.getIntegerPart() < 0) {
                        throw new IllegalArgumentException("음수는 넣을 수 없음");
                    }
                })
                .reduce(new SeparatedDecimal("0"), SeparatedDecimal::add);
    }

    private List<SeparatedDecimal> parse(String str) {
        if (str.isEmpty()) {
            return List.of();
        }

        String delimiter = "[,:]";

        String[] operand = str.split(delimiter);

        return Arrays.stream(operand)
                .map(SeparatedDecimal::new)
                .toList();
    }

}
