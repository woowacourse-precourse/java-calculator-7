package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.nio.charset.StandardCharsets;
import java.io.PrintStream;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.setOut(new PrintStream(new PrintStream(System.out, true, StandardCharsets.UTF_8)));

        int result = 0;
        String[] operands;

        // read input and split
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine().strip();
        operands = inputSplitter(input);

        // parse to int and print sum
        for (String operand : operands) {
            if (!operand.isEmpty()) {
                if (Character.isDigit(operand.charAt(0))) {
                    result += Integer.parseInt(operand);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        System.out.println("결과 : " + result);
    }

    public static String[] inputSplitter(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String splitPattern = "[,:]";

        return input.split(splitPattern);
    }
}
