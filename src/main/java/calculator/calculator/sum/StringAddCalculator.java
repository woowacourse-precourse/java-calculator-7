package calculator.calculator.sum;

import calculator.calculator.StringCalculator;
import calculator.util.ExceptionMessage;
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
                        throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_INPUT.getMessage());
                    }
                })
                .reduce(new SeparatedDecimal("0"), SeparatedDecimal::add);
    }

    private List<SeparatedDecimal> parse(String str) {
        if (str.isEmpty()) {
            return List.of();
        }

        String delimiter = ",:";

        if (str.matches("^//(.)+\\\\n(.)+$")) {
            String[] s = str.split("\\\\n");
            String customDelimiter = s[0].substring("//".length());
            if (customDelimiter.matches("(.*)[.0-9](.*)")) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessage());
            }
            delimiter += s[0].substring("//".length());
            str = s[1];
        }

        delimiter = "["+delimiter+"]";

        String[] operand = str.split(delimiter);

        return Arrays.stream(operand)
                .map(SeparatedDecimal::new)
                .toList();
    }

}
