package calculator;

import calculator.io.page.Page;
import calculator.io.page.ReaderPage;
import calculator.io.page.SimpleTextPage;
import calculator.io.page.SimpleTextReaderPage;
import calculator.math.Calculator;
import calculator.math.IntegerCalculator;
import calculator.parser.Parser;
import calculator.parser.StringToIntegerListParser;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자 입력
        ReaderPage<String, String> index = new SimpleTextReaderPage("덧셈할 문자열을 입력해 주세요.\n");
        index.render();
        String input = index.getOutput();

        // 2. 입력값 파싱
        Parser<String, List<Integer>> parser = new StringToIntegerListParser();
        List<Integer> data = parser.parse(input);

        // 3. 입력값 총합 계산 및 출력
        Calculator<Integer> calculator = new IntegerCalculator();
        Integer sum = calculator.sum(data);
        Page<String> result = new SimpleTextPage("결과 : " + sum);
        result.render();
    }
}
