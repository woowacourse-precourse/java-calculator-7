package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final String DEFAULT = ",|:";


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        int result = 0;
        try {
            checkDigit(input);
            char custom = hasSpecialSeparator(input);
            if (custom != 0) {
                input = input.substring(5);
                String[] input_array = input.split(String.valueOf(custom));
                checkPositiveNumber(input_array);
                for (String s : input_array) {
                    //System.out.println(s);
                    result += Integer.parseInt(s);
                }
            } else {
                String[] input_array = input.split(DEFAULT);
                checkPositiveNumber(input_array);
                for (String s : input_array) {
                    //System.out.println(s);
                    result += Integer.parseInt(s);
                }
            }

            System.out.println("결과 : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkDigit(String input) {
        int tmp = 0;
        for (int i = 0; i < input.length(); i++) {
            if (isNumber(input.charAt(i))) {
                tmp = 1;
            }
        }
        if (tmp == 0) {
            throw new IllegalArgumentException("숫자가 존재하지 않습니다.");
        }
    }

    private static boolean isNumber(char c) {
        int tmp = (int) c;
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }


    private static char hasSpecialSeparator(String input) {
        if (input.startsWith(CUSTOM_PREFIX) && input.substring(3, 5).equals(CUSTOM_SUFFIX)) {
            return input.charAt(2);
        }
        return 0;
    }

    private static void checkPositiveNumber(String[] array) {
        for (String s : array) {
            if (Integer.parseInt(s) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }
}