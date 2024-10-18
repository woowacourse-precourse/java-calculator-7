package calculator;

import static calculator.StringCalculator.start;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.print("계산할 문자열을 입력하세요: ");
        String input = Console.readLine();

        try{
            int result = start(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
