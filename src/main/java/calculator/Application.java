package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATE_START = "//";
    private static final String CUSTOM_SEPARATE_END = "\\n";
    private static final String EXCEPTION_MESSAGE = "잘못된 값";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String customSeparator = "";

        if (isCustomSeparator(input)) customSeparator = extractCustomSeparator(input);
        String[] number = splitBySeparator(input, customSeparator);

        System.out.println("결과 : " + sumCalculate(number));
    }

    public static boolean isCustomSeparator(String input) {
        return input.contains(CUSTOM_SEPARATE_START) && input.contains(CUSTOM_SEPARATE_END);
    }

    public static String extractCustomSeparator(String input) {
        int start = input.indexOf(CUSTOM_SEPARATE_START) + 2; // 커스텀 문자 인덱스 시작
        int end = input.indexOf(CUSTOM_SEPARATE_END); // 커스텀 문자 인덱스 끝

        if (end == -1 || start == end) throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        return input.substring(start, end);
    }

    public static String[] splitBySeparator(String input, String customSeparator) {
        String separator = DEFAULT_SEPARATOR;
        if (input.equals("")) return new String[]{"0"};

        if (!customSeparator.equals("")) {
            input = input.replace(CUSTOM_SEPARATE_START + customSeparator + CUSTOM_SEPARATE_END, "");
            separator = DEFAULT_SEPARATOR + "|" + customSeparator;
        }

        return input.split(separator);
    }

    public static int sumCalculate(String[] number) {
        int sum = 0;

        for (String num : number) {
            int value;
            try {
                value = Integer.parseInt(num.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
            if (value < 0) {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
            sum += value;
        }
        return sum;
    }
}