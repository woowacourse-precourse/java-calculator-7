package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Calculator calculator = new Calculator(Console.readLine());
        String result = "결과 : " + calculator.calculate();
        System.out.println(result);
    }
}
