package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static String divider = ",|:";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.\n");
        String input = Console.readLine();

        String parsedInput = findCustomDivider(input);
        int sum = calculateSum(parsedInput);

        System.out.println("결과 : " + sum);

        Console.close();
    }

    private static String findCustomDivider(String input) {
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            if (endIndex == -1) {
                throw new IllegalArgumentException("'\\n' 문자가 문자열에 존재하지 않습니다.");
            }

            if (endIndex != 3) {
                throw new IllegalArgumentException("커스텀 구분자는 한글자의 문자여야 합니다.");
            }

            if (Character.isDigit(input.charAt(2))) {
                throw new IllegalArgumentException("커스텀 구분자는 문자 형식이어야 합니다.");
            }

            divider = divider + "|" + input.charAt(2);
            input = input.substring(endIndex + 2);
        }

        return input;
    }

    private static int calculateSum(String parsedInput) {
        // TODO
        return 0;
    }
}
