package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            String input = Console.readLine(); // 사용자로부터 문자열 입력 받기

            int result = Calculator.add(input); // Calculator 클래스의 add 메서드 호출
            System.out.println("결과 : " + result); // 결과 출력
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
        }
    }
}