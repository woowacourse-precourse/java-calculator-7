package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        SumCalculator calculator = new SumCalculator();

        // 사용자의 입력은 Console API의 readLine()을 활용한다.
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = calculator.check(input);

        // 합산 결과를 출력한다.
        System.out.printf("결과: %d", result);
    }
}