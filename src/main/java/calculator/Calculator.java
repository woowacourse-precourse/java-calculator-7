package calculator;

import calculator.separator.Separator;

import java.util.List;

public class Calculator {

    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    public int calculate() {
        // \n이 2개 이상 있으면 오류 처리
        // 커스텀 구분자 지정할 때 한글자가 아니면 오류 처리
        String[] strings = separator.splitLine();
        if (strings == null || strings.length == 0) {       // length==0 이 직관적이지 않다.
            return 0;
        }
        List<Integer> numbers = Converter.convert(strings);     // 숫자가 0일 때에는 여기서 처리하는게 좋지 않을까?
        return Aggregator.add(numbers);
    }
}
