package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final String DEFAULT = ",|:";


    public static void main(String[] args) {
        while (true) {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = readLine();

            int result = 0;
            try {
                checkDigit(input);
                char custom = hasSpecialSeparator(input);
                String[] input_array = checkString(custom, input);
                checkPositiveNumber(input_array);
                result = calculate(input_array);
                System.out.println("결과 : " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void checkDigit(String input) {
        int tmp = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                tmp = 1;
            }
        }
        if (tmp == 0) {
            throw new IllegalArgumentException("숫자가 존재하지 않습니다.");
        }
    }


    private static char hasSpecialSeparator(String input) {
        if (input.startsWith(CUSTOM_PREFIX) && input.substring(3, 5).equals(CUSTOM_SUFFIX)) {
            char custom = input.charAt(2);
            System.out.println("custom = " + custom);
            if (Character.isDigit(custom)) {
                throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
            }

            if (DEFAULT.contains(String.valueOf(custom))) {
                throw new IllegalArgumentException("커스텀 구분자는 기본 구분자가 될 수 없습니다.");
            }

            return custom;
        }
        return 0;
    }

    private static String[] checkString(char custom, String input) {
        if (custom != 0) {
            input = input.substring(5);
            System.out.println("custom = " + custom);
            return input.split(String.valueOf(custom));
        }
        return input.split(DEFAULT);
    }

    private static void checkPositiveNumber(String[] array) {
        for (String s : array) {
            if (Integer.parseInt(s) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }

    private static int calculate(String[] array) {
        int result = 0;
        for (String s : array) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}