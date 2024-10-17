package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    String separators = ",:";
    boolean hasCustomSeparator;
    int sumValue;

    void run() {
        printInputMsg();
        String input = Console.readLine();
        if (hasCustomPart(input)) {
            if (validateCustomSeparator(input)) {
                addCustomSeparator(input.charAt(2));
            } else {
                throw new IllegalArgumentException("커스텀 구분자 에러");
            }
        }

        String str = input;
        if (hasCustomSeparator) {
            int strStartIdx = input.indexOf("\\n") + 2;
            str = input.substring(strStartIdx);
        }
        validateString(str);

        String[] separatedNumbers = str.split('[' + separators + ']');
        calculateSumValue(separatedNumbers);
        System.out.println("결과 : " + sumValue);
    }

    void printInputMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    void calculateSumValue(String[] separatedNumbers) {
        sumValue = 0;
        for (String number : separatedNumbers) {
            sumValue += Integer.parseInt(number);
        }
    }

    boolean hasCustomPart(String input) {
        if (input.startsWith("//")) {
            return input.contains("\\n");
        }
        return false;
    }

    void addCustomSeparator(char customSeparator) {
        hasCustomSeparator = true;
        separators += customSeparator;
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

    boolean validateCustomSeparator(String input) {
        if (input.indexOf("\\n") != 3) {
            return false;
        } else {
            return !isSeparatorNumeric(input.charAt(2));
        }
    }

    boolean isSeparatorNumeric(char separator) {
        return Character.isDigit(separator);
    }
}
