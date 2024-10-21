package calculator;

import calculator.Validator.Validator;
import calculator.parser.NumberParser;
import java.util.Arrays;

public class Calculator {

    public Calculator() {
    }

    //think: 스트림의 강력함을 사용하면 좋겠지만, 이렇게 쓰는 방식이 좋을지 모르겠다.
    public Number sumOfString(String[] value) {
        Validator.validate(value); // 계산 하기 전 유효성 검사
        return Arrays.stream(value)
                .map(NumberParser::parse) // 스트림에서 parse를 계속 호출하고 있는 문제점
                .reduce(this::sum)
                .orElse(0);
    }

    private Number sum(Number n1, Number n2) {
        if (n1.getClass().equals(Double.class) && n2.getClass().equals(Double.class)) {
            return Double.sum(n1.doubleValue(), n2.doubleValue());
        } else {
            return Integer.sum(n1.intValue(), n2.intValue());
        }
    }
}
