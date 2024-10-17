package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.\n");
        String input = Console.readLine();

        String parsedInput = findCustomDivider(input);
        int sum = calculateSum(parsedInput);

        System.out.println("결과 : " + sum);

        Console.close();
    }

    private static String findCustomDivider(String input) {
        // TODO
        return input;
    }

    private static int calculateSum(String parsedInput) {
        // TODO
        return 0;
    }
}
