package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        Calculator calculator = new Calculator();
        int result = calculator.run(Console.readLine());

        System.out.print("결과 : " + result);

    }
}
