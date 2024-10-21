package calculator;

import java.util.HashSet;

public class Validator {

    public static void checkUsingSeparator(int index, char[] inputArray) {
        int front = index - 1;
        int back = index + 1;
        if (front < 0 || back > inputArray.length - 1) {
            throw new IllegalArgumentException("분리자는 숫자 사이에 사용해야 한다(문자열 끝에 사용)");
        }

        if (!(Character.isDigit(inputArray[front]) && Character.isDigit(inputArray[back]))) {
            throw new IllegalArgumentException("분리자는 숫자 사이에 사용해야 한다(연속적인 분리자 사용)");
        }
    }

    public static void checkChar(char curChar, HashSet<Character> separators) {
        if (!Character.isDigit(curChar) && curChar != '/' && !separators.contains(curChar)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다");
        }
    }
}
