package calculator;

import calculator.handler.ColonSemicolonDelimiterHandler;

import java.util.List;

// 숫자들의 합을 계산해주는 역할을 한다.
public class Calculator {
    private ColonSemicolonDelimiterHandler handler;

    public Calculator(ColonSemicolonDelimiterHandler handler) {
        this.handler = handler;
    }

    public Integer sum(String str) {
        List<Integer> integerList = handler.split(str);
        return integerList.parallelStream().mapToInt(Integer::intValue).sum();
    }
}
