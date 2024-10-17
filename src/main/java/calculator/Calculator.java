package calculator;

import calculator.separator.Separator;

import java.util.List;

public class Calculator {

    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    public int calculate() {
        String[] strings = separator.splitLine();
        if (strings == null || strings.length == 0) {
            return 0;
        }
        List<Integer> numbers = Converter.convert(strings);
        return Aggregator.add(numbers);
    }
}
