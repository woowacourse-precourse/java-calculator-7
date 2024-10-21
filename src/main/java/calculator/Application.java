package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        String input = Console.readLine();
        int result = calculator.add(input);
        System.out.println("결과 : " + result);
    }
}