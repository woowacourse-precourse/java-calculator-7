package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    private static final String DEFAULT_SEPERATOR = ",|:";
    private static final String CUSTOM_SEPERATE_START = "//";
    private static final String CUSTOM_SEPERATE_END = "\\n";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String customSeperator = "";

        if (isCustomSeperator(input)) customSeperator = extractCustomSeperator(input);

        try {
            int[] number = Arrays.stream(splitBySeperator(input, customSeperator)).mapToInt(Integer::parseInt).toArray();
            int result = sumCalculate(number);

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {}
    }

    public static boolean isCustomSeperator(String input) {
        return input.contains(CUSTOM_SEPERATE_START) && input.contains(CUSTOM_SEPERATE_END);
    }

    public static String extractCustomSeperator(String input) {
        int start = input.indexOf(CUSTOM_SEPERATE_START) + 2; // 커스텀 문자 인덱스 시작
        int end = input.indexOf(CUSTOM_SEPERATE_END); // 커스텀 문자 인덱스 끝

        return input.substring(start, end);
    }

    public static String[] splitBySeperator(String input, String customSeperator) {
        String seperator = DEFAULT_SEPERATOR;
        if (input.equals("")) return new String[]{"0"};

        if (!customSeperator.equals("")) {
            input = input.replace(CUSTOM_SEPERATE_START + customSeperator + CUSTOM_SEPERATE_END, "");
            seperator = DEFAULT_SEPERATOR + "|" + customSeperator;
        }
        String[] number = input.split(seperator);

        return number;
    }

    public static int sumCalculate(int[] number) {
        int result = 0;

        for (int i : number) result += i;

        return result;
    }
}
