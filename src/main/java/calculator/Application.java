package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Separator separator = new Separator();
        final Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        separator.makeNumsAndParams(input);

        int result = calculator.Calculate(separator.getNums());
        System.out.println("결과 : "+result);
        Console.close();
    }
}
