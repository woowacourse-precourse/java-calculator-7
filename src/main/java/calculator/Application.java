package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class Application {
    public static void main(String[] args) {
        System.setOut(new PrintStream(new PrintStream(System.out, true, StandardCharsets.UTF_8)));

        int result;
        String[] operands;

        // read input and split
        // System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine().strip();
        operands = inputSplitter(input);

        System.out.println(String.join(" ", operands));

        result = 1;
        System.out.println("결과 : " + result);
    }

    public static String[] inputSplitter(String input) throws NumberFormatException {
        String splitPattern = "[,:]";

        return input.split(splitPattern);
    }
}
