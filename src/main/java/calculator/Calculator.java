package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Calculator {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.";
    private static final String OUTPUT_MESSAGE = "결과 : ";

    public static void start() {
        try {
            System.out.println(INPUT_MESSAGE);
            String input = Console.readLine();
            List<Integer> list = Parser.parse(input);// parser
            int sum = sum(list);
            end(sum);
        } finally {
            Console.close();
        }
    }

    public static int sum(List<Integer> input) {
        int sum = 0;
        for (int number : input) {
            sum += number;
        }
        return sum;
    }

    public static void end(int sum) {
        System.out.println(OUTPUT_MESSAGE + sum);
    }
}
