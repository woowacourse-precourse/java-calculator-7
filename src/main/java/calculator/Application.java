package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {


    public static void main(String[] args) {
        String input = Console.readLine();
        int sum = StringCalculator.splitAndSum(input);
        System.out.println("결과 : " + sum);
    }
}
