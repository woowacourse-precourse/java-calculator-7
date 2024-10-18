package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public List<String> read() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = delimiterExtractor.extractDelimiter(Console.readLine());
        return List.of(input.split(delimiterExtractor.getDelimiter()));
    }
}
