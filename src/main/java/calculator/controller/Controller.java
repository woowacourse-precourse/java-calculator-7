package calculator.controller;

import calculator.util.Validator;
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
        Validator.validateCustomRegex(text);
        return regex + "|" + text.substring(2, text.indexOf(CUSTOM_REG_END));
    }

    private String[] splitNumbers(String text, String regex) {
        if (!text.contains(CUSTOM_REG_END)) {
            return text.split(regex);
        }
        return substringText(text).split(regex);
    }

    private String substringText(String text) {
        return text.substring(text.indexOf(CUSTOM_REG_END) + CUSTOM_REG_END.length());
    }

    private List<Integer> convertInt(String[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            Validator.validateWrongNumber(number);
            list.add(Integer.parseInt(number));
        }
        return list;
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
