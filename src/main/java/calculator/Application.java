package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자열 입력하지 않음");
        }

        boolean hasCustomDelimiter = hasCustomDelimiter(input);
    }
}
