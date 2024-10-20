package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String str = Console.readLine();
        Calculator calculator = new Calculator();

        int result = calculator.convert(str);
        System.out.println("결과 : " + result);
        Console.close();
    }
}
