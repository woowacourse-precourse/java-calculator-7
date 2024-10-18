package calculator.controller;

import calculator.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final String START = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULT = "결과 : ";

    private final String CUSTOM_REG_START = "//";
    private final String CUSTOM_REG_END = "\\n";

    public void calculate() {
        printStartMessage();
        var text = View.read();
        var regex = extractRegex(text);
        printResult(sum(convertInt(splitNumbers(text, regex))));
    }

    private String extractRegex(String text) {
        var regex = ",|:";
        if (!text.contains(CUSTOM_REG_START)) {
            return regex;
        }
        validateCustomReg(text);
        return regex + "|" + text.substring(2, text.indexOf(CUSTOM_REG_END));
    }

    private void validateCustomReg(String text) {
        if (!text.contains(CUSTOM_REG_END)) {
            throw new IllegalArgumentException();
        }
    }

    private String[] splitNumbers(String text, String regex) {
        if (!text.contains(CUSTOM_REG_END)) {
            return text.split(regex);
        }
        return text.substring(text.indexOf(CUSTOM_REG_END) + CUSTOM_REG_END.length()).split(regex);
    }

    private List<Integer> convertInt(String[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            validateIsWrongInteger(number);
            validateIsMinus(number);
            list.add(Integer.parseInt(number));
        }
        return list;
    }

    private void validateIsWrongInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsMinus(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int sum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private void printStartMessage() {
        View.printMessage(START);
    }

    private void printResult(int result) {
        View.printMessage(RESULT + result);
    }
}
