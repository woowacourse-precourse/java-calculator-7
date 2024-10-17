package calculator;

import calculator.separator.Separator;

import java.util.List;

public class Calculator {

    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    public void calculate() {
        String[] strings = separator.splitLine();
        if (strings == null || strings.length == 0) {
            System.out.println(0);
            return;
        }
        List<Integer> numbers = Converter.convert(strings);
    }
}
