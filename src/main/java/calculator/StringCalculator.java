package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    String separators = ",:";
    boolean hasCustomSeparator;

    void run() {
        printInputMsg();
        String input = Console.readLine();
        checkCustomSeparator(input);

    }

    void printInputMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    void checkCustomSeparator(String input) {
        int flag = 0;
        if (beginTwoSlash(input)) {
            if (!input.contains("\\n")) {
                flag = 1;
            } else {
                if (input.indexOf("\\n") > 3) {
                    flag = 2;
                } else if (isSeparatorNumeric(input.charAt(2))) {
                    flag = 3;
                } else {
                    addCustomSeparator(input.charAt(2));
                }
            }
        }
        if (flag != 0) {
            throw new IllegalArgumentException("커스텀 구분자 에러");
        }
    }

    void addCustomSeparator(char customSeparator) {
        hasCustomSeparator = true;
        separators += customSeparator;
    }

    boolean beginTwoSlash(String input) {
        return input.indexOf("//") == 0;
    }

    boolean isSeparatorNumeric(char separator) {
        return Character.isDigit(separator);
    }
}
