package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //문자열 입력받기
        String input = Console.readLine();
        System.out.println(input);
        Calculator calculator = new Calculator();
        int result = calculator.add(input);
        System.out.println(result);
    }
}
