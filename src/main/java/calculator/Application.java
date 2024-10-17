package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userText = Console.readLine();

        int sum = 0;

        if (!userText.isEmpty() && !userText.isBlank()) {
            // TODO: 입력값이 빈 문자열이 아닐 때
        }

        System.out.println("결과 : " + sum);

    }

}
