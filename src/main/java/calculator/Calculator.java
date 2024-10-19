package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        String[] numbers = splitString(input);
        System.out.println("분리된 숫자: ");
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public static String[] splitString(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }
}