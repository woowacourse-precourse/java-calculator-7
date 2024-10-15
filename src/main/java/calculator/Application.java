package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 0. 클래스 초기화
        List<Character> delimiters = new ArrayList<>();
        delimiters.add(','); delimiters.add(':');
        LineTokenizer lineTokenizer = new LineTokenizer(delimiters);
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("//", "\\n");

        Calculator calculator = new DelimiterCalculator(delimiterExtractor, lineTokenizer);

        // 1. 사용자로부터 입력을 받는다.
        ConsoleWriter consoleWriter = new ConsoleWriter();
        consoleWriter.writeInputQuery();
        String input = Console.readLine();

        // 2. 계산을 수행한다.
        int result = calculator.calculate(input);

        // 3. 계산 결과를 출력한다.
        consoleWriter.writeResult(result);
        Console.close();
    }
}
