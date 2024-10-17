package calculator.controller;

import calculator.View;

public class Controller {
    private static final String START = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT = "결과 : ";

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
        if (!text.contains("//")) {
            return regex;
        }
        if (!text.contains("\\n")) {
            throw new IllegalArgumentException();
        }
        return regex + "|" + text.substring(2, text.indexOf("\\n"));
    }

    private String[] splitNumbers(String text, String regex) {
        if (!text.contains("\\n")) {
            return text.split(regex);
        }
        return text.substring(text.indexOf("\\n") + 2).split(regex);
    }

    private void printStartMessage() {
        View.printMessage(START);
    }

    private void printResult(int result) {
        View.printMessage(RESULT + result);
    }
}
