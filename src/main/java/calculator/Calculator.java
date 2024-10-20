package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final String argument;

    public Calculator(String argument) {
        this.argument = argument;
    }

    public Long calculate() {
        return addElements(parse());
    }

    private List<Long> parse() {
        List<Long> result = new ArrayList<>();
        String expression = argument;
        String splitter = "[,:]";
        if (argument.charAt(0) == '/') {
            int idx = argument.indexOf("\n");
            if (idx == -1) {
                throw new IllegalStateException("잘못된 형식입니다.");
            }
            String[] tmp = argument.split("\n");
            expression = tmp[1];
            if (tmp.length!=2 || tmp[0].length()!=3) {
                throw new IllegalStateException("잘못된 형식입니다.");
            }
            splitter = tmp[0].substring(2, 3);
        }
        String[] operands = expression.split(splitter);
        try {
            for (String operand : operands) {
                result.add(Long.parseLong(operand));
            }
        } catch (NumberFormatException e) {
            throw new IllegalStateException("잘못된 형식입니다.");
        }
        return result;
    }

    private Long addElements(List<Long> elements) {
        Long sum = 0L;
        for (Long element: elements) {
            sum += element;
        }
        return sum;
    }
}
