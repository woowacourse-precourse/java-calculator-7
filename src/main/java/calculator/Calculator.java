package calculator;

import calculator.separator.Separator;

import java.util.List;

public class Calculator {

    private final Separator separator;
    private String line;

    public Calculator(Separator separator, String line) {
        this.separator = separator;
        this.line = line;
    }

    public void calculate() {
        String[] strings = separator.splitLine(line);
        if (strings == null) {
            System.out.println(0);
            return;
        }
        List<Integer> numbers = Converter.convert(strings);
    }
}
