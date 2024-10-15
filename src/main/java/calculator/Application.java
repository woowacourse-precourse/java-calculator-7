package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자로부터 입력을 받는다.
        ConsoleWriter consoleWriter = new ConsoleWriter();
        consoleWriter.writeInputQuery();
        String input = Console.readLine();

        // 2. 계산을 수행한다.
        var delimiters = new ArrayList<Character>();
        delimiters.add(','); delimiters.add(':');
        Calculator calculator = new DelimiterCalculator(delimiters);
        int result = calculator.calculate(input);

        // 3. 계산 결과를 출력한다.
        consoleWriter.writeResult(result);
        Console.close();
    }
}
