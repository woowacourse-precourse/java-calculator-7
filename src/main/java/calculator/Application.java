package calculator;


import calculator.splitter.AbstractDelimiterSplitter;
import calculator.splitter.CustomDelimiterSplitter;
import calculator.splitter.DefaultDelimiterSplitter;
import calculator.splitter.DelegateDelimiterSplitter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DelegateDelimiterSplitter splitter = new DelegateDelimiterSplitter(splitters());
        Accumulator accumulator = new Accumulator(splitter);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = accumulator.sum(input);
    }

    private static List<AbstractDelimiterSplitter> splitters() {
        return List.of(new CustomDelimiterSplitter(0),
                new DefaultDelimiterSplitter(1));
    }
}
