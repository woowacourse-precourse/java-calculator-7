package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();
        int result = calculator.add(input);

        System.out.println("결과 : " + result);
    }
}
