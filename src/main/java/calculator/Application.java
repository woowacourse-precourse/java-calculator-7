package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //입력 받는 객체 scanner 생성
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        //출력 로직
        String sum = "0";
        System.out.println("결과 : " + sum);
    }
}
