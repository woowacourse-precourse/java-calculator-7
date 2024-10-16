package calculator;

import calculator.separator.Separator;

public class Calculator {

    private final Separator separator;
    private String line;

    public Calculator(Separator separator, String line){
        this.separator = separator;
        this.line = line;
    }

    public void calculate() {
        String[] strings = separator.splitLine(line);
    }
}
