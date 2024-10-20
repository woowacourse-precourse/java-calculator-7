package calculator.calculator.sum;

import calculator.calculator.StringCalculator;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator implements StringCalculator<Integer> {
    @Override
    public Integer add(String str) {
        List<Integer> operand = this.parse(str);


        return operand.stream()
                .peek(i -> {
                    if (i < 0) {
                        throw new IllegalArgumentException("음수는 넣을 수 없음");
                    }
                })
                .mapToInt(i -> i)
                .sum();
    }

    private List<Integer> parse(String str) {
        if (str.isEmpty()) {
            return List.of();
        }

        String delimiter = "[,:]";

        String[] operand = str.split(delimiter);

        return Arrays.stream(operand)
                .map(Integer::parseInt)
                .toList();
    }

}
