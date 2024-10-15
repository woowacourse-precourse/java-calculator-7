package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Application {



    public static void main(String[] args) {
        InputStringParser parser = new InputStringParser();
        ListCalculator calculator = new ListCalculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        try {
            List<Long> list = parser.parse(inputString);
            ListValidator.validateIsPosList(list);

            long sumResult = calculator.calculate(list);
            System.out.println("결과 : " + sumResult);
        } catch (IllegalStateException e) {
            throw new IllegalStateException(e);
        }
    }
}
