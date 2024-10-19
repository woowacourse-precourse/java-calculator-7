package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new CalculatorImpl();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        int result = calculator.plus(str);

        System.out.println("결과 : " + result);
    }
}
