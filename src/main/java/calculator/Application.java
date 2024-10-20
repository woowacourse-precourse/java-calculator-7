package calculator;

import camp.nextstep.edu.missionutils.Console;
import calculator.calculator.StringCalculator;
import calculator.calculator.sum.StringAddCalculator;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        StringCalculator<Integer> calculator = new StringAddCalculator();
        System.out.println("결과 : " + calculator.add(str));

        Console.close();
    }
}
