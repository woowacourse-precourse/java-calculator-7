package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        String[] sArr = input.split(",|:");

        long answer = 0;
        for (String s : sArr) {
            answer += Integer.parseInt(s);
        }

        System.out.println("결과 : " + answer);
    }
}
