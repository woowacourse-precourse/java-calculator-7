package calculator;

import camp.nextstep.edu.missionutils.Console;

import static calculator.StringUtil.escapeCustomDelimiter;


public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String input = escapeCustomDelimiter(Console.readLine());
        System.out.println("결과 : " + calculator.sum(input));
    }
}
