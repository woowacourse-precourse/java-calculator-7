package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

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

    public void start() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Converter converter = new Converter();
        List<Number> numbers = converter.convertWordsToString(input);

        Number number = addNumbers(numbers);
        System.out.println("결과 : "+number);
    }
}
