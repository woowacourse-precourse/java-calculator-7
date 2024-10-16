package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static boolean catchCustomSeparator(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public static String[] getSeparators(String input) {
        String[] separators = new String[]
                {":"};
        if (catchCustomSeparator(input)) {
            separators =
                    new String[]{":", input.substring(2, 3)};
        }
        return separators;
    }

    public static String replace(String input, String[] separators) {
        String replacedInput = input;
        for (String sep : separators) {
            replacedInput = replacedInput.replace(sep, ",");
        }
        return replacedInput;
    }

    public static int[] split(String input) {
        String[] arrayStrings = input.split(",");
        int len = arrayStrings.length;
        int[] arrayInts = new int[len];
        for (int i = 0; i < len; i++) {
            try {
                arrayInts[i] = Integer.parseInt(arrayStrings[i]);
            } catch (NumberFormatException ex) {
                System.out.println("\"" + input + "\"" + "은(는) 유효하지 않은 입력값입니다.");
                throw new IllegalArgumentException("\"" + input + "\"" + "은(는) 유효하지 않은 입력값입니다.", ex);
            }
        }
        return arrayInts;
    }

    public static void checkValidity(int[] arrayInts) {
        for (int arrayInt : arrayInts) {
            if (arrayInt <= 0) {
                System.out.println("유효하지 않은 입력값입니다.");
                throw new IllegalArgumentException(arrayInt + "은(는) 유효하지 않은 입력값입니다. (expected)");
            }

        }

    }

    public static int calculateSum(int[] arrayInts) {
        int result = 0;
        for (int nat : arrayInts) {
            result += nat;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) { // ""일 때 0 나오게 예외처리
            System.out.println("결과 : " + 0);
            return;
        }
        String[] separators = getSeparators(input);

        if (catchCustomSeparator(input)) {
            input = input.substring(input.indexOf("\\n") + 2);
        }
        input = replace(input, separators);

        int[] container = split(input);

        checkValidity(container);
        int sum = calculateSum(container);
        System.out.println("결과 : " + sum);
    }
}
