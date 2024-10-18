package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Application {



    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();


        Factor factor = new Factor();
        Calculator calculator = new Calculator();

        try {
            int sum = calculator.calc(input);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e){
            throw e;
        }

    }
}
