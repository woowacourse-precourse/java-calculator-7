package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;
        String input = readLine();
        System.out.println("input = " + input);

        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (isNumber(input.charAt(i))) {
                System.out.println(" number = " + input.charAt(i));
            } else if (isBasicSeparator(input.charAt(i))) {
                System.out.println(" basic = " + input.charAt(i));
            } else if (isSpecialSeparator(input.charAt(i), input)) {
                System.out.println(" special = " + input.charAt(i));
            }
        }
    }

    public static boolean isNumber(char c) {
        int tmp = (int) c;
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static boolean isBasicSeparator(char c) {
        if (c == ';' || c == ',') {
            return true;
        }
        return false;
    }

    public static boolean isSpecialSeparator(char c, String input) {
        if (input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            if (c == input.charAt(2)) {
                return true;
            }
        }
        return false;
    }
}
