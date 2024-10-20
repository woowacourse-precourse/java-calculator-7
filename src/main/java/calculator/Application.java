package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String DEFAULT_SEPERATOR = ",|:";
    private static final String CUSTOM_SEPERATE_START = "//";
    private static final String CUSTOM_SEPERATE_END = "\\n";
    private static final String EXCEPTION_MESSAGE = "잘못된 값";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String customSeperator = "";

        if (isCustomSeperator(input)) customSeperator = extractCustomSeperator(input);
        String[] number = splitBySeperator(input, customSeperator);

        System.out.println("결과 : " + sumCalculate(number));
    }

    public static boolean isCustomSeperator(String input) {
        return input.contains(CUSTOM_SEPERATE_START) && input.contains(CUSTOM_SEPERATE_END);
    }

    public static String extractCustomSeperator(String input) {
        int start = input.indexOf(CUSTOM_SEPERATE_START) + 2; // 커스텀 문자 인덱스 시작
        int end = input.indexOf(CUSTOM_SEPERATE_END); // 커스텀 문자 인덱스 끝

        if (end == -1 || start == end) throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        return input.substring(start, end);
    }

    public static String[] splitBySeperator(String input, String customSeperator) {
        String seperator = DEFAULT_SEPERATOR;
        if (input.equals("")) return new String[]{"0"};

        if (!customSeperator.equals("")) {
            input = input.replace(CUSTOM_SEPERATE_START + customSeperator + CUSTOM_SEPERATE_END, "");
            seperator = DEFAULT_SEPERATOR + "|" + customSeperator;
        }

        return input.split(seperator);
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