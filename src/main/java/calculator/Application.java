package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;

public class Application {

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        Calculator calculator = new Calculator();

        if (calculator.isValidInput(input)) {
            BigInteger result = calculator.add(input);
            System.out.println("결과 : " + result);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
