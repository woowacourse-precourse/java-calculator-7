package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        //입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        StringCalculator calculator = new StringCalculator();
        int resultSum = calculator.calculate(input);

        //출력
        System.out.println("결과 : " + resultSum);
        Console.close();

    }
}
