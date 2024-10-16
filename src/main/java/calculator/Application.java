package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static boolean catchCustomSeparator(String input) {
//        if (input.startsWith("//\\n")) { // empty separator 비허용 시
//            return false;
//        }
        return input.startsWith("//") && input.contains("\\n");
    }

    public static String[] getSeparators(String input) {
        String[] separators = new String[]
                {":"};
        if (catchCustomSeparator(input)) {
            separators =
                    new String[]{":",
                            input.substring(2,
                                    input.indexOf("\\n"))};
        }
        return separators;
    }

    public static String trimSeparator(String input) {
        String trimedInput = input;
        if (catchCustomSeparator(input)) {
            trimedInput = input.substring(input.indexOf("\\n") + 2);
        }
        return trimedInput;
    }

    public static String replace(String input, String[] separators) {
        String replacedInput = trimSeparator(input);
        for (String sep : separators) {
            replacedInput = replacedInput.replace(sep, ",");
            if (sep.isEmpty()) {//empty separator 고려
                replacedInput = replacedInput.
                        substring(1, replacedInput.length() - 1);
            }
        }
        return replacedInput;
    }

    public static int[] split(String input, String[] separators) {
        String[] arrayStrings = replace(input, separators).split(",");
        int len = arrayStrings.length;
        int[] arrayInts = new int[len];
        for (int i = 0; i < len; i++) {
            try {
                arrayInts[i] = Integer.parseInt(arrayStrings[i]);
            } catch (NumberFormatException ex) {
                System.out.println(input + "은(는) 유효하지 않은 입력값입니다.");
                throw new IllegalArgumentException(input + "은(는) 유효하지 않은 입력값입니다.", ex);
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
        //String input = "//\\n123"; //테스트용
        String input = Console.readLine();
        if (input.isEmpty()) { // ""일 때 0 나오게 예외처리
            System.out.println("결과 : " + 0);
            return;
        }
        String[] separators = getSeparators(input);

        int[] container = split(input, separators);

        checkValidity(container);
        int sum = calculateSum(container);
        System.out.println("결과 : " + sum);
    }
}