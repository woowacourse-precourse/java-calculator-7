package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static boolean catchCustomSeparator(String input) {
        String left = input.substring(0, 2);
        String right = input.substring(3, 5);

        return left.equals("//") && right.equals("\\n");
    }

    public static String[] separators(String input) {
        String[] separators = new String[]
                {":"};
        if (catchCustomSeparator(input)) {
            separators =
                    new String[]{":", input.substring(2, 3)};
        }
        return separators;
    }

    public static String replace(String input) {
        String replacedInput = input;
        for (String sep : separators(input)) {
            replacedInput = input.replace(sep, ",");
        }
        return replacedInput;
    }

    public static int[] split(String input) {
        String[] arrayStrings = input.split(",");
        int len = input.length();
        int[] arrayInts = new int[len];
        for (int i = 0; i < len; i++) {
            try {
                arrayInts[i] = Integer.parseInt(arrayStrings[i]);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다.");
            }
        }
        return arrayInts;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = camp.nextstep.edu.
                missionutils.Console.readLine();

    }
}
