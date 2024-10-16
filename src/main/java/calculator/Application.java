package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String customSeperator = "";

        if (isCustomSeperator(input)) customSeperator = extractCustomSeperator(input);

        String[] number = splitBySeperator(input, customSeperator);

        int result = sumCalculate(number);
        System.out.println("결과 : " + result);
    }

    public static boolean isCustomSeperator(String input) {
        if (input.contains("//") && input.contains("\\n")) return true;
        return false;
    }

    public static String extractCustomSeperator(String input) {
        int start = input.indexOf("//") + 2; // 커스텀 문자 인덱스 시작
        int end = input.indexOf("\\n"); // 커스텀 문자 인덱스 끝

        return input.substring(start, end);
    }

    public static String[] splitBySeperator(String input, String customSeperator) {
        input = input.replace("//" + customSeperator + "\\n", "");
        String[] number = input.split(",|:|" + customSeperator);

        return number;
    }

    public static int sumCalculate(String[] number) {
        return 0;
    }
}
