package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String string = Console.readLine();

        System.out.println("결과 : "+calculator.calculate(string));

    }
}
