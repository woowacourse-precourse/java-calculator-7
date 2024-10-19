package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("덧셈할 문자열을 입력해주세요 : ");
        String input = Console.readLine(); // 사용자의 값을 입력받음

        StringCalculator calculator = new StringCalculator();

        int result = calculator.add(input); // 사용자가 입력한 문자열로 덧셈 계산

        System.out.println("결과 : " + result); // 결과 출력

    }
}
