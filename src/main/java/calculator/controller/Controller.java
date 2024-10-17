package calculator.controller;

import calculator.View;

public class Controller {
    private final String START = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULT = "결과 : ";

    private final String CUSTOM_REG_START = "//";
    private final String CUSTOM_REG_END = "\\n";

    public void calculate() {
        printStartMessage();
        var text = View.read();
        var regex = extractRegex(text);
        String[] nums = splitNumbers(text, regex);

        var total = 0;
        for (String num_text : nums) {
            int num;
            try {
                num = Integer.parseInt(num_text);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            total += num;
        }
        printResult(total);
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

    private void printStartMessage() {
        View.printMessage(START);
    }

    private void printResult(int result) {
        View.printMessage(RESULT + result);
    }
}
