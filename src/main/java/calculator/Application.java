package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        System.out.println("결과 : " + add(input));
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = input.split("[,|:]");
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}