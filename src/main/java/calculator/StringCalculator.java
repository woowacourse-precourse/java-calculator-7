package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    String separators = ",:";
    boolean hasCustomSeparator;

    void run() {
        printInputMsg();
        String input = Console.readLine();
        checkCustomSeparator(input);

        String str = input;
        if (hasCustomSeparator) {
            int strStartIdx = input.indexOf("\\n") + 2;
            str = input.substring(strStartIdx);
        }
        validateString(str);
    }

    void printInputMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    void validateString(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isSeparator(c) && !Character.isDigit(c)) {
                throw new IllegalArgumentException("문자열 에러");
            }
        }
    }

    boolean isSeparator(char c) {
        for (int i = 0; i < separators.length(); i++) {
            if (c == separators.charAt(i)) {
                return true;
            }
        }
        return false;
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
