package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        Calculator calculator = new Calculator(input);
        calculator.add();
        System.out.println("결과 : " + calculator.getResult());
    }
}
