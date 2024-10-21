package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();
        StringCalculator calculator = new StringCalculator();

        BigInteger result = calculator.calculate(userInput);
        System.out.println("결과 : " + result);
        Console.close();
    }
}
