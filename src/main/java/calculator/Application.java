package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("addition" + " calculator");
        System.out.println(" ");
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        // camp.nextstep.edu.missionutils.Console readLine() 메서드 호출

        try {
            int result = StringCalculator.calc(input);
            System.out.println("결과 : " + result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("오류로 인해 프로그램을 종료합니다");
        }
    }
}
