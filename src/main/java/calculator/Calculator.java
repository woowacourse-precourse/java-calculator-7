package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Calculator {
    private final Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        Character delimiter = parser.parseCustomDelimiter(input);
        List<Integer> integers = parser.parseIntegers(input, delimiter);

        System.out.println("결과 : " + sum(integers));
    }

    private Integer sum(List<Integer> integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }
}
