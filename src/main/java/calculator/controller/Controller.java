package calculator.controller;

import calculator.View;

public class Controller {
    private static final String START = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT = "결과 : ";

    public void calculate() {
        printStartMessage();
        var text = View.read();
        var regex = ",|:";
        String[] nums;
        if (text.indexOf("//") != -1) {
            if (text.indexOf("\\n") == -1) {
                throw new IllegalArgumentException();
            }
            var custom = text.substring(2, text.indexOf("\\n"));
            if (!custom.equals("")) {
                regex += "|" + custom;
            }
            nums = text.substring(text.indexOf("\\n") + 2, text.length()).split(regex);
        } else {
            nums = text.split(regex);
        }

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

    private void printStartMessage() {
        View.printMessage(START);
    }

    private void printResult(int result) {
        View.printMessage(RESULT + result);
    }
}
