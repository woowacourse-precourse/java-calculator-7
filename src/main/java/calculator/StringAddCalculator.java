package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class StringAddCalculator {

    public static int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";

        if (input.startsWith("//")) {
            input = input.replaceFirst("//", "");
            input = input.replace("\\n", "\n");

            String[] temp = input.split("\n");
            delimiter += "|" + temp[0];
            input = input.split("\n", 2)[1];
        }

        String[] numbers = input.split(delimiter);

        return sum(numbers);
    }

    static int sum(String[] numbers) {
        int sum = 0;

        for (String number: numbers) {
            int intNum;

            try {
                intNum = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if (intNum < 0) {
                throw new IllegalArgumentException();
            }

            sum += intNum;
        }

        return sum;
    }

    static void init_output() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

    }

    static void result_output(int result) {
        System.out.println("결과 : " + result);
    }

    static String input() {
        String input = "";

        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            System.out.println("결과 : 0");
        }

        return input;
    }

    public static void run() {
        init_output();
        String s = input();
        int result = calculator(s);
        result_output(result);
    }
}
