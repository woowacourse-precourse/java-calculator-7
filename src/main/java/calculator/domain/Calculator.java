package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Calculator {

    private final static Calculator CALCULATOR = new Calculator(Converter.getInstance());
    private final Number value;
    private final Converter converter;

    private Calculator(Converter converter) {
        value = new Number();
        this.converter = converter;
    }

    public static Calculator getInstance() {
        return CALCULATOR;
    }

    public Number addNumbers(final List<Number> numberList) {
        initializeValue();
        for (Number number : numberList) {
            value.addNumber(number);
        }
        return value;
    }

    public String showCurrentStatus() {
        return "결과 : " + value;
    }

    private void initializeValue() {
        value.initialize();
    }

    public void start() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        List<Number> numbers = converter.convertWordsToNumberList(input);

        addNumbers(numbers);
        System.out.println(showCurrentStatus());
    }
}
