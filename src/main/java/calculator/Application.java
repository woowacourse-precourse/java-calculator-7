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
        return true;
    }

    public static String extractCustomSeperator(String input) {
        return null;
    }

    public static String[] splitBySeperator(String input, String customSeperator) {
        return null;
    }

    public static int sumCalculate(String[] number) {
        return 0;
    }
}
