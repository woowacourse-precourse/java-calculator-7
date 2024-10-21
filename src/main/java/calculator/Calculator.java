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
        if (argument.length()==0) {
            return result;
        }
        if (argument.contains("//")) {
            if (!argument.contains("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다.");
            }
            String[] tmp = argument.split("\\\\n");
            if (tmp.length!=2 || tmp[0].length()!=3) {
                throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다.");
            }
            expression = tmp[1];
            splitter = tmp[0].substring(2, 3);
        }
        String[] operands = expression.split(splitter);
        try {
            for (String operand : operands) {
                long number = Long.parseLong(operand);
                if (number < 0) {
                    throw new IllegalArgumentException();
                }
                result.add(number);
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("수 입력값을 파싱할 수 없습니다.");
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
