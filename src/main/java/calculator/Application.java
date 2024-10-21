package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = splitNumbers(input);
    }

    private static String[] splitNumbers(String input) {
        if (input.startsWith("//")) {
            String[] tokens = input.split("\n", 2);
            String customDelimiter = tokens[0].substring(2);
            input = tokens[1];
            return input.split(customDelimiter);
        }
        return input.split("[,;]");
    }
}
