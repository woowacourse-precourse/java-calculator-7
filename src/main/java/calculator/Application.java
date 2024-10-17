package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        StringCalculator stringCalculator = new StringCalculator();
        String input = Console.readLine();

        int result = stringCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}
