package calculator;

import calculator.parser.InputParser;
import calculator.parser.InputParser.Builder;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");

        String input = Console.readLine();
        InputParser inputParser = new Builder().setDefaultDelimiter(",:").setCustomDelimiterFormat("//", "\\\\n")
                .build();
        ArrayList<Integer> numbers = inputParser.parse(input);

        System.out.println(numbers);
        Console.close();
    }
}
