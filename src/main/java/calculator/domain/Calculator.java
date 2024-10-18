package calculator.domain;

import java.util.List;

public class Calculator {

    private final Number value;

    public Calculator() {
        value = new Number();
    }

    public Number addNumbers(final List<Number> numberList) {
        for (Number number : numberList) {
            value.addNumber(number);
        }
        return value;
    }

    public String showCurrentStatus() {
        return "결과 : " + value;
    }

}
