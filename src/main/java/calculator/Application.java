package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        //문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // Console.readLine()으로 입력 받기

        //문자열 출력
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);

    }

}

